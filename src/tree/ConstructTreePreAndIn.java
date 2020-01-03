package tree;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class ConstructTreePreAndIn {
    public static void main(String[] args) {
        int[] inorder = {19, 35, 4, 3, 7, 5, 13, 20, 15, 25};
        int[] preorder = {3, 4, 35, 19, 5, 7, 13, 15, 20, 25};
        TreeNode root = makeTree(preorder, inorder, 0, preorder.length-1);
        printInorder(root);
    }

    private static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    static int preIndex = 0;

    private static TreeNode makeTree(int[] preorder, int[] inorder, int start, int end) {

        if (start > end ) {
            return null;
        }
        int data = preorder[preIndex++];
        TreeNode root = new TreeNode(data);
        if (start == end) {
            return root;
        }
        int inIndex = search(inorder, data);
        root.left = makeTree(preorder, inorder, start, inIndex - 1);
        root.right = makeTree(preorder, inorder, inIndex + 1, end);
        return root;
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
