package ds;

/**
 * Created by sarvothampai on 23/10/15.
 * <p/>
 * <p/>
 * <p/>
 * The best implementation? That is a hard question because it depends on the usage pattern.
 * A for nearly all cases reasonable good implementation was proposed in Josh Bloch's Effective Java in item 8. The best thing is to look it up there because the author explains there why the approach is good.
 * A short version
 * 1	Create a int result and assign a non-zero value.
 * 2	For every field f tested in the equals() method, calculate a hash code c by:
 * If the field f is a boolean: calculate (f ? 0 : 1);
 * If the field f is a byte, char, short or int: calculate (int)f;
 * If the field f is a long: calculate (int)(f ^ (f >>> 32));
 * If the field f is a float: calculate Float.floatToIntBits(f);
 * If the field f is a double: calculate Double.doubleToLongBits(f) and handle the return value like every long value;
 * If\ the field f is an object: Use the result of the hashCode() method or 0 if f == null;
 * If the field f is an array: see every field as separate element and calculate the hash value in a recursive fashion and combine the values as described next.
 * 3	Combine the hash value c with result:
 * result = 37 * result + c
 * 4	Return result
 *
 * The value 31 was chosen because it is an odd prime.
 * If it were even and the multiplication overflowed, information would be lost, as multiplication by 2 is equivalent to shifting.
 * The advantage of using a prime is less clear, but it is traditional.
 * A nice property of 31 is that the multiplication can be replaced by a shift and a subtraction for better performance: 31 * i == (i << 5) - i.
 * Modern VMs do this sort of optimization automatically.
 *
 *
 */
public class HashMap<K, V> {

    private final int size = 100;
    private Entry<K, V> table[];


    public HashMap() {
        table = new Entry[size];
    }

    public void put(K key, V value) {

        int hashCode = getHashCode(key) % size;

        if (table[hashCode] == null) {
            Entry<K, V> entry = new Entry<K, V>(key, value);
            table[hashCode] = entry;
        } else {

            Entry<K, V> oldEntry = table[hashCode];

            while (oldEntry.next != null) {

                if (oldEntry.key.equals(key)) {
                    oldEntry.value = value;
                    return;
                }

                oldEntry = oldEntry.next;
            }

            if (oldEntry.key.equals(key)) {
                oldEntry.value = value;
            } else {
                oldEntry.next = new Entry<K, V>(key, value);
            }

        }


    }

    public V get(K key) {

        int hash = key.hashCode() % size;

        Entry<K, V> entry = table[hash];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }

        return null;
    }

    private int getHashCode(K key) {
        return key.hashCode();
    }


    static class Entry<K, V> {

        private final K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K k, V v) {

            this.key = k;
            this.value = v;

        }
    }
}
