public class SegmentTree {

    public static void main(String [] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        int[] tree = new int[2 * n];

        buildTree(arr, tree, 0, n - 1, 1);
        for (Integer i :tree)
            System.out.println(i);
    }

    private static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode) {

        if(start == end){
            tree[treeNode] = arr[start];
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr,tree,start,mid,2*treeNode);
        buildTree(arr,tree,mid+1,end,2*treeNode+1);
        tree[treeNode] = tree[2*treeNode] +tree[2*treeNode+1];
    }
}
