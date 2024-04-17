package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
Console reading
File reading
File writing (byte)
Even/Odd check
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        //"2.JavaCore/src/resources/FileReaderTest.txt"

        String filename2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        //"2.JavaCore/src/resources/FileWriterTest.txt"
        bufferedReader.close();

        ArrayList<Integer> list = new ArrayList<Integer>();
        FileReader fileReader = new FileReader(filename1);
        while (fileReader.ready()) {
            list.add(fileReader.read());
        }
        fileReader.close();

        FileWriter fileWriter = new FileWriter(filename2);
        for (int i = 0; i < list.size(); i++){
            if ((i+1) % 2 == 0) {
                int symbol = list.get(i);
                fileWriter.write(symbol);
            }
        }
        fileWriter.close();
    }
}
