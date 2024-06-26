
public class ArrayDeque<T> {

    /** Basic attribute of ArrayDeque. */
    private T[] item;

    private int size;

    /** Create an empty ArrayDeque. */
    public ArrayDeque() {
        item = (T[]) new Object[32];
        size = 0;
    }

    /** Resize the ArrayDeque. */
    private void reSize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(item, 0, tmp, 0, size);
        item = tmp;
    }

    /** Double size of the Array. */
    private void inSize() {
        reSize(size * 2);
    }

    /** Decrease size of the ArrayDeque until size greater than a quarter of item length. */
    private void deSize() {
        while (size < item.length / 4) {
            reSize(item.length / 2);
        }
    }

    public void addFirst(T thing) {

        /* Increase size to double if Array is full. */
        if (size == item.length) {
            inSize();
        }

        /* Move everything to one step after. */
        for (int i = size; i > 0; i--) {
            item[i] = item[i - 1];
        }

        /* Add First. */
        item[0] = thing;
        size++;
    }

    public void addLast(T thing) {

        /* Increase size to double if Array is full. */
        if (size == item.length) {
            inSize();
        }

        /* Add thing to the last. */
        item[size] = thing;
        size++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(item[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T result = item[0];

            /* Move everything foreword. */
            for (int i = 0; i < size - 1; i++) {
                item[i] = item[i + 1];
            }

            item[size - 1] = null;
            size--;

            /* Decrease the size if needed. */
            deSize();

            /* Return the result. */
            return result;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T result = item[size - 1];
            item[size - 1] = null;
            size--;

            /* Decrease the size if needed. */
            deSize();

            return result;
        }
    }

    public T get(int i) {
        if (0 <= i && i < size) {
            return item[i];
        } else {
            return null;
        }
    }
}
