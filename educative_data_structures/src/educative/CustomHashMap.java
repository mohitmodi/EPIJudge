package educative;

public class CustomHashMap {
    Bucket[] buckets;
    int keys;

    public CustomHashMap() {
        keys = 100;
        buckets = new Bucket[keys];
        for (int i = 0; i < keys; i++) {//create buckets
            buckets[i] = new Bucket();
        }

    }

    public String get(String key) {
        int hash = calculateHash(key, keys);
        return buckets[hash].get(key);
    }

    public void delete(String key) {
        int hash = calculateHash(key, keys);
        buckets[hash].delete(key);
    }

    public void put(String key, String value) {
        int hash = calculateHash(key, keys);
        buckets[hash].update(key, value);
    }

    private int calculateHash(String key, int keys) {

        return key.hashCode() % keys;
    }

    public static void main(String[] args) {
        CustomHashMap main=new CustomHashMap();
        main.put("k1","v1");
        main.put("k1", "v2");
        main.put("k2","v2");
        main.put("k2","v2");
        main.put("k3","v3");
        main.put("k4","v5");
        main.put("k4","v4");
        main.put("k5","v5");
        //main.delete("k4");
        System.out.println(main.get("k4"));
    }
}
