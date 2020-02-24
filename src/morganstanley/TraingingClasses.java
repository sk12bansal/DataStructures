package morganstanley;

import java.util.*;

class Trainer {
    int id;
    String name;
    int charge;
    boolean visited;

    public Trainer(int id,String name, int charge) {
        this.id =id;
        this.name = name;
        this.charge = charge;
        this.visited = false;
    }
}
public class TraingingClasses {
    static void sortList(List<Trainer> list){
        list.sort(new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return o1.charge - o2.charge;
            }
        });
    }
    public static void main(String []args){
        Map<String, List<Trainer>> map = new HashMap<>();
        List<Trainer> list1 = new ArrayList<>();
        list1.add(new Trainer(0,"Joel",2000));
        list1.add(new Trainer(0,"Andy",3500));
        //list1.add(new Trainer(0,"Ricky",8000));
        //list1.add(new Trainer(0,"Sachin",9000));
        sortList(list1);
        map.put("Java",list1);
        List<Trainer> list2 = new ArrayList<>();
        list2.add(new Trainer(1,"Joel",5000));
        list2.add(new Trainer(1,"Andy",4000));
        //list2.add(new Trainer(1,"Ricky",6000));
        //list2.add(new Trainer(1,"Sachin",2000));
        sortList(list2);
        map.put("Angular",list2);
        /*List<Trainer> list3 = new ArrayList<>();
        list3.add(new Trainer(2,"Joel",8000));
        list3.add(new Trainer(2,"Andy",9000));
        list3.add(new Trainer(2,"Ricky",8000));
        list3.add(new Trainer(2,"Sachin",1000));
        sortList(list3);
        map.put("Database",list3);
        List<Trainer> list4 = new ArrayList<>();
        list4.add(new Trainer(3,"Joel",1000));
        list4.add(new Trainer(3,"Andy",4000));
        list4.add(new Trainer(3,"Ricky",1000));
        list4.add(new Trainer(3,"Sachin",4000));
        sortList(list4);
        map.put("Python",list4);*/
        int ans = 0;
        int []trainer = {0,0,0,0};
        Map<String,Boolean> mp = new HashMap<>();
        for (Map.Entry o1 : map.entrySet()) {
            List tmp = (List) o1.getValue();
            for (int i = 0; i < tmp.size(); i++) {
                Trainer obj = ((Trainer) tmp.get(i));
                if (trainer[obj.id] == 0 && !mp.containsKey(obj.name)) {
                    ans += obj.charge;
                    obj.visited = true;
                    trainer[obj.id] = 1;
                    mp.put(obj.name,true);
                    System.out.println(o1.getKey() + " " +  obj.name + " " +  obj.charge);
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
