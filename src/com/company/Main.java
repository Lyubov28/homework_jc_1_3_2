package com.company;

import java.io.IOException;

import static com.company.GameProgress.*;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        String Directory = "C:\\Users\\Akimo\\OneDrive\\Рабочий стол\\Games\\savegames\\";

        GameProgress game1 = new GameProgress(10, 10, 3, 4.5);
        GameProgress game2 = new GameProgress(30, 50, 4, 8.35);
        GameProgress game3 = new GameProgress(20, 10, 8, 9.57);

        game1.saveGame("C:\\Users\\Akimo\\OneDrive\\Рабочий стол\\Games\\savegames\\save1.dat");
        game2.saveGame("C:\\Users\\Akimo\\OneDrive\\Рабочий стол\\Games\\savegames\\save2.dat");
        game3.saveGame("C:\\Users\\Akimo\\OneDrive\\Рабочий стол\\Games\\savegames\\save3.dat");

        zipFiles(Directory);

    }
}


