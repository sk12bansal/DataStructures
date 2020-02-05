package impQuestions;

import java.util.Scanner;

public class AddTwoFractions {

    private static int gcd(int den1, int den2) {
        if(den1 ==0){
            return den2;
        }
        return gcd(den2%den1,den1);
    }

    private static void reduceFactor(int num3, int den3) {
        int gcd = gcd(num3,den3);

        num3 = num3/gcd;
        den3 = den3/gcd;
        System.out.println(num3+"/"+den3);
    }


    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int den1 = sc.nextInt();
        int num2 = sc.nextInt();
        int den2 = sc.nextInt();

        int gcd = gcd(den1,den2);

        int lcm = (den1 * den2)/gcd;

        System.out.println(lcm);

        int num3 = num1 * (den1/lcm) + num2 * (den2/lcm);
        reduceFactor(num3,lcm);
    }
}
