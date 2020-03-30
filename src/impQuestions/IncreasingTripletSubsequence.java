package impQuestions;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for(int n:nums){
            if(n<=small){
                small = n;
            }else if(n<=big){
                big=n;
            }else{
                return true;
            }

        }
        return false;
    }
    public static void main(String []args){
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1,2,3}));
    }
}
