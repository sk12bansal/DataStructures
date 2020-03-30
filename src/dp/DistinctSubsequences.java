package dp;

public class DistinctSubsequences {

    public static int numDistinct(String s, String t) {
        int [][]dp = new int[t.length()+1][s.length()+1];
        for(int i=0;i<=s.length();i++){
            dp[0][i] = 1;
        }
        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                if(t.charAt(i)==s.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
                }else{
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }

        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String []args){
        System.out.println(numDistinct("rabbbit","rabbit"));
    }
}
