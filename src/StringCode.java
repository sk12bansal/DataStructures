import java.util.*;
import java.io.*;

class StringCode {

    public static String MissingDigit(String str) {
        // code goes here

        String[] digits = str.split("=");
        String[] numbers = digits[0].split(" ");

        if (digits[1].trim().equals("x")) {
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[2]);
            int ans  = calculateAns(a,numbers[1],b);
            System.out.println(ans);
        }
        if(numbers[0].equals("x")){
            int a = Integer.parseInt(numbers[2]);
            int b = Integer.parseInt(digits[1]);
            int ans  = calculateAns(a,numbers[1],b);
            System.out.println(ans);
        }

        // for(int i=0;i<len;i++){
        //   if(digits[i]!= " " && digits[i] == "x"){
        //     index = i;
        //     break;
        //   }
        // }
        // int ans = Integer.valueOf(digits[4]) + Integer.valueOf(digits[1]) + Integer.valueOf(digits[2]);
        // System.out.println(Integer.valueOf(digits[4]));
        // System.out.println(digits[1]);
        // System.out.println(Integer.valueOf(digits[2]));
        // switch(index){
        //   case 0:
        //         ans = String.valueOf(digits[4]) + String.valueOf(digits[1]) + String.valueOf(digits[2]);
        // }

        return "";
    }

    private static int calculateAns(int a, String number, int b) {
        switch (number) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return -1;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(MissingDigit("30 - 4 = x"));
    }

}
