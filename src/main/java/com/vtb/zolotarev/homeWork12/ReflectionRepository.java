package com.vtb.zolotarev.homeWork12;

import com.vtb.zolotarev.homeWork12.annotations.DbColumn;
import com.vtb.zolotarev.homeWork12.annotations.DbTable;
import com.vtb.zolotarev.homeWork12.exceptions.InvalidBdTableException;
import com.vtb.zolotarev.homeWork12.exceptions.InvalidColumnTypeException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionRepository<T> {
    private Connection connection;
    private final String tableName;
    private final Class<T> myClass;
    private final ArrayList<Field> fields;

    public ReflectionRepository(Class<T> myClass) {
        if (!myClass.isAnnotationPresent(DbTable.class)) {
            throw new InvalidBdTableException("@DbTable annotation not found!");
        }
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.err.println("Не найден драйвер для подключения к базе данных!");
        }
        this.myClass = myClass;
        tableName = myClass.getAnnotation(DbTable.class).name();
        fields = Arrays.stream(myClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(DbColumn.class)).collect(Collectors.toCollection(ArrayList::new));
    }

    public T save(T object) {
        connectToDb();
        try (
                PreparedStatement ps = connection.prepareStatement(createSqlForStatement());
                Statement statement = connection.createStatement();
        ) {
            fillAndExecutePreparedStatement(ps, object);
            try (ResultSet rs = statement.executeQuery(String.format("SELECT * FROM %s ORDER BY id DESC LIMIT 1", tableName))) {
                return fillEntityFromDb(rs);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnectFromDb();
        }
        return null;
    }

    public T findByIdOrNull(Long id) {
        connectToDb();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE id = %d;", tableName, id))) {
            return fillEntityFromDb(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnectFromDb();
        }
        return null;
    }

    public void clearTable() {
        connectToDb();
        try (Statement statement = connection.createStatement()) {
            statement.execute(String.format("DELETE FROM %s", tableName));
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnectFromDb();
        }
    }

    public void deleteById(long id) {
        connectToDb();
        try (Statement statement = connection.createStatement()) {
            statement.execute(String.format("DELETE FROM %s WHERE id = %d", tableName, id));
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnectFromDb();
        }
    }

    public List<T> findAll() {
        connectToDb();
        List<T> allObjects = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(String.format("SELECT * FROM %s", tableName))) {
            while (rs.next()) {
                allObjects.add(fillEntityFromDb(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnectFromDb();
        }
        return allObjects;
    }

    private void connectToDb() {
        try {
            connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s.db", tableName));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void disconnectFromDb() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private String createSqlForStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO %s", myClass.getAnnotation(DbTable.class).name())).append(" (");
        for (Field field : fields) {
            sb.append(String.format("%s, ", field.getName()));
        }
        sb.delete(sb.length() - 2, sb.length() - 1).append(") VALUES (");
        sb.append("?, ".repeat(fields.size()));
        sb.delete(sb.length() - 2, sb.length() - 1).append(");");
        return sb.toString();
    }

    private void fillAndExecutePreparedStatement(PreparedStatement ps, T object) throws SQLException {
        try {
            for (int i = 0; i < fields.size(); i++) {
                Field objField = object.getClass().getDeclaredField(fields.get(i).getName());
                if (!objField.canAccess(object)) {
                    objField.setAccessible(true);
                }
                if (fields.get(i).getType().equals(String.class)) {
                    ps.setString(i + 1, (String) objField.get(object));
                } else if (fields.get(i).getType().isPrimitive()) {
                    ps.setInt(i + 1, (Integer) objField.get(object));
                } else {
                    throw new InvalidColumnTypeException("Поле имеет неизвестный тип!");
                }
            }
            ps.execute();
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            System.err.println("Поддерживает только примитивные типы, наследуемые от класа Number!");
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private T fillEntityFromDb(ResultSet resultSet) {
        try {
            T o = myClass.getConstructor().newInstance();
            Field[] fieldsOfObject = o.getClass().getDeclaredFields();
            for (int i = 0; i < fieldsOfObject.length; i++) {
                fieldsOfObject[i].setAccessible(true);
                fieldsOfObject[i].set(o, resultSet.getObject(i + 1));
            }
            return o;
        } catch (SQLException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
