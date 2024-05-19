import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void TestAddFirst() {

        for (int time = 0; time < 10; time++) {
            // @source
            ArrayDequeSolution<Integer> sad1 = new ArrayDequeSolution<>();
            StudentArrayDeque<Integer> sad2 = new StudentArrayDeque<>();

            String message = "";

            for (int i = 0; i < 100; i++) {
                int randomNumber = StdRandom.uniform(4);

                if (randomNumber == 0) {
                    sad1.addFirst(i);
                    sad2.addFirst(i);
                    int index = sad1.size();
                    message += "addFirst(" + i + ")\n";
                    assertEquals(message, sad1.get(0), sad2.get(0));

                } else if (randomNumber == 1) {
                    sad1.addLast(i);
                    sad2.addLast(i);
                    int index1 = sad1.size() - 1;
                    int index2 = sad2.size() - 1;
                    message += "addLast(" + i + ")\n";
                    assertEquals(message, index1, index2);
                    assertEquals(message, sad1.get(index1), sad2.get(index2));

                } else if (randomNumber == 2 && !sad1.isEmpty() && !sad2.isEmpty()) {
                    message += "removeFirst()\n";
                    assertEquals(message, sad1.removeFirst(), sad2.removeFirst());

                } else if (randomNumber == 3 && !sad1.isEmpty() && !sad2.isEmpty()) {
                    message += "removeLast()\n";
                    assertEquals(message, sad1.removeLast(), sad2.removeLast());

                }
            }
        }
    }
}
