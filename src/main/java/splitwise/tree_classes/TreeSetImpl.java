package splitwise.tree_classes;

import java.util.TreeSet;

public class TreeSetImpl {
    public static void main(String[] args) {
        TreeSet<Integer> set=new TreeSet<>();
        set.add(34);
        set.add(342);
        set.add(76);
        set.add(9685);
        set.add(123);
        System.out.println(set);
        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println("set.ceiling(3645): "+set.ceiling(3645));
        System.out.println("set.ceiling(33): "+set.ceiling(33));
        System.out.println("set.higher(34): "+set.higher(34));

        System.out.println("set.floor(3645): "+set.floor(3645));
        System.out.println("set.lower(33): "+set.lower(33));

        System.out.println("set.pollFirst(): "+set.pollFirst());
        System.out.println("set.pollLast(): "+set.pollLast());
        System.out.println(set);
        System.out.println("set.headSet(96): "+set.headSet(96));
        System.out.println("set.tailSet(34): "+set.tailSet(34));

        set.add(345);
        set.add(876);
        System.out.println("set.descendingSet(): "+set.descendingSet());
        System.out.println("set.subSet(123, 455): "+set.subSet(123, 455));
        System.out.println("set.subSet(100, 455): "+set.subSet(100, 455));
    }
}
