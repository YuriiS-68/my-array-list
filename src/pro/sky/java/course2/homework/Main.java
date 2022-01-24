package pro.sky.java.course2.homework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyListImpl array = new MyListImpl();
        String first = "First";
        String second = "Second";
        String third = "Third";
        String fourth = "Forth";
        String fifth = "Fifth";
        String sixth = "Sixth";
        String seventh = "Seventh";
        String eighth = "Eighth";
        String ninth = "Ninth";
        String tenth = "Tenth";
        String eleventh = "Eleventh";
        String twelfth = "Twelfth";
        String thirteenth = "Thirteenth";
        String fourteenth = "Fourteenth";
        String fifteenth = "Fifteenth";
        String sixteenth = "Sixteenth";
        String itemNew = "New";

        array.add(first);
        array.add(second);
        array.add(third);
        //System.out.println("array = " + array);
        //array.add(0, first);
        //array.add(1, second);
        //array.add(2, third);
        //array.add(3, fourth);
        //array.add(4, fifth);
        //System.out.println("array = " + array);
        System.out.println("array.set(2, itemNew) = " + array.set(2, itemNew));
        //System.out.println("array.add(itemNew) = " + array.add(itemNew));
        //System.out.println("array.add(2, itemNew) = " + array.add(2, itemNew));
        //System.out.println("array = " + array);
        //System.out.println("array.contains(itemNew) = " + array.contains(itemNew));
        //System.out.println("array.remove(2) = " + array.remove(2));
        //System.out.println("array.remove(second) = " + array.remove(second));
        //System.out.println("array.indexOf(second) = " + array.indexOf(seventh));
        System.out.println("array.lastIndexOf(third) = " + array.lastIndexOf(itemNew));
        //System.out.println("array.get(0) = " + array.get(0));
        array.add(thirteenth);
        //System.out.println("array = " + array);
        System.out.println("array.toArray() = " + Arrays.toString(array.toArray()));
        //System.out.println("array.isEmpty() = " + array.isEmpty());
        //array.clear();
        System.out.println("array = " + array);
        System.out.println("array.isEmpty() = " + array.isEmpty());
        //System.out.println("array after remove = " + array);

    }
}
