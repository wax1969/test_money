package com.company.test;


import java.util.HashMap;
import java.util.Scanner;

public class Main {

   static HashMap<String,Double> values = new HashMap<>();

    public static void main(String[] args) {
	    System.out.println("Enter, please, sum and valute, for exit empty value :");
        Scanner scanner = new Scanner(System.in);
        String value = "";
        while (scanner.hasNextLine() && !(value = scanner.nextLine().trim()).isEmpty())
        {
            System.out.println(value);
            String[] parts = value.split(" ");

            if (parts.length != 2)
            {
                System.out.println("Error: incorrect count of parameters, exit...");
                System.exit(2);
            }

            String valute = parts[0].trim().toUpperCase();
            Double sum = values.get(valute);
            try {
                if (sum == null) {
                    sum = Double.parseDouble(parts[1].trim());
                } else {
                    sum += Double.parseDouble(parts[1].trim());
                }
            } catch (NumberFormatException e)
            {
                System.out.println("Error: incorrect format of sum, exit...");
                System.exit(1);
            }

            values.put(valute,sum);
        }

        for (String valute:values.keySet())
        {
            System.out.println(valute+" "+values.get(valute));
        }
    }
}
