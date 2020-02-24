package DesignPatterns.SingletonPattern;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton implements Serializable,Cloneable {
    private static volatile Singleton INSTANCE = null;

    private Singleton(){

    }

    public static Singleton getINSTANCE(){
        synchronized(Singleton.class) {
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
        }
        return  INSTANCE;
    }


    /* Save Singleton Class  from Serialization break */
    protected Object readResolve(){
        return INSTANCE;
    }

    /* Save Singleton Class from Cloneable break  */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return INSTANCE;
    }
}

class SingletonDemo{
    public static void main(String []args) throws CloneNotSupportedException {
        Singleton s1 = Singleton.getINSTANCE();
        Singleton s2 = (Singleton) s1.clone();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

       /* Singleton break using reflection

        using ENUM we can fix this.*/

        /*Constructor[] constructors = Singleton.class.getDeclaredConstructors();
        for(Constructor constructor :constructors){
            constructor.setAccessible(true);
            try {
                s2 = (Singleton) constructor.newInstance();
                break;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());*/



        /*
        Singleton Break Using Serialization

        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(s1);
            out.close();

            // deserailize from file to object

            ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
            s2 = (Singleton) in.readObject();
            in.close();
            System.out.println(s1.hashCode());
            System.out.println(s2.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}
