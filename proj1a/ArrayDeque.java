
public class ArrayDeque<Type> {

    /** Basic attribute of ArrayDeque. */
    private Type[] item;
    private int size;

    /** Create an empty ArrayDeque. */
    public ArrayDeque() {
        item = (Type[]) new Object[32];
        size = 0;
    }

    /** Resize the ArrayDeque. */
    public void reSize(int capacity) {
        Type[] tmp = (Type[]) new Object[capacity];
        System.arraycopy(item, 0, tmp, 0, size);
        item = tmp;
    }

    /** Double size of the Array. */
    public void inSize() {
        reSize(size * 2);
    }

    /** Decrease size of the ArrayDeque until size greater than a quarter of item length. */
    public void deSize() {
        while (size < item.length / 4) {
            reSize(size / 2);
        }
    }

    public void addFirst(Type thing) {

        /* Increase size to double if Array is full. */
        if (size == item.length) {
            inSize();
        }

        /* Move everything to one step after. */
        for (int i = size; i > 0; i--) {
            item[i] = item[i-1];
        }

        /* Add First. */
        item[0] = thing;
    }

    public void addLast(Type thing) {

        /* Increase size to double if Array is full. */
        if (size == item.length) {
            inSize();
        }

        /* Add thing to the last. */
        item[size] = thing;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(item[i]);
        }
        System.out.println();
    }

    public Type removeFirst() {
        if (size == 0){
            return null;
        } else {
            Type result = item[0];
            size--;

            /* Move everything foreword. */
            for (int i = 0; i < size; i++) {
                item[i] = item[i+1];
            }

            /* Decrease the size if needed. */
            deSize();

            /* Return the result. */
            return result;
        }
    }

    public Type removeLast() {
        if (size == 0) {
            return null;
        } else{
            Type result = item[size];
            item[size] = null;

            /* Decrease the size if needed. */
            deSize();

            return result;
        }
    }

    public Type get(int i) {
        if (0 < i && i < size) {
            return item[i];
        } else{
            return null;
        }
    }
}
