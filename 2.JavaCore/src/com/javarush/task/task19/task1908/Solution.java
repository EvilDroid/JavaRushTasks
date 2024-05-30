package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        //filename reading from console
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        //       2.JavaCore/src/resources/FileReaderTestFindNumbers.txt
        String filename2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        //       2.JavaCore/src/resources/FileWriterTestFindNumbers.txt
        bufferedReader.close();

        //file reading
        StringBuffer fileContent = new StringBuffer("");
        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        char currentChar;
        while (fileReader.ready()) {
            currentChar = (char)fileReader.read();
            fileContent.append(currentChar);
        }
        fileReader.close();


        //find numbers in string
        ArrayList<Integer> numbArray = findNumbersInString(fileContent.toString());

        StringBuffer numbs = new StringBuffer("");
        for (Integer n : numbArray){
            numbs.append(n);
            numbs.append(" ");
        }


        //file writing
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename2))) {
            fileWriter.write(numbs.toString());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Integer> findNumbersInString(String text) {
        ArrayList <Integer> numbersArray = new ArrayList<>();
        String[] arrayFromString = text.split(" ");
        for (String s : arrayFromString){
            if (isStringInt(s)){
                numbersArray.add(Integer.parseInt(s));
            }
        }
        return numbersArray;
    }

    public static boolean isStringInt(String s) {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }
}
