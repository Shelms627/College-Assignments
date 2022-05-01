/*
 * Name: Shane Helms
 * Course: COSC 1174
 * Date: 4/25/2021
 * Assignment: Shuffling and Sorting
 */
package genericssorting;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author shelm
 */
public class GenericsSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        
        numbers.add(4);
        numbers.add(2);
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        
        names.add("Ted");
        names.add("John");
        names.add("Kim");
        names.add("Erin");
        names.add("Alex");
        
        System.out.println("\nNumbers unedited: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        
        System.out.println("\nNumbers shuffled: ");
        shuffle(numbers);
        
        System.out.println("\nNumbers sorted: ");
        sort(numbers);
        
        System.out.println("\nNames unedited: ");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + ", ");
        }
        
        System.out.println("\nNames shuffled: ");
        shuffle(names);
        
        System.out.println("\nNames sorted: ");
        sort(names);
        
        
        
    } 
    
    public static <E> void shuffle(ArrayList<E> array) {
        Random random = new Random();
        E temp;
        
        for (int i = 0; i < array.size(); i++) {
            int x = random.nextInt(array.size());
            temp = array.get(x);
            array.set(x, temp); 
        }
        
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + ", ");
        }
    }
    
    public static <E extends Comparable<E>> void sort(ArrayList<E> array) {
        E currentMin;
        int currentMinIndex;
        
        for (int i = 0; i < array.size() - 1; i++) {
            // Find the minimum in the list[i+1..list.length−2]
            currentMin = array.get(i);
            currentMinIndex = i;
            
            for (int j = i + 1; j < array.size(); j++) {
                if (currentMin.compareTo(array.get(j)) > 0) {
                    currentMin = array.get(j);
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                array.set(currentMinIndex, array.get(i));
                array.set(i, currentMin);
            }
        }
        
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + ", ");
        }

    }
}
