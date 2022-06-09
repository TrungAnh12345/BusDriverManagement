package Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Comparator {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Trung", "HaNoi","9483982492") {
        });
        personList.add(new Person("Hoa", "Thanh Hoa", "0329840") {
        });
        personList.add(new Person("Manh", "New York", "32049234") {
        });
        personList.forEach((p) -> {
            System.out.println( p.getFullName() + p.getPhone());

        });

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getFullName().compareTo(o2.getFullName())  < 0)
                { return -1;}
                return 0;
            }
        });
        System.out.println("List of Person after sorting Java 8 by anonymous class");

        personList.forEach((p) -> {
            System.out.println( p.getFullName() + p.getPhone());

        });
        // Lambda expression java8
        personList.sort(( Person person1,  Person person2) -> {
//            if(person1.getFullName().compareTo(person2.getFullName())  > 0)
//            { return -1;}
//            return 0;
            // đoạn code trên viết hơi dài, có thể rút ngắn lại như sau(Sắp xếp xuôi)

            return person1.getFullName().compareTo(person2.getFullName());
        });
        System.out.println("List of Person after sorting Java 8 Lambda express");

        personList.forEach((p) -> {
            System.out.println( p.getFullName() + p.getPhone());
        });
        // Lambda8 expression Ultimate
        System.out.println("Lambda8 expression Ultimate sort xuôi");
        personList.sort((p1, p2) -> {
            return p1.getAddress().compareTo(p2.getAddress());
        });
        personList.forEach((p -> {
            System.out.println(p.getFullName() + " " + p.getAddress());
        }));








    }
}
