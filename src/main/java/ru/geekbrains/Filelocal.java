package ru.geekbrains;

import javax.sql.rowset.spi.SyncResolver;
import java.io.File;
import java.security.PublicKey;

public class Filelocal implements Size{

    private String filename;
    private long size;

    public Filelocal(File file){
        this.filename = file.getName();
        this.size = file.length();
    }

    @Override
    public long calculateSize() {
        System.out.println("Файл " + filename + ", размер: " + size);
        return size;
    }
}
