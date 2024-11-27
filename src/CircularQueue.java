import java.util.Scanner;

public class CircularQueue {
    public static String[] QueueArray = new String[10];
    public static Integer HeadPointer = 0;
    public static Integer TailPointer = 0;
    public static Integer NumberOfItems = 0;

    public static Boolean Enqueue(String DataToAdd){
        if(NumberOfItems == 10){
            return false;
        }
        QueueArray[TailPointer] = DataToAdd;
        if(TailPointer >= 9){
            TailPointer = -1;
        }else{
            TailPointer = TailPointer + 1;
        }
        NumberOfItems = NumberOfItems + 1;
        return true;
    }

    public static String Dequeue(){
        if(TailPointer == 0){
            return "FALSE";
        }
        HeadPointer = HeadPointer + 1;
        return QueueArray[HeadPointer - 1];
    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < 11; i++) {
            System.out.println("Enter an item to the queue: ");
            String DataItem = keyboard.next();
            if(Enqueue(DataItem)){
                System.out.println("Data Item Successfully added to the queue");
            }else{
                System.out.println("Queue if full; Unsuccessful attempt to add Data Item");
            }
        }
        System.out.println(Dequeue());
        System.out.println(Dequeue());
    }
}
