import java.util.Scanner;
public class CountLetters {
    public static void main(String[] args) {
        int[] counts = new int[26];
        int error_letter_position;
        Scanner scan = new Scanner(System.in);
        
        // exception started
        try {
            // get word from user
            System.out.print("Enter a single word (letters only, please): ");
            String word = scan.nextLine();

            // convert to all upper case
            word = word.toUpperCase();
            // count frequency of each letter in string
            for(int i = 0; i < word.length(); i++)
                if(word.charAt(i)-'A' < 0 || word.charAt(i)>25)
                    counts[word.charAt(i) - 'A']++;
                else {
                    error_letter_position = i+1;
                    break;
                }

            // print frequencies
            System.out.println();
            for(int i = 0; i < counts.length; i++)
                if(counts[i] != 0)
                    System.out.println((char)(i + 'A') + ": " + counts[i]);            
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Not a letter!");
            System.out.println(e.getMessage());
        }
    } 
}
