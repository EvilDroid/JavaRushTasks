package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
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
        System.out.print(solveTheEquation(result));


    }

    public static String solveTheEquation (String input){
        String result = "";
        String [] splitedInput = input.split(" ");
        int a = Integer.parseInt(splitedInput[0]);
        char expressionSymbol = splitedInput[1].charAt(0);
        int b = Integer.parseInt(splitedInput[2]);

        switch(expressionSymbol){
            case ('+'):
                result = String.valueOf(a + b);
                break;
            case ('-'):
                result = String.valueOf(a - b);
                break;
            case ('*'):
                result = String.valueOf(a * b);
                break;
            default:
                System.out.println("expressionSymbol incorrect");
                break;
        }

        return input.replace("\r\n", "") + result;
    }



    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

