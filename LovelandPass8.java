/* 
Angelia
10/27/2018
CSCI 1015-W1S
Programming Assignment 8
Program's purpose: Take information from company dat file, include tax on beginning balance, and 
to create new file with customer number and ending balance.
*/

import java.util.Scanner;
import java.io.*;

public class LovelandPass8
{
   public static void main(String[] args) throws IOException
   {
      int customerNo;
      double beginBal;
      double purchases;
      double payments;
      double endingBal;
      double total1 = 0;
      double total2 = 0;
      double total3 = 0;
      double total4 = 0;
      double total5 = 0;
      double tax;
      final double TAX = .01;
      String inputFile = "BeginningBalance.dat";
      String outputFile = "NewBalance.dat";
      
      try
      {
         //Creating a file reader
         File file = new File ("BeginningBalance.dat");
         Scanner inFile = new Scanner(file);
         
         //Creating a file writer
         PrintWriter output = new PrintWriter(outputFile);
         
         //Giving user the output
         System.out.printf("%-12s%15s%20s%20s%20s%20s\n", "Customer No", "Beg. Bal.", "Finance Charges","Purchases", "Payments", "Ending Bal.");
         
         //Start the while loop
         while(inFile.hasNext())
         {
            customerNo = Integer.parseInt(inFile.nextLine());
            beginBal = Double.parseDouble(inFile.nextLine());
            purchases = Double.parseDouble(inFile.nextLine());
            payments = Double.parseDouble(inFile.nextLine());
            
            //Getting the tax for beginning balance
            tax = beginBal * TAX;
            //Getting the ending balance totals
            endingBal = beginBal + tax + purchases + payments;
            
            //Getting the totals for all columns
            total1 = total1 + beginBal;
            total2 = total2 + tax;
            total3 = total3 + purchases;
            total4 = total4 + payments;
            total5 = total5 + endingBal;
            
            //Printing out the information for all columns and writing the Customer No and Ending Bal to the new balance file
            System.out.printf("%-12s%15s%20s%20s%20s%20s\n", customerNo, beginBal, tax, purchases, payments, endingBal);
            output.println(customerNo);
            output.println(endingBal);
            
         }
         
         //Printing the totals for all columns
         System.out.printf("\n%-12s%15s%20s%20s%20s%20s", "Totals: ", total1, total2, total3, total4, total5);
         //Closing the files
         inFile.close();
         output.close();
        }
        //Catch statement with the file not found exception
        catch(FileNotFoundException e)
        {
           System.out.println(inputFile + " Cannot be found");
        }
        
     }
}