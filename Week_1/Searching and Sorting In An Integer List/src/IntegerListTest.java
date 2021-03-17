/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gopel
 */
import java.util.Scanner;

public class IntegerListTest {
    static IntegerList list = new IntegerList(10);
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        printMenu();
        int choice = scan.nextInt();
        while(choice != 0) {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }
    }
    
    public static void dispatch(int choice) {
        int loc;
        switch(choice) {
            case 0:
                System.out.println("Bye!");
            case 1:
                System.out.println("How big should the list be?");
                int size = scan.nextInt();
                list = new IntegerList(size);
                list.randomize();
                break;
            case 2:
                list.selectionSort();
                break;
            case 3:
                System.out.print("Enter the value to look for: ");
                loc = list.search(scan.nextInt());
                if(loc != -1)
                    System.out.println("Found at location " + (loc+1));
                else
                    System.out.println("Not in list");
                break;
            case 4:
                list.print();
                break;
            case 5:
                System.out.print("Old value : ");
                int oldVal = scan.nextInt();
                System.out.print("New value : ");
                int newVal = scan.nextInt();
                list.replaceFirst(oldVal,newVal);
                break;
            case 6:
                System.out.print("Old value : ");
                oldVal = scan.nextInt();
                System.out.print("New value : ");
                newVal = scan.nextInt();
                list.replaceAll(oldVal,newVal);
                break;
            case 7:
                list.sortDecreasing();
                break;
            case 8:
                System.out.print("Enter the value to look for: ");
                loc = list.binarySearchD(scan.nextInt());
                if(loc != -1)
                    System.out.println("Found at location " + (loc+1));
                else
                    System.out.println("Not in list");
                break;
            default:
                System.out.println("Sorry, invalid choice");
        }
    }
    
    public static void printMenu() {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Create a new list (** do this first!! **");
        System.out.println("2: Sort the list using selection sort");
        System.out.println("3: Find an element in the list using linear search");
        System.out.println("4: Print the list");
        System.out.println("5: Replace first");
        System.out.println("6: Replace all");
        System.out.println("7: Sort decreasing");
        System.out.println("8: Binary search");
        System.out.print("\nEnter your choice: ");
    }
}
