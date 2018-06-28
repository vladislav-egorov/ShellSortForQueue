import org.junit.Test;

import java.io.File;

public class ShellSortTest {

    @Test
    public void testWithNewData() throws Exception {

        int capacity = 1000;
        ShellSort.createNewInputData(capacity);

        File inputData = new File("input.data");
        Queue qu = new Queue(inputData);

        long start = System.currentTimeMillis();
        ShellSort.sortForQueue(qu);
        long end = System.currentTimeMillis();

        System.out.println("OUTPUT: Queue with " + qu.size() + " elements has been sorted.");
        System.out.println("OUTPUT: Logic A took " + (end - start) + " MilliSeconds");
    }

    @Test
    public void testWithExistingData() throws Exception {
        File inputData = new File("input.data");
        Queue qu = new Queue(inputData);

        long start = System.currentTimeMillis();
        ShellSort.sortForQueue(qu);
        long end = System.currentTimeMillis();

        System.out.println("OUTPUT: Queue with " + qu.size() + " elements has been sorted.");
        System.out.println("OUTPUT: Logic A took " + (end - start) + " MilliSeconds");
    }

}