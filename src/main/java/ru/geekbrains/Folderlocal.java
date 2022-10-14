package ru.geekbrains;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Folderlocal implements Size{

    private String foldername;
    private List<Size> c;

    public Folderlocal(File foldername){
        this.foldername = foldername.getName();
        this.c = new ArrayList<>();
    }

    public void add(Size e){
        this.c.add(e);
    }

    public void remove(Size e){
        this.c.remove(e);
    }

    public List<Size> getC(){
        return this.c;
    }

    public String getFoldername(){
        return this.foldername;
    }

    @Override
    public long calculateSize() {
        long s = 0L;
        for(Size si : this.c){
            s += si.calculateSize();
        }
        System.out.println("Директория " + this.foldername + ", размер: " + s);
        return s;
    }
}
