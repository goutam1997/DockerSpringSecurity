package splitwise.myhashmap;

public class HashMapMain {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>(7);

        myHashMap.put(1, "A");
        myHashMap.put(2, "B");
        myHashMap.put(3, "C");
        myHashMap.put(4, "D");
        myHashMap.put(5, "E");
        myHashMap.put(6, "F");
        myHashMap.put(7, "G");
        myHashMap.put(8, "H");

        System.out.println("key: " + 5 + " value: " + myHashMap.get(5));
        System.out.println("key: " + 8 + " value: " + myHashMap.get(8));

        myHashMap.put(5, "Z");
        System.out.println("key: " + 5 + " value: " + myHashMap.get(5));
        System.out.println("key: " + 6 + " value: " + myHashMap.get(6));
    }
}
