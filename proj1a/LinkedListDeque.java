public class LinkedListDeque<type> {

    public LinkedListDeque prev;

    public type current;

    public int size = 0;

    public LinkedListDeque next;

    /**
     * Construct a LinkedListDeque element.
     */
    public LinkedListDeque(LinkedListDeque prev0, type current0, LinkedListDeque next0) {
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

    /** put the First and the Last together. */
    static {
        First = new LinkedListDeque();
        Last = new LinkedListDeque();
        First.next = Last;
        Last.next = First;
    }

    public LinkedListDeque(){
        prev = First;
        current = null;
        next = Last;
    }

    /** return size of the given LinkListDeque. */
    public int size(){
        return size;
    }

    public type get(int index){
        if (index > 0 && size > index){
            LinkedListDeque ptr = First.next;
            for(int i = 0; i < index; i++){
                ptr = ptr.next;
            }
            return (type)ptr.current;
        } else{
            return null;
        }
    }


    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
        LinkedListDeque ptr = First.next;
        for (int i = 0; i < size; i++){
            System.out.print(ptr.current);
            System.out.print(" ");
            ptr = ptr.next;
        }
        System.out.println();
    }



    /** add item of type "type" to the first. */
    public void addFirst(type item){
        LinkedListDeque newNode =  new LinkedListDeque(First, item, First.next);
        size += 1;
        First.next.prev = newNode;
        First.next = newNode;
    }

    public void addLast(type item){
        LinkedListDeque newNode = new LinkedListDeque(Last.prev, item, Last);
        size += 1;
        Last.prev.next = newNode;
        Last.prev = newNode;
    }

    /** remove the first item. */
    public type removeFirst(){
        if (isEmpty()){
            return null;
        }
        else {
            type result = (type)First.next.current;
            LinkedListDeque ptr = First.next.next;
            First.next = ptr;
            ptr.prev = First;
            size -= 1;
            return result;
        }
    }

    public type removeLast(){
        if (size == 0){
            return null;
        } else {
            type result = (type)Last.prev.current;
            LinkedListDeque ptr = Last.prev.prev;
            ptr.next = Last;
            Last.prev = ptr;
            size -= 1;
            return result;
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public type getRecursive(int index){
        LinkedListDeque tmp = this;
        if (index == 0){
            return (type)First.next.current;
        } else{
            tmp = tmp.next;
            return (type)tmp.getRecursive(index - 1);
        }
    }
}
