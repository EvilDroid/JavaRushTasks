package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner scanner){
            this.fileScanner = scanner;

        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String[] splitLine = line.split(" ");
            String firstName = splitLine[1];
            String middleName = splitLine[2];
            String lastName = splitLine[0];
            Calendar calendar = new GregorianCalendar(Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[4]) - 1, Integer.parseInt(splitLine[3]));
            Date date = calendar.getTime();
            Person person = new Person(firstName, middleName, lastName, date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
