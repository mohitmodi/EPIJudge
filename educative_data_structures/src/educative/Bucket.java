package educative;

import java.util.ArrayList;

public class Bucket {
    ArrayList<HashPair> buckets;

    public Bucket() {
        buckets = new ArrayList<>();

    }

    public void update(String key, String value) {
        boolean found=false;
        for (int i = 0; i < buckets.size(); i++) {
            HashPair pair = buckets.get(i);
            if (pair.getKey().equals(key)) {
                buckets.set(i,new HashPair(key, value));

                found=true;
                break;
            }
        }
        if(!found){
            buckets.add(new HashPair(key,value));
        }


    }

    public String get(String key) {
        for (HashPair pair : buckets) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return "";
    }

    public void delete(String key) {
        for (int i = 0; i < buckets.size(); i++) {
            HashPair pair = buckets.get(i);
            if (pair.key.equals(key)) {
                buckets.remove(pair);
                break;
            }
        }
    }
}

class HashPair<K,V> {
    String key;
    String value;

    HashPair(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public String getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }


}
