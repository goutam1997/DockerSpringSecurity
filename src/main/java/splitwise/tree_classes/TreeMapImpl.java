package splitwise.tree_classes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapImpl {
    public static void main(String[] args) {
        Map<Integer,Integer> hash=new HashMap<>();
        hash.put(1,1);
        TreeMap<Integer, Integer> treeMap=new TreeMap<>();
        treeMap.put(243, 1);
        treeMap.put(356, -1);
        treeMap.put(656, 1);
        treeMap.put(6634, -1);
        treeMap.put(24582, 1);
        treeMap.put(2152, -1);
        System.out.println(treeMap);
        System.out.println("treeMap.firstEntry(): "+treeMap.firstEntry());
        System.out.println("treeMap.lastEntry(): "+treeMap.lastEntry());
        System.out.println("treeMap.firstKey(): "+treeMap.firstKey());
        System.out.println("treeMap.lastKey(): "+treeMap.lastKey());

        System.out.println("treeMap.pollFirstEntry(): "+treeMap.pollFirstEntry());
        System.out.println("treeMap.pollLastEntry(): "+treeMap.pollLastEntry());
        System.out.println("treeMap.descendingMap(): "+treeMap.descendingMap());
        System.out.println("treeMap.descendingKeySet(): "+treeMap.descendingKeySet());

        System.out.println("treeMap.subMap(400, 3000): "+treeMap.subMap(400, 3000));
        System.out.println("treeMap.higherEntry(400): "+treeMap.higherEntry(400));
        System.out.println("treeMap.higherKey(400): "+treeMap.higherKey(400));
        System.out.println("treeMap.ceilingEntry(400): "+treeMap.ceilingEntry(400));
    }
}
