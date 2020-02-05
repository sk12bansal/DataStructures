import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String args[]){
        List<String> l1 =new ArrayList<>();
        l1.add("name 1");
        System.out.println(l1.size());
        m2(l1);
        System.out.println("After change "+l1.size());
    }

    private static void m2(List<String> l2) {
        List<String> l3 =l2;
        l3.add("name 1");
        l2.add("name 2");
        System.out.println(l2.size());
        System.out.println(l3.size());
        l2 =null;
        System.out.println(l3.size());
        System.out.println(l2.size());
    }
}
