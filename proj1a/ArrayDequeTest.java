
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testAddAndGet(){
        ArrayDeque<String> testObject = new ArrayDeque<>();
        testObject.addFirst("dfef");
        assertEquals(testObject.get(0), "dfef");
        assertEquals(testObject.get(0), "dfef");
        assertEquals(testObject.get(4), null);
        testObject.addLast("325");
        testObject.addLast("332145");
        assertEquals(testObject.get(2), "332145");
        testObject.addFirst("我是傻比");
        assertEquals(testObject.get(0), "我是傻比");
    }

    @Test
    public void testPrint(){
        ArrayDeque<Integer> testObject = new ArrayDeque<>();
        /** (2, 5, 6, 2, 5) */
        testObject.addFirst(5);
        assertEquals(1, testObject.size());
        testObject.addFirst(2);
        assertEquals(2, testObject.size());
        testObject.addFirst(6);
        assertEquals(3, testObject.size());
        testObject.addFirst(5);
        assertEquals(4, testObject.size());
        testObject.addFirst(2);
        assertEquals(5, testObject.size());
        testObject.printDeque();
    }

    @Test
    public void testRemove(){
        ArrayDeque<String> testObject = new ArrayDeque<>();
        /** ("傻逼", "华中", "科技", "大学", "把我", "害惨", "了") */
        testObject.addFirst("大学");
        testObject.addFirst("科技");
        testObject.addFirst("华中");
        testObject.addFirst("傻逼");
        testObject.addLast("把我");
        testObject.addLast("害惨");
        testObject.addLast("了");
        testObject.printDeque();
        assertEquals("傻逼", testObject.removeFirst());
        testObject.printDeque();
        assertEquals("了", testObject.removeLast());
        testObject.printDeque();
    }

    @Test
    public void IDontKnowWhatItIsTestFor() {
        ArrayDeque testObject = new ArrayDeque();
        testObject.addLast(0);
        testObject.removeLast();
        testObject.addFirst(2);
        testObject.removeFirst();
        testObject.addFirst(4);
        testObject.get(0);
        testObject.addFirst(6);
        testObject.addLast(7);
        testObject.get(1);
        testObject.addLast(9);
        testObject.removeLast();
        testObject.removeLast();
        testObject.get(1);
        testObject.removeLast();
        testObject.addFirst(14);
        testObject.removeFirst();
        testObject.addFirst(16);
        testObject.removeFirst();
        testObject.addFirst(18);
        testObject.addFirst(19);
        testObject.addLast(20);
        testObject.printDeque();
        System.out.println(testObject.size());
        testObject.removeFirst();
    }
}
