
import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListDequeTest {

    @Test
    public void testAddAndGet(){
        LinkedListDeque<String> testObject = new LinkedListDeque<>();
        testObject.addFirst("dfef");
        assertEquals(testObject.get(0), "dfef");
        assertEquals(testObject.get(0), "dfef");
        assertEquals(null, testObject.getRecursive(4));
        testObject.addLast("325");
        testObject.addLast("332145");
        assertEquals(testObject.getRecursive(2), "332145");
        testObject.addFirst("我是傻比");
        assertEquals(testObject.getRecursive(0), "我是傻比");
    }

    @Test
    public void testPrint(){
        LinkedListDeque<Integer> testObject = new LinkedListDeque<>();
        /** (2, 5, 6, 2, 5) */
        testObject.addFirst(5);
        testObject.addFirst(2);
        testObject.addFirst(6);
        testObject.addFirst(5);
        testObject.addFirst(2);
        testObject.printDeque();
    }

    @Test
    public void testRemove(){
        LinkedListDeque<String> testObject = new LinkedListDeque<>();
        /** ("傻逼", "华中", "科技", "大学", "把我", "害惨", "了") */
        assertEquals(testObject.removeLast(), "null");
        assertEquals(testObject.removeLast(), "null");
        assertEquals(testObject.removeLast(), "null");
        assertEquals(testObject.removeLast(), "null");
        assertEquals(testObject.removeLast(), "null");
        assertEquals(testObject.size(), 0);
        testObject.addFirst("大学");
        testObject.addFirst("科技");
        testObject.addFirst("华中");
        testObject.addFirst("傻逼");
        testObject.addLast("把我");
        testObject.addLast("害惨");
        testObject.addLast("了");
        testObject.printDeque();
        assertEquals(testObject.removeFirst(), "傻逼");
        testObject.printDeque();

        testObject.printDeque();
    }
}
