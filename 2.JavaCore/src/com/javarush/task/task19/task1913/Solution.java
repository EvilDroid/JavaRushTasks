package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

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

        //работаем с перехваченными данными
        System.out.println(findDigitsInString(result));


    }

    public static String findDigitsInString (String input){
        StringBuffer strBuf = new StringBuffer();
        char [] arr =  input.toCharArray();
        for (char n : arr) {
            if(isCharInt(n)){
                strBuf.append(n);
            }
        }
        return strBuf.toString();
    }

    public static boolean isCharInt(char s) {
        try
        {
            Integer.parseInt(String.valueOf(s));
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
