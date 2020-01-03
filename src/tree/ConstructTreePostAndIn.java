package tree;

public class ConstructTreePostAndIn {
    static int postIndex;

    public static void main(String[] args) {
        int[] inorder = {19, 35, 4, 3, 7, 5, 13, 20, 15, 25};
        int[] postorder = {19, 35, 4, 7, 20, 25, 15, 13, 5, 3};
        postIndex = postorder.length-1;
        TreeNode root = makeTree(postorder, inorder, 0, postorder.length - 1);
        printInorder(root);
    }

    private static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    private static TreeNode makeTree(int[] postorder, int[] inorder, int start, int end) {
        if (start > end || postIndex<0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postIndex--]);

        if(start == end){
            return node;
        }
        int inIndex = search(inorder, node.data);
        node.left = makeTree(postorder, inorder, start, inIndex - 1);
        node.right = makeTree(postorder, inorder, inIndex + 1, end);
        return node;
    }

    private static int search(int[] inorder, int data) {
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == data) {
                return i;
            }
        }
        return i;
    }
}
