package impQuestions;

public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1,int start_a,int end_a, int[] nums2,int start_b,int end_b) {
        if(end_a-start_a==1 && end_b-start_a==1){
            return (1.0 *(Math.max(nums1[start_a],nums2[start_b]) + Math.min(nums1[end_a],nums2[end_b])))/2;
        }
        int m1_ind = (start_a + end_a)/2;
        int m2_ind = (start_b + end_b)/2;

        int m1 = nums1[m1_ind];
        int m2 = nums2[m2_ind];
        if(m1 == m2){
            return  m1;
        }

        if(m1<m2){
            start_a = m1_ind;
            end_b = m2_ind;
        }else{
            end_a  =m1_ind;
            start_b = m2_ind;
        }
        return findMedianSortedArrays(nums1,start_a,end_a,nums2,start_b,end_b);
    }
    public static void main(String []args){
        int [] nums1 = {1, 2};
        int [] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1,0,nums1.length-1,nums2,0,nums2.length-1));
    }
}
