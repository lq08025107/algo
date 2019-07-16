public class MyHashMap<K, V> {

    private class Entry<K, V> {
        K key;
        V value;
        int hash;
        Entry next;

        public Entry(K key, V value, int hash, Entry next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }

    private static final int DEFAULT_CAPACITY = 1 << 4;

    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;

    private int capacity;

    private int size;

    public MyHashMap(){
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException();
        } else {
            table = new Entry[capacity];
            size = 0;
            this.capacity = capacity;
        }
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }
    public int hash(K key) {
        double tmp = key.hashCode() * (Math.pow(5, 0.5)) / 2;
        double digit = tmp - Math.floor(tmp);
        return (int)Math.floor(digit * capacity);
    }

    public void put(K key, V value) {
        if(key == null) {
            throw new IllegalArgumentException();
        }
        if (size >= DEFAULT_LOAD_FACTOR * table.length) {
            reSize();
        }
        int hash = hash(key);

        Entry<K, V> nEntry = new Entry<>(key, value, hash, null);
        Entry<K, V> entry = table[hash];
        //循环遍历查询该链表中是否已存在相同key的节点,如果存在,则替换
        while(entry != null) {
            if(entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        nEntry.next = table[hash]; // 如果循环结束还未检索到有相同key的节点,则在链表头部添加新的节点信息,并将新节点的next设置为原头部节点
        table[hash] = nEntry;
        size++;
    }

    public V get(K key) {
        int hash = hash(key);
        Entry<K, V> entry = table[hash];
        while(entry != null) {
            if(entry.key.equals(key)){
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public void reSize() {

    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap(20);
        map.put("1", "11");
        map.put("1", "22");
        map.put("3", "33");
        System.out.println(map.get("1"));
    }
}
