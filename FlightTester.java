/*
Name: FlightTester
Project: Flight Information System Project
By: Johanne Christiana Menez (S4675880)
April 2024
*/

import java.util.Scanner;
import java.time.LocalTime;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;

//----------------------------------------------//
// FlightTester1: 
// Manually enter user inputs.
// Use of Flight.userInput();
//----------------------------------------------//
public class FlightTester {
   public static void main(String[] args){
      Flight.userInput(); // Capture the flights returned from userInput
   }

}


/*
// UNCOMMENT AREA TO TEST, and comment FlightTester1

//----------------------------------------------//
// FlightTester2:
// With given flight information to test program.
// Use of Flight.printDetails(flights);
//----------------------------------------------//
public class FlightTester {
   public static void main(String[] args){
      //-------------------------------------------------------------//
      // This creates an array of Flight objects and prints them
      // Driver Class
      //-------------------------------------------------------------//
      Flight [] flights = 
      {
      new Flight("PH Menez Airlines", "M123", "Philippines", "Qatar", 750, 200.50, LocalTime.of(8, 0), LocalTime.of(18, 22), 7310),
      new Flight("Qatar Aiways", "QR456", "Qatar", "Australia", 800, 900.30, LocalTime.of(9, 30), LocalTime.of(21, 45), 12190),
      new Flight("Georgia Airlines", "G453", "Georgia", "Qatar", 500, 450.00, LocalTime.of(10, 0), LocalTime.of(15, 30), 400.00),
      new Flight("Delta Airlines", "D232", "America", "Lebanon", 890, 700.23, LocalTime.of(14, 30), LocalTime.of(21, 45), 8000.00)
      };
      Flight.printDetails(flights);
      
   } // end main
} // end class 


*/