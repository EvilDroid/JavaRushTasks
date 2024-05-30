package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        //BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //       2.JavaCore/src/resources/FileReaderTestReplaceSymbols.txt
        String fileName1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        //       2.JavaCore/src/resources/FileWriterTestReplaceSymbols.txt
        String fileName2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        bufferedReader.close();

        //buffered FileReader
        String fileContent = "";
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        String line;
        while ((line = reader.readLine()) != null) {
            fileContent = fileContent + line;
        }
        reader.close();
        System.out.println(fileContent);

        //replacing symbols
        String correctedFileContent = fileContent.replace(".","!");
        System.out.println(correctedFileContent);

        //buffered
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2))) {
            fileWriter.write(correctedFileContent);
        }

    }
}
