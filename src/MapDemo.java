import DesignPatterns.AdapterPattern.Pen;

import java.util.HashMap;
import java.util.Map;

class Person {
    String name;
    String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
public class MapDemo {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String []args){
        Map<Person ,String> m = new HashMap<>();
        Person p1 = new Person("Suraj","45");
        Person p2 = new Person("Suraj","45");
        m.put(p1,"ramu");
        m.put(p2,"Shyam");
        for(Map.Entry o1 : m.entrySet()){
            System.out.println(o1.getKey() + " " +  o1.getValue());
        }
        System.out.println(m.get(p2));

    }
}
