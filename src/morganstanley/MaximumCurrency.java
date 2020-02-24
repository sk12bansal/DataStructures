package morganstanley;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Currency{
    double value;
    String coinsType;

    public Currency(double value, String coinsType) {
        this.value = value;
        this.coinsType = coinsType;
    }
}

public class MaximumCurrency {
    public static double getValue(Map<String, Currency> mp, Currency conversionRate1, String coinsType, String convertCoinType){
        double tmp1=0;
        if(coinsType.equals("USD") && convertCoinType.equals("AUD")){
            tmp1 = mp.get(convertCoinType).value/4;
            double tmp2 = (mp.get("EUR1").value *10)/15 * 2;
            tmp1 = Math.max(tmp1,tmp2);
        }else {
            String type = conversionRate1.coinsType;
            tmp1 = conversionRate1.value;
            while (!type.equals(convertCoinType)) {
                if (type.equals("INR")) {
                    break;
                }
                tmp1 = tmp1 * mp.get(type).value;
                type = mp.get(type).coinsType;
            }
        }
        return tmp1;
    }
    private static String calculateMaximumValue(Map<String, Currency> mp, int numberOfCoins, String coinsType, String convertCoinType) {
        double ans = 0;
        switch (coinsType){
            case "USD":
                ans = numberOfCoins * getValue(mp,mp.get("USD"),coinsType,convertCoinType);
                break;
            case "AUD":
                ans = numberOfCoins * getValue(mp,mp.get("AUD"),coinsType,convertCoinType);
                break;
            case "EUR":
                    Currency conversionRate1 = mp.get("EUR1");
                    Currency conversionRate2 = mp.get("EUR2");
                    ans = numberOfCoins * Math.max(getValue(mp,conversionRate1,coinsType,convertCoinType), getValue(mp,conversionRate2,coinsType,convertCoinType));
                break;
        }
        return ans + " " + convertCoinType;
    }
    public static void main(String []args){
        Map<String,Currency> mp = new HashMap<>();
        mp.put("USD",new Currency(70,"INR"));
        mp.put("AUD",new Currency(2,"USD"));
        mp.put("EUR1",new Currency(1.5,"USD"));
        mp.put("EUR2",new Currency(2,"AUD"));
        Scanner sc= new Scanner(System.in);
        String query = sc.nextLine().trim();
        String [] arr = query.split("->");
        int numberOfCoins = Integer.parseInt(arr[0].split(" ")[0]);
        String coinsType = arr[0].split(" ")[1];
        String convertCoinType = arr[1].split(" ")[1];
        String ans = calculateMaximumValue(mp,numberOfCoins,coinsType,convertCoinType);
        System.out.println(ans);
    }
}
