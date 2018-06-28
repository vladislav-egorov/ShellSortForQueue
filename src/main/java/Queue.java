import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

class Queue {

    private LinkedList<Integer> queue;

    Queue(File inputData){

        try {
            Scanner scanner = new Scanner(inputData);
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");

            this.queue = new LinkedList<Integer>();

            for (String number : numbers) {
                int currentNumber = Integer.parseInt(number);
                this.queue.addLast(currentNumber);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void enqueue(int value){  //+2
        queue.addLast(value);
    }

    private void dequeue(){ //+2
        queue.removeFirst();
    }

    private int value(int position){  //+2
        return this.queue.get(position);
    }

    int size(){ //+2
        return this.queue.size();
    }

    void set(int position, int number){ // 17 + 3n
        if (position > this.size()){
            System.out.println("Invalid pos to set");
            return;
        }

        int tempSize = this.size();  //+1
        LinkedList<Integer> temp = new LinkedList<Integer>(); //+1

        for (int i = 0; i < tempSize; i++) { //+2 + n + 4 + 2
            temp.addFirst(this.value(0));
            this.dequeue();
        }

        for (int i = 0; i < position; i++) { //+2 + n + 4 + 2
            this.enqueue(temp.getLast());
            temp.removeLast();
        }

        this.enqueue(number); //+2
        temp.removeLast();  //+1

        while (temp.size() > 0) { // +1 + n + 4 + 1
            this.enqueue(temp.getLast());
            temp.removeLast();
        }
    }

    int get(int position){  //+2
        return value(position);
    }

    @Override
    public String toString(){
        return Arrays.toString(this.queue.toArray());
    }

}
