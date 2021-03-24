/*
 * Warning.java
 * Choose the students which not pass the requirement and write it in to Warning.dat.
 */

import java.util.Scanner;
import java.io.*;
public class Warning {
    public static void main(String[] args) {
        int credit_hours = 0;
        double quality_points = 0;
        double gpa;
        String line, name = null, input_name = "D:\\Nauval\\students.dat";
        String output_name = "D:\\Nauval\\warning.dat";
        
        try {
            // set up scanner to input file
            File file_data = new File(input_name);
            Scanner read_file = new Scanner(file_data);
            // set up the output file stream
            FileWriter out_file = new FileWriter(output_name);
            // print a header to the ouput file
            out_file.write("\n");
            out_file.write("Students on Academic Warning\n");
            out_file.write("\n");
            
            int data_identifier = 0;
            while(read_file.hasNext()) {
                // get the credit hours and quality points and
                String data_file = read_file.next();
                switch(data_identifier) {
                    case 0:
                        name = data_file;
                        break;
                    case 1:
                        credit_hours = Integer.parseInt(data_file);
                        break;
                    case 2:
                        quality_points = Double.parseDouble((data_file));
                        break;
                }
                data_identifier++;
                if(data_identifier > 2) {
                    gpa = quality_points/credit_hours;
                    // determine if the student is on warning. If so,
                    if((gpa < 1.5 && credit_hours < 30) || (gpa < 1.75 && credit_hours < 60) || gpa < 2.0) {
                        // write the student data to the output file.
                        out_file.write(name + " " + credit_hours + " " + quality_points + "\n");
                    }
                    data_identifier = 0;
                }
            }
            //close output file
            out_file.close();
        } catch(FileNotFoundException exception) {
            System.out.println("The file " + input_name + " was not found.");
        } catch(IOException exception) {
            System.out.println(exception);
        } catch(NumberFormatException e) {
            System.out.println("Format error in input file: " + e);
        }
    }
}