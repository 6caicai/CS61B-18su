
public class LinkedListDeque<T> {

    /** the naked part. */
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        /** constructor of Node. */
        private Node(T t0, Node prev0, Node next0) {
            item = t0;
            prev = prev0;
            next = next0;
        }
    }

    private Node sentinel;
    private int size;

    /** create an empty LinkedListDeque. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** return the i th thing of the deque. */
    public T get(int index) {
        if (index >= 0 && index < size) {
            Node ptr = sentinel.next;
            for (int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
            return ptr.item;
        } else {
            return null;
        }
    }

    private T getRecursiveHelper(int index, Node T) {
        if (index == 0) {
            return T.item;
        } else {
            return getRecursiveHelper(index - 1, T.next);
        }
    }

    /** get but recursion. */
    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    public void addFirst(T item) {
        Node a = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = a;
        sentinel.next = a;
        size++;
    }

    public void addLast(T item) {
        Node a = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = a;
        sentinel.prev = a;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node ptr = sentinel;
        for (int i = 0; i < size; i++) {
            ptr = ptr.next;
            System.out.print(ptr.item + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node a = sentinel.next;
        T result = a.item;
        sentinel.next = a.next;
        a.next.prev = sentinel;
        a = null;
        size--;
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node a = sentinel.prev;
        T result = a.item;
        sentinel.prev = a.prev;
        a.prev.next = sentinel;
        a = null;
        size--;
        return result;
    }
}
