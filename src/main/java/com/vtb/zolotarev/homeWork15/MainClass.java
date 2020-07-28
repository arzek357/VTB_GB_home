package com.vtb.zolotarev.homeWork15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
    public static int checkRepeatNumberNio(File src, String msg) {
        int resultCount = 0;
        byte[] byteMsg = msg.getBytes();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(src, "rw");
             FileChannel fileChannel = randomAccessFile.getChannel()) {
            ByteBuffer mainByteBuffer = ByteBuffer.allocate(8192);
            int bytesRead = fileChannel.read(mainByteBuffer);
            while (bytesRead != -1) {
                mainByteBuffer.flip();
                while (mainByteBuffer.hasRemaining()) {
                    byte[] resultFromBuffer = new byte[msg.length()];
                    if (mainByteBuffer.position() + msg.length() > mainByteBuffer.limit()) {
                        break;
                    }
                    mainByteBuffer.get(resultFromBuffer);
                    if (Arrays.equals(byteMsg, resultFromBuffer)) {
                        resultCount++;
                    } else {
                        mainByteBuffer.position(mainByteBuffer.position() - msg.length() + 1);
                    }
                }
                mainByteBuffer.clear();
                bytesRead = fileChannel.read(mainByteBuffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultCount;
    }

    public static void joinAllFilesFromDirNio(File dir, File dest) {
        List<File> files = new ArrayList<>();
        try {
            files = Files.find(dir.toPath(), 1, (path, basicFileAttributes) -> path.getFileName().toString().matches(".+txt"))
                    .map(Path::toFile)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (RandomAccessFile dst = new RandomAccessFile(dest, "rw");
             FileChannel dstChannel = dst.getChannel()) {
            for (File file : files) {
                try (RandomAccessFile src = new RandomAccessFile(file, "rw");
                     FileChannel srcChannel = src.getChannel()) {
                    srcChannel.transferTo(0, srcChannel.size(), dstChannel);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<File> findAllFilesLessOrEquals(File dir, long kByteSize) {
        List<File> files = new ArrayList<>();
        long sizeInByte = kByteSize * 1024;
        try {
            Files.walkFileTree(dir.toPath(), new FileVisitor<>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.getFileName().toString().matches(".+txt") && Files.size(file) <= sizeInByte) {
                        files.add(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.TERMINATE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return files;
    }
}
