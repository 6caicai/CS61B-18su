import java.lang.reflect.Array;
import java.util.ResourceBundle;

public class ArrayDeque<type> {

    /** Basic attribute of ArrayDeque. */
    private type[] item;
    private int size;

    /** Create an empty ArrayDeque. */
    public ArrayDeque(){
        item = (type[]) new Object[32];
        size = 0;
    }

    /** Resize the ArrayDeque. */
    public void ReSize(int Capacity){
        type[] tmp = (type[]) new Object[Capacity];
        System.arraycopy(item, 0, tmp, 0, size);
        item = tmp;
    }

    /** Double size of the Array. */
    public void InSize(){
        ReSize(size * 2);
    }

    /** Decrease size of the ArrayDeque until size greater than a quarter of item length. */
    public void Desize(){
        while (size < item.length / 4) {
            ReSize(size / 2);
        }
    }

    public void addFirst(type thing){

        /** Increase size to double if Array is full. */
        if (size == item.length){
            InSize();
        }

        /** Move everything to one step after. */
        for (int i = size; i > 0; i--){
            item[i] = item[i-1];
        }

        /** Add First. */
        item[0] = thing;
    }

    public void addLast(type thing){

        /** Increase size to double if Array is full. */
        if (size == item.length){
            InSize();
        }

        /** Add thing to the last. */
        item[size] = thing;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < size; i++){
            System.out.print(item[i]);
        }
        System.out.println();
    }

    public type removeFirst(){
        if (size == 0){
            return null;
        } else {
            type result = item[0];
            size--;

            /** Move everything foreword. */
            for (int i = 0; i < size; i++){
                item[i] = item[i+1];
            }

            /** Decrease the size if needed. */
            Desize();

            /** Return the result. */
            return result;
        }
    }

    public type removeLast(){
        if (size == 0){
            return null;
        } else{
            type result = item[size];
            item[size] = null;

            /** Decrease the size if needed. */
            Desize();

            return result;
        }
    }

    public type get(int i){
        if (0 < i && i < size){
            return item[i];
        } else{
            return null;
        }
    }
}
