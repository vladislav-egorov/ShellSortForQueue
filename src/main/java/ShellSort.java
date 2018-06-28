import java.io.*;
import java.util.Random;

class ShellSort {

    static void sortForQueue(Queue queue) { // 6n^4 + 49n^3 + 5n^2 + 3n + 7
        int n = queue.size(); //+2

        int h = 1; //+1
        while (h < n/3) h = 3*h + 1; //+1 + n + 3

        while (h >= 1) { // (6n^3 + 49n^2 + 5n + 2) * n = 6n^4 + 49n^3 + 5n^2 + 2n
            for (int i = h; i < n; i++) { //(6n^2 + 49n + 5)*n = 6n^3 + 49n^2 + 5n
                for (int j = i; j >= h && less(queue.get(j), queue.get(j-h)); j -= h) { //(6n + 49) * n = 6n^2 + 49n
                    swap(queue, j, j-h); //6n + 39
                }
            }
            h /= 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    } //+2

    private static void swap(Queue a, int i, int j) { //6n + 39
        Integer swap = a.get(i); //+2
        a.set(i, a.get(j)); // 17 + 3n + 2
        a.set(j, swap); // 17 + 3n + 1
    }

    static void createNewInputData(int capacity){
        Writer writer = null;
        Random randomGenerator = new Random();

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("input.data"), "utf-8"));
            for (int i = 0; i < capacity; i++) {
                writer.write((randomGenerator.nextInt(1000) * (randomGenerator.nextBoolean() ? -1 : 1)) + " ");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception ex) {/*ignore*/}
        }

    }
}
