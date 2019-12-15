import java.util.Iterator;

@SuppressWarnings("unchecked")
public class 3.1.DynamicArrayCode <T> implements Iterable<T> {
    private T[] arr;
    private int len = 0; // Length user thinks array is
    private int capcity = 0; // Actual array size

    public Array() {
        this(16);
    }

    public Array(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity" + capacity);
        this.capcity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T elem) {
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < capcity; i++)
            arr[i] = null;
        len = 0;
    }

    public void add(T elem) {
        // Time to resize!
        if (len + 1 >= capcity) {
            if (capcity == 0)
                capcity = 1;
            else
                capcity *= 2; // double the size
            T[] new_arr = (T[]) new Object[capcity];
            for (int i = 0; i < len; i++) {
                new_arr[i] = arr[i];
                arr = new_arr; // arr has exra nulls padded
            }
            arr[len++] = elem;
        }
    }

    // Removes the element at the specified index in this list
    public T removeAt(int rm_index) {
        if (rm_index >= len && rm_index < 0)
            throw new IndexOutOfBoundsException();
        T data = arr[rm_index];
        T[] new_arr = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == rm_index)
                j--; // Skip over rm_index by fixing j temporarily
            else
                new_arr[j] = arr[i];
            arr = new_arr;
            capcity = --len;
            return data;
        }
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj))
                return i;
            return -1;
        }
    }

    public boolean contains(object obj) {
        return indexOf(obj != -1);
    }

    // Iterator is still fast but not as fast as iterative for loop
    @Override public java.util.Iterator <T> iterator () {
        return new java.util.Iterator<T>() {
            int index = 0;
            public boolean hasNext() {return index < len;}
            public T next() {return arr[index++]}
        };
    }

    @Override
    public String toString() {
        if (len == 0)
            return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) {
                sb.append(arr[i] + ", ");
                return sb.append(arr[len - 1] + "]").toString();
            }
        }
    }
}