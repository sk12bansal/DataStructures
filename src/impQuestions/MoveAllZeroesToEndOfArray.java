package impQuestions;

public class MoveAllZeroesToEndOfArray {
    public static void main(String []args){
        int [] nums = {3,5,0,0,4};
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                c++;
            }else {
                System.out.print(nums[i] + " ");
            }
        }
        while (c>0){
            System.out.print("0" + " ");
            c--;
        }
        System.out.println();
    }
}
