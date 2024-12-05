import java.util.Scanner;

public class CircularQueue {
    public static String[] QueueArray = new String[10];
    public static Integer HeadPointer = 0;
    public static Integer TailPointer = 0;
    public static Integer NumberOfItems = 0;

    public static Boolean Enqueue(String DataToAdd){
        if(NumberOfItems == 10){
            System.out.println("Queue if full; Unsuccessful attempt to add Data Item");
            return false;
        }
        QueueArray[TailPointer] = DataToAdd;
        if(TailPointer >= 9){
            TailPointer = -1;
        }else{
            TailPointer = TailPointer + 1;
        }
        NumberOfItems = NumberOfItems + 1;
        System.out.println("Data Item Successfully added to the queue");
        return true;
    }

    public static String Dequeue(){
        if(TailPointer == 0){
            System.out.println("Dequeue Unsuccessful");
            return "FALSE";
        }
        HeadPointer = HeadPointer + 1;
        return QueueArray[HeadPointer - 1];
    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String DataItem;
        String Operation;
        do{
            System.out.println("Enter Operation to perform (Enqueue/Dequeue) or no to stop: ");
            Operation = keyboard.next();
            if(Operation.toLowerCase().equals("enqueue")){
                System.out.println("Enter an item to the queue: ");
                DataItem = keyboard.next();
                Enqueue(DataItem);
            } else if (Operation.toLowerCase().equals("dequeue")) {
                System.out.println("Dequeued Value: " + Dequeue());
            }
        }while(!Operation.equals("no"));
    }
}
