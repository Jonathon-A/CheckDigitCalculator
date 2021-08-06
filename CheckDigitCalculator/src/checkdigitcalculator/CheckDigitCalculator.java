package checkdigitcalculator;

import java.time.format.FormatStyle;
import java.util.Scanner;

public class CheckDigitCalculator {

    public static void main(String[] args) {

        String strcode = "";

        Scanner input = new Scanner(System.in);
        System.out.println("This program will calculate a check digit for your number.");
        String format = "incorrect";
        int length = 0;
        while (format.equals("incorrect")) {
            System.out.println("Please enter your number in GTIN-8,GTIN-12,GTIN-13,GTIN-14,GSIN,SSCC format without the check digit");

            long code = 0;
            boolean valid = false;
            do {
                try {
                    code = input.nextLong();
                    valid = true;
                } catch (Exception e) {

                    System.out.println("Incorrect input");
                    System.out.println("Please enter your number in GTIN-8,GTIN-12,GTIN-13,GTIN-14,GSIN,SSCC format without the check digit");
                    input.next();
                }

            } while (!valid);

            strcode = Long.toString(code);
            length = strcode.length();

            switch (length) {
                case (8):
                    format = "GTIN-8";
                    break;

                case (12):
                    format = "GTIN-12";
                    break;
                case (13):
                    format = "GTIN-13";
                    break;
                case (14):
                    format = "GTIN-14";
                    break;
                case (16):
                    format = "GSIB";
                    break;
                case (17):
                    format = "SSCC";
                    break;
                default:
                    System.out.println("Format is incorrect");
                    break;
            }

        }
        System.out.println("Calulating check digit for " + format + " format...");
        int total = 0;
        for (int i = 0; i < length; i++) {
            String x = strcode.substring(i, i + 1);
            int sx = Integer.parseInt(x);
            if ((i % 2) == 1) {
                int y = sx * 3;
                total = total + y;
            } else {
                if ((i % 2) == 0) {
                    int y = sx * 1;
                    total = total + y;
                }

            }

        }
        //I have no idea if the check digit is correct, did this a while ago
        System.out.println(total);
    }
}
