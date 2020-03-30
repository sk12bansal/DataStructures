package dp;

public class LongestCommonPrefix {
    public static void main(String []args){
        String [] strs = {"flower","flow","flight"};
        String pre = strs[0];
        int i=1;
        while(i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
            //System.out.println(strs[i].indexOf(pre));
                pre = pre.substring(0, pre.length()-1);
                //System.out.println(strs[i].indexOf(pre));
                System.out.println(pre);
            }
            System.out.println("==========");
            i++;
        }
        //System.out.println("flight".indexOf("fl"));
        //System.out.println("flight".indexOf("ig"));
        //System.out.println("flight".indexOf("ht"));
    }
}
