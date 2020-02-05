package impQuestions;

public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0){
            return false;
        }
        int col = matrix[0].length;
        int i=0;
        int j=col-1;
        while(i<row && j<col && j>=0){
            int curr= matrix[i][j];
            if(target<curr){
                j = j-1;
            }else if(target>curr){
                i=i+1;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.out.println(searchMatrix(mat,3));
        System.out.println(searchMatrix(mat,13));
    }
}
