package com.vtb.zolotarev.homeWork14;

import java.io.*;

public class MainClass {
    public static void main(String[] args) {
        joinAllFilesFromDir(new File("src/main/resources/rhomeWork14/task2directory"), new File("src/main/resources/rhomeWork14/task2result.txt"));
        fullDeleteDir(new File("src/main/resources/rhomeWork14"));
    }

    public static int checkRepeatNumber(File file, String msg) {
        int resultCount = 0;
        try (BufferedReader rs = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = rs.readLine()) != null) {
                sb.append(str);
            }
            while (sb.lastIndexOf(msg) != -1) {
                resultCount++;
                sb.delete(sb.lastIndexOf(msg), sb.lastIndexOf(msg) + msg.length());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultCount;
    }

    public static void joinAllFilesFromDir(File dir, File dest) {
        File[] files = dir.listFiles();
        StringBuilder sb = new StringBuilder();
        if (files == null) {
            System.out.println("Пустая директория!");
            return;
        }
        try {
            if (!dest.exists()) {
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                dest.createNewFile();
            }
        } catch (IOException ex) {
            System.out.println("Файл для записи не существует и не может быть создан по данному пути!");
            ex.printStackTrace();
        }
        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            }
            try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
                String str;
                while ((str = bf.readLine()) != null) {
                    sb.append(str).append("\n");
                }
            } catch (IOException ex) {
                System.out.println(String.format("Ошибка при чтении данных из файла %s", file.getName()));
                ex.printStackTrace();
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {
            bw.write(sb.toString());
        } catch (IOException ex) {
            System.out.println(String.format("Ошибка при записи в файл %s", dest.getName()));
            ex.printStackTrace();
        }
    }

    public static void fullDeleteDir(File dir) {
        dirDelete(dir);
        dir.delete();
    }
    private static void dirDelete(File dir){
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Пустая директория!");
            return;
        }
        for (File file:files){
            if (file.isDirectory()){
                dirDelete(file);
            }
            file.delete();
        }
    }
}
