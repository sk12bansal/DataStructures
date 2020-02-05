package streams;

import java.util.*;

public class Sample {
    public static int transform(int n) {
        try { Thread.sleep(1000); } catch(Exception ex) {}
        return n * 1;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /*System.out.println(numbers.parallelStream() //parallelStream instead of stream
                .mapToInt(e -> transform(e))
                .reduce(0, Integer::sum));*/
      Long start = System.currentTimeMillis();
      numbers.parallelStream().forEach(System.out::println);
        /*for(int i=0;i<numbers.size();i++){
            System.out.println(numbers.get(i));
        }*/
      Long end = System.currentTimeMillis();
      System.out.println(end-start);

    }

  /*
  Java Streams:

  The structure of parallel code is the
    same as the structure of sequential code.


  Kotlin Coroutines:
  The structure of asynchronous code is the
    same as the structure of synchronous code.
  */
}

