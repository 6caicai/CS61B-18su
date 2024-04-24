public class LinkedListDeque<Type> {

    private LinkedListDeque prev;

    private Type current;

    private int size = 0;

    private LinkedListDeque next;

    /**
     * Construct a LinkedListDeque element.
     */
    public LinkedListDeque(LinkedListDeque prev0, Type current0, LinkedListDeque next0) {
        prev = prev0;
        current = current0;
        next = next0;
    }


    /**
     * The very FIRST element in deque.
     */
    public static LinkedListDeque First;

    /**
     * The very LAST element in deque.
     */
    private static LinkedListDeque Last;

    /* put the First and the Last together. */
    static {
        First = new LinkedListDeque();
        Last = new LinkedListDeque();
        First.next = Last;
        Last.next = First;
    }

    public LinkedListDeque() {
        prev = First;
        current = null;
        next = Last;
    }

    /** return size of the given LinkListDeque. */
    public int size() {
        return size;
    }

    public Type get(int index) {
        if (index > 0 && size > index) {
            LinkedListDeque ptr = First.next;
            for(int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
            return (Type)ptr.current;
        } else{
            return null;
        }
    }


    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        LinkedListDeque ptr = First.next;
        for (int i = 0; i < size; i++) {
            System.out.print(ptr.current);
            System.out.print(" ");
            ptr = ptr.next;
        }
        System.out.println();
    }



    /** add item of type "type" to the first. */
    public void addFirst(Type item) {
        LinkedListDeque newNode =  new LinkedListDeque(First, item, First.next);
        size += 1;
        First.next.prev = newNode;
        First.next = newNode;
    }

    public void addLast(Type item) {
        LinkedListDeque newNode = new LinkedListDeque(Last.prev, item, Last);
        size += 1;
        Last.prev.next = newNode;
        Last.prev = newNode;
    }

    /** remove the first item. */
    public Type removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Type result = (Type)First.next.current;
            LinkedListDeque ptr = First.next.next;
            First.next = ptr;
            ptr.prev = First;
            size -= 1;
            return result;
        }
    }

    public Type removeLast() {
        if (size == 0) {
            return null;
        } else {
            Type result = (Type)Last.prev.current;
            LinkedListDeque ptr = Last.prev.prev;
            ptr.next = Last;
            Last.prev = ptr;
            size -= 1;
            return result;
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Type getRecursive(int index) {
        LinkedListDeque tmp = this;
        if (index == 0) {
            return (Type)First.next.current;
        } else{
            tmp = tmp.next;
            return (Type)tmp.getRecursive(index - 1);
        }
    }
}
