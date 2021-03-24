/*
 * CopyFile.java
 * Scan user files and print the data.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CopyFile {
    public static void main(String[] args){
        Scanner input_scanner;
        Scanner text_scanner;
        String file_name;
        File user_file;
        Boolean copied = false;
        
        while(!copied) {
            try {
                input_scanner = new Scanner(System.in);
                System.out.print("Your file name: ");
                file_name = input_scanner.nextLine();
                user_file = new File(file_name);
                if(user_file == null) {
                    throw new FileNotFoundException();
                } else {
                    text_scanner = new Scanner(user_file);
                    while(text_scanner.hasNextLine()) {
                        String data = text_scanner.nextLine();
                        System.out.print(data);
                    }
                    copied = true;
                }
            } catch(FileNotFoundException e) {
                System.out.print(e.getMessage() + "\n");
            }
        }
    }
}