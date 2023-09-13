public interface Searchable<T> {
    boolean matches(T object);
}