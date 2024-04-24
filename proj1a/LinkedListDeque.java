public class LinkedListDeque<T> {

    private LinkedListDeque prev;

    private T current;

    private int size = 0;

    private LinkedListDeque next;

    /**
     * Construct a LinkedListDeque element.
     */
    public LinkedListDeque(LinkedListDeque<T> prev0, T current0, LinkedListDeque<T> next0) {
        prev = prev0;
        current = current0;
        next = next0;
    }


    /**
     * The very FIRST element in deque.
     */
    private static LinkedListDeque FIRST;

    /**
     * The very LAST element in deque.
     */
    private static LinkedListDeque LAST;

    /* put the First and the Last together. */
    static {
        FIRST = new LinkedListDeque();
        LAST = new LinkedListDeque();
        FIRST.next = LAST;
        LAST.next = FIRST;
    }

    public LinkedListDeque() {
        prev = FIRST;
        current = null;
        next = LAST;
    }

    /** return size of the given LinkListDeque. */
    public int size() {
        return size;
    }

    public T get(int index) {
        if (index > 0 && size > index) {
            LinkedListDeque ptr = FIRST.next;
            for(int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
            return (T) ptr.current;
        } else{
            return null;
        }
    }


    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        LinkedListDeque ptr = FIRST.next;
        for (int i = 0; i < size; i++) {
            System.out.print(ptr.current);
            System.out.print(" ");
            ptr = ptr.next;
        }
        System.out.println();
    }



    /** add item of T "T" to the first. */
    public void addFirst(T item) {
        LinkedListDeque newNode =  new LinkedListDeque(FIRST, item, FIRST.next);
        size += 1;
        FIRST.next.prev = newNode;
        FIRST.next = newNode;
    }

    public void addLast(T item) {
        LinkedListDeque newNode = new LinkedListDeque(LAST.prev, item, LAST);
        size += 1;
        LAST.prev.next = newNode;
        LAST.prev = newNode;
    }

    /** remove the first item. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T result = (T) FIRST.next.current;
            LinkedListDeque ptr = FIRST.next.next;
            FIRST.next = ptr;
            ptr.prev = FIRST;
            size -= 1;
            return result;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T result = (T) LAST.prev.current;
            LinkedListDeque ptr = LAST.prev.prev;
            ptr.next = LAST;
            LAST.prev = ptr;
            size -= 1;
            return result;
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T getRecursive(int index) {
        LinkedListDeque tmp = this;
        if (index == 0) {
            return (T) FIRST.next.current;
        } else{
            tmp = tmp.next;
            return (T) tmp.getRecursive(index - 1);
        }
    }
}
