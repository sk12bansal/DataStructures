package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class RightView {

    public static void main(String []args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        //printLeftView(root);
        //printRightView(root);
        //printRootToLeafPath(root);
        printPathSum(root);
    }

    private static void printPathSum(Node root) {
        Stack<Node> s = new Stack<>();
        printPathSumHelper(root,s,17);
    }

    private static void printPathSumHelper(Node root, Stack<Node> s, int sum) {
        if(root == null)
            return;
        sum = sum - root.data;
        s.push(root);
        if(sum ==0){
            for (Node node : s) {
                System.out.print(node.data + " ");
            }
            System.out.println();
            return;
        }
        printPathSumHelper(root.left,s,sum);
        printPathSumHelper(root.right,s,sum);
        s.pop();

    }

    private static void printRootToLeafPath(Node root) {

        Stack<Node> s = new Stack<>();
        printPath(root,s);
    }

    private static void printPath(Node root, Stack<Node> s) {
        if(root == null)
            return;
        s.push(root);
        printPath(root.left,s);
        if(root.left == null && root.right == null){
            for (Node node : s) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
        printPath(root.right,s);
        s.pop();
    }

    private static void printLeftView(Node root) {
        if(root ==null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        System.out.println("===Left View of Binary Tree===");
        while(!q.isEmpty()){
           Node tmp =q.peek();
           if(tmp !=null){
               System.out.print(tmp.data + " ");
               while(q.peek()!=null){
                   if(tmp.left!=null)
                       q.add(tmp.left);
                   if(tmp.right!=null)
                       q.add(tmp.right);
                   q.remove();
               }
               q.add(null);
           }else {
               q.remove();
           }
        }

    }

    private static void printRightView(Node root) {

        if(root ==null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        System.out.println();
        System.out.println("===Right View of Binary Tree===");
        while(!q.isEmpty()){
            int size = q.size();
            if(size == 0){
                break;
            }
            Node tmp = null;
            while(size>0){
                tmp = q.poll();
                if(tmp.left!=null)
                    q.add(tmp.left);
                if(tmp.right!=null)
                    q.add(tmp.right);
                size--;
            }
            System.out.print(tmp.data + " ");
        }
    }
}
