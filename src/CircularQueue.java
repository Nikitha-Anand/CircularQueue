import java.util.Objects;
import java.util.Scanner;

public class CircularQueue {
    public static String[] QueueArray = new String[10];
    public static Integer HeadPointer = 0;
    public static Integer TailPointer = 0;
    public static Integer NumberOfItems = 0;

    public static void Enqueue(String DataToAdd){
        if(NumberOfItems == 10){
            System.out.println("Queue if full; Unsuccessful attempt to add Data Item");
            return;
        }
        QueueArray[TailPointer] = DataToAdd;
        if(TailPointer >= 9){
            TailPointer = 0;
        }else{
            TailPointer = TailPointer + 1;
        }
        NumberOfItems = NumberOfItems + 1;
        System.out.println("Data Item Successfully added to the queue");
    }

    public static String Dequeue(){
        if(NumberOfItems == 0){
            System.out.println("Dequeue Unsuccessful! Queue is Empty!");
            return "null";
        }
        if(HeadPointer >= 9) {
            HeadPointer = 0;
        }
        HeadPointer = HeadPointer + 1;
        NumberOfItems = NumberOfItems - 1;
        System.out.println("Dequeue Successful!");
        return QueueArray[HeadPointer - 1];
    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String DataItem;
        String Operation;
        do{
            System.out.println("Enter Operation to perform (Enqueue/Dequeue) or \"NO\" to stop: ");
            Operation = keyboard.next();
            if(Operation.equalsIgnoreCase("enqueue")){
                System.out.println("Enter an item to the queue: ");
                DataItem = keyboard.next();
                Enqueue(DataItem);
            } else if (Operation.equalsIgnoreCase("dequeue")) {
                System.out.println("\nDequeued Value: " + Dequeue());
            } else if (!Operation.equalsIgnoreCase("no")){
                System.out.println("Sorry! It is not a valid operation! Try Enqueue/Dequeue or \"NO\" to exit");
            }
        }while(!Operation.equalsIgnoreCase("no"));
    }
}
