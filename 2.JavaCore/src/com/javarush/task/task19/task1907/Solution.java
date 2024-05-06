package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.ArrayList;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {


        //reading filename
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        //"2.JavaCore/src/resources/WorldWordsCount.txt"
        bufferedReader.close();

        //reading file
        StringBuffer fileContent = new StringBuffer("");
        FileReader fileReader = new FileReader(filename1);
            char currentChar;
        while (fileReader.ready()) {
            currentChar = (char)fileReader.read();
            fileContent.append(currentChar);
        }
        fileReader.close();

        //counting
        System.out.println(targetWordCounterInString(fileContent.toString(), "world"));


    }

    public static int targetWordCounterInString (String str, String target){
        int count = 0;
        String replacedString = str.replaceAll("\\p{P}", " ").replaceAll("\\s", " ");
        for (String x : replacedString.split(" ")) {
            if (x.equals(target)) {
                count++;
            }
        }
        return count;
    }
}
