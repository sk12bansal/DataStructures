package javaconcepts;

import java.io.*;

class Employee implements Serializable {

    transient int a;
    static int b;
    String name;
    int age;

    public Employee(int a, int b, String name, int age) {
        this.a = a;
        this.b = b;
        this.name = name;
        this.age = age;
    }
}

public class SerializationExample {

    public static void printData(Employee object1) {
        System.out.println("name = " + object1.name);
        System.out.println("age = " + object1.age);
        System.out.println("a = " + object1.a);
        System.out.println("b = " + object1.b);
    }

    public static void main(String []args) {
        Employee employee = new Employee(10, 1000, "ab", 45);
        String fileName = "suraj.txt";

        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(employee);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n"
                    + "Data before Deserialization.");
            printData(employee);

             // value of static variable changed
            employee.b = 2000;

        } catch (IOException e) {
            e.printStackTrace();
        }

        employee = null;

        // Deserialization
        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream
                    (fileName);
            ObjectInputStream in = new ObjectInputStream
                    (file);

            // Method for deserialization of object
            employee = (Employee) in.readObject();

            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printData(employee);

            // System.out.println("z = " + object1.z);
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }
    }

}
