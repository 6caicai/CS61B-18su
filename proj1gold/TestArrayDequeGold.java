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
                int caseNumber = StdRandom.uniform(4);
                int randomNumber = StdRandom.uniform(1000);

                if (caseNumber == 0) {
                    sad1.addFirst(randomNumber);
                    sad2.addFirst(randomNumber);
                    int index = sad1.size();
                    message += "addFirst(" + randomNumber + ")\n";

                } else if (caseNumber == 1) {
                    sad1.addLast(randomNumber);
                    sad2.addLast(randomNumber);
                    int index1 = sad1.size() - 1;
                    int index2 = sad2.size() - 1;
                    message += "addLast(" + randomNumber + ")\n";

                } else if (caseNumber == 2 && !sad1.isEmpty() && !sad2.isEmpty()) {
                    message += "removeFirst()\n";
                    assertEquals(message, sad1.removeFirst(), sad2.removeFirst());

                } else if (caseNumber == 3 && !sad1.isEmpty() && !sad2.isEmpty()) {
                    message += "removeLast()\n";
                    assertEquals(message, sad1.removeLast(), sad2.removeLast());

                }
            }
        }
    }
}
