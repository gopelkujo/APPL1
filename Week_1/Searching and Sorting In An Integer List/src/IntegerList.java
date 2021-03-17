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
public class IntegerList {
    int[] list;
    
    public IntegerList(int size) {
        list = new int[size];
    }
    
    public void randomize() {
        for(int i=0; i<list.length; i++) {
            list[i] = (int)(Math.random() * 100) + 1;
        }
    }
    
    public  void print() {
        for(int i=0; i<list.length; i++) {
            System.out.println(i+1 + ":\t" + list[i]);
        }
    }
    
    public int search(int target) {
        int location = -1;
        for(int i=0; i<list.length && location == -1; i++) {
            if(list[i] == target) {
                location = i;
            }
        }
        return location;
    }
    
    public void selectionSort() {
        int minIndex;
        for(int i=0; i<list.length-1; i++) {
            minIndex = i;
            for(int j=i+1; j<list.length; j++) {
                if(list[j]<list[minIndex]) {
                    minIndex = j;
                }
            }
            int temp  = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
    
    public void replaceFirst(int oldVal, int newVal) {
        if(search(oldVal) != -1) {
            list[search(oldVal)] = newVal;
        }
        System.out.println("Result : \n");
        print();
    }
    
    public void replaceAll(int oldVal, int newVal) {
        while(search(oldVal) != -1) {
            list[search(oldVal)] = newVal;
        }
        System.out.println("Result : \n");
        print();
    }
    
    public void sortDecreasing() {
        int minIndex;
        for(int i=0; i<list.length-1; i++) {
            minIndex = i;
            for(int j=i+1; j<list.length; j++) {
                if(list[j]>list[minIndex]) {
                    minIndex = j;
                }
            }
            int temp  = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
    
    public int binarySearchD(int target) {
        sortDecreasing();
        int location = -1;
        for(int i=0; i<list.length && location == -1; i++) {
            if(list[i] == target) {
                location = i;
            }
        }
        return location;
    }
}
