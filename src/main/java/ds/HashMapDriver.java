package ds;

/**
 * Created by sarvothampai on 23/10/15.
 */
public class HashMapDriver {

    public static void main(String[] args) {

        HashMap<Key, String> map = new HashMap<Key, String>();
        map.put(new Key("12"), "hello");
        map.put(new Key("13"), "hi");


        System.out.println(map.get(new Key("12")));
        System.out.println(map.get(new Key("13")));

        map.put(new Key("12"), "jhandu");
        map.put(new Key("14"), "dasa");

        System.out.println(map.get(new Key("12")));
        System.out.println(map.get(new Key("14")));

    }


}

class Key {

    private String key;


    public Key(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;

        Key key1 = (Key) o;

        return !(key != null ? !key.equals(key1.key) : key1.key != null);

    }
}
