package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<SanPham> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static List<SanPham> readDataFromList(String path) {
        List<SanPham> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<SanPham>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<SanPham> list = new ArrayList<>();
        list.add(new SanPham("1", "banh", "lizada", 6000));
        list.add(new SanPham("2", "keo", "lizada", 7000));

        writeToFile("sanPham.txt", list);
        List<SanPham> listDataFromFile = readDataFromList("sanPham.txt");
        for (SanPham sp : listDataFromFile) {
            System.out.println(sp);
        }
    }
}
