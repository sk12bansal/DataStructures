package javaconcepts;

import java.util.HashMap;
import java.util.Iterator;

public final class FinalExample {
    private final int id;
    private final String name;
    private final HashMap<String, String> hashMap;


    public FinalExample(int id, String name, HashMap<String, String> hm) {
        this.id = id;
        this.name = name;
        HashMap<String, String> tempMap = new HashMap<>();
        Iterator<String> it = hm.keySet().iterator();
        String key;
        while (it.hasNext()) {
            key = it.next();
            tempMap.put(key, hm.get(key));
        }
        this.hashMap = tempMap;  // Deep Copy
        //this.hashMap = hashMap; // shallow copy
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTestMap() {
        return hashMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String, String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i = 10;

        FinalExample ce = new FinalExample(i, s, h1);

        //Lets see whether its copy by field or reference
        System.out.println(s == ce.getName());
        System.out.println(h1 == ce.getTestMap());
        //print the ce values
        System.out.println("ce id:" + ce.getId());
        System.out.println("ce name:" + ce.getName());
        System.out.println("ce testMap:" + ce.getTestMap());
        //change the local variable values
        i = 20;
        s = "modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:" + ce.getId());
        System.out.println("ce name after local variable change:" + ce.getName());
        System.out.println("ce testMap after local variable change:" + ce.getTestMap());

        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:" + ce.getTestMap());

    }
}
