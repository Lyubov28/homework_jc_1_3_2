package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }


    void saveGame(String rootDirectory) {
        try (FileOutputStream fos = new FileOutputStream(rootDirectory);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    static void zipFiles(String Directory) throws IOException {
        File filesDir = new File(Directory);
        String[] fileList = filesDir.list();
        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(Directory + "zip.zip"));
        for (String file : fileList) {
            String fileName = new File(file).getPath();
            try (FileInputStream fis = new FileInputStream(Directory + fileName)) {
                ZipEntry entry = new ZipEntry(file);
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        zout.close();


        for (String file : fileList) {
            String fileName = new File(file).getPath();
            try {
                Files.delete(Paths.get(Directory + fileName));
            } catch (IOException x) {
                System.err.println(x.getMessage());
            }
        }
    }


}
