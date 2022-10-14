package ru.geekbrains;

import java.io.File;

public class App {

        public static void main(String[] args) {
            File folder = new File(System.getProperty("user.dir"));
            Folderlocal folderlocal = new Folderlocal(folder);

            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {

                    folderlocal.add(new Folderlocal(fileEntry));
                } else {
                    folderlocal.add(new Filelocal(fileEntry));
                }
            }
            long totalSize = folderlocal.calculateSize();
            System.out.println("Общий размер: " + totalSize);
        }
}
