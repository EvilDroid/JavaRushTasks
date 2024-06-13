package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);

        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем какой-либо вывод, который ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray перехваченные данные в строку
        String result = outputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);

        //Читаем имя файла
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine(); //читаем строку с клавиатуры
        bufferedReader.close();

        //работаем с перехваченными данными
        saveToFile(fileName, result);
        System.out.print(result);

    }

    public static void saveToFile (String filename, String input) throws IOException {
        String fileFullAdress = "2.JavaCore/src/resources/" + filename + ".txt";
        new File(fileFullAdress);
        try (FileOutputStream fos = new FileOutputStream(fileFullAdress)) {
            fos.write(input.getBytes());
        }
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

