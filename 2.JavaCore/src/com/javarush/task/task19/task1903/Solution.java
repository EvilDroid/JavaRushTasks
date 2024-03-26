package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/



public class Solution {




    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }



    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        public IncomeDataAdapter (IncomeData incomeData){
            this.data = incomeData;

        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            int code = data.getCountryPhoneCode();
            int phoneNumber = data.getPhoneNumber();
            String phoneNumber10 = String.format("%010d", phoneNumber);
            String phoneNumberString = String.valueOf(phoneNumber10);
            String part_1 = String.valueOf(phoneNumberString.toCharArray(), 0, phoneNumberString.length() - 7);
            String part_2 = String.valueOf(phoneNumberString.toCharArray(), phoneNumberString.length() - 7, 7);
            String phoneNumberFormatted = String.format("+%s(%s)%s-%s-%s", code, part_1, part_2.substring(0, 3), part_2.substring(3, 5), part_2.substring(5));
            return phoneNumberFormatted;
        }


    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}