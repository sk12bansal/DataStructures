package impQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
    public static void  main(String []args){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5);
        queue.add(4);
        queue.offer(6);
        System.out.println(queue);
    }
}
