package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

//not resolved

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        //BufferedReader from console
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //       2.JavaCore/src/resources/FileEditingCheckFile1.txt
        String fileName1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        //       2.JavaCore/src/resources/FileEditingCheckFile2.txt
        String fileName2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        bufferedReader.close();

        //Reading files
        ArrayList<String> file1Lines = fileReaderToLineArr(fileName1);
        ArrayList<String> file2Lines = fileReaderToLineArr(fileName2);

        int pointer1 = 0;
        int pointer2 = 0;

        for (int i = 0; i < file1Lines.size(); i++){

            if(file1Lines.get(i).equals(file2Lines.get(i))){
                lines.add(new LineItem(Type.SAME, file1Lines.get(i)));
                //SAME
            } else{

                if ((i + 1) >= file2Lines.size()){
                    break;
                } else {
                    if(file1Lines.get(i).equals(file2Lines.get(i + 1))){
                        lines.add(new LineItem(Type.ADDED, file2Lines.get(i)));
                        //ADDED
                        lines.add(new LineItem(Type.SAME, file1Lines.get(i)));
                        //SAME
                    }
                }


                if ((i + 1) >= file1Lines.size()){
                    break;
                } else {
                    if(file1Lines.get(i+1).equals(file2Lines.get(i))){
                        lines.add(new LineItem(Type.REMOVED, file1Lines.get(i)));
                        //REMOVED
                    }
                }



            }


        }

        System.out.println("end");

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }


    public static ArrayList<String> fileReaderToLineArr (String fileName) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        //buffered FileReader
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}
