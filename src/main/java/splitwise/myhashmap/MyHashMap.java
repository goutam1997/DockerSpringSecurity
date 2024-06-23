package splitwise.myhashmap;

public class MyHashMap<K, V> {
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static int SIZE = 16;
    private static final int MAXIMUM_CAPACITY = (1 << 30);

    private final Node<K,V>[] nodeList;

    public MyHashMap() {
        nodeList = new Node[SIZE];
    }

    public MyHashMap(int maxSize) {

        System.out.println("Input Size: " + maxSize + " " + Integer.toBinaryString(maxSize));
        SIZE = tableSizeFor(maxSize);
        System.out.println("Final Size: " + SIZE + " " + Integer.toBinaryString(SIZE));
        // 1101 => 1101 | 101 = 1101 | 10 = 1111
        nodeList = new Node[SIZE];
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println("n: " + n + " " + Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println("n: " + n + " " + Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println("n: " + n + " " + Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println("n: " + n + " " + Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println("n: " + n + " " + Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println("n: " + n + " " + Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K key, V value) {
        int hashValue = key.hashCode() % SIZE;

        if (nodeList[hashValue] == null) {
            nodeList[hashValue] = new Node(key, value);
        } else {
            Node<K,V> prevNode = null;
            Node<K,V> curNode = nodeList[hashValue];
            while (curNode != null) {
                if (curNode.key.equals(key)) {
                    curNode.value = value;
                    return;
                }
                prevNode = curNode;
                curNode = curNode.next;
            }
            prevNode.next = new Node(key, value);
        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hashcode = key.hashCode() % SIZE;
        if (nodeList[hashcode] == null) {
            return null;
        }
        Node cur = nodeList[hashcode];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return (V) cur.value;
            }
            cur = cur.next;
        }
        return null;
    }
}
