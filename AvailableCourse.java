public class AvailableCourse <K, V extends Comparable<V>> implements Comparable<AvailableCourse<K,V>> {

    private K key;
    private V value;

    public AvailableCourse(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AvailableCourse) {
            AvailableCourse<?, ?> other = (AvailableCourse<?, ?>) obj;
            return this.value.equals(other.value);
        }
        return false;
    }

    @Override
    public int compareTo(AvailableCourse<K, V> other) {
        return this.value.compareTo(other.value);
    }
}
