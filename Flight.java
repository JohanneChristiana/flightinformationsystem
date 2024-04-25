/*
Name: Flight class
Project: Flight Information System Project
By: Johanne Christiana Menez (S4675880)
April 2024
*/

import java.util.Scanner;
import java.time.LocalTime;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;

public class Flight {
   String airlineName; 
   String flightNumber; 
   String flightOrigin;
   String flightDestination;
   int availableSeats; 
   double airfare;
   LocalTime departureTime;
   LocalTime arrivalTime;
   double distance;
   
   //-------------------------------------------------------------------//
   // Constructor: Sets up this Flight object with the specified
   // details of the flight
   //-------------------------------------------------------------------//
   public Flight (String airlineName, String flightNumber, String flightOrigin, String flightDestination, 
                  int availableSeats, double airfare, LocalTime departureTime, LocalTime arrivalTime, double distance) {
   this.airlineName = airlineName;
   this.flightNumber = flightNumber;
   this.flightOrigin = flightOrigin;
   this.flightDestination = flightDestination;
   this.availableSeats = availableSeats;
   this.airfare = airfare;
   this.departureTime = departureTime;
   this.arrivalTime = arrivalTime;
   this.distance = distance;
   }
   
   //-------------------------------------------------------------------//
   // Getter method for flight number
   //-------------------------------------------------------------------//
   public String getFlightNumber() {
   return flightNumber;
   }
   
   //-------------------------------------------------------------------//
   // toString() method / Returns a string representation of this Flight.
   //-------------------------------------------------------------------//
   public String toString() {
   // Calculate Duration of Flight; this uses LocalTime class and Duration.between() method.
   Duration duration = Duration.between(departureTime, arrivalTime); 
   return String.format("%-20s %-15s %-15s %-15s %-18s %-15.2f %-15s %-15s %-15s %-10.2f", 
          airlineName, flightNumber, flightOrigin, flightDestination, 
          availableSeats, airfare, departureTime, arrivalTime, duration.toHours() + "h " + 
          duration.toMinutesPart() + "m", distance);
   } 
      
   //-------------------------------------------------------------------//
   // toSort() method / Sorting flights by first letter of flight number.
   //-------------------------------------------------------------------//
    public static void toSort(Flight[] flights) {
        Arrays.sort(flights, Comparator.comparing(f -> f.getFlightNumber().substring(0, 1)));
    }
   
   //---------------------User inputs---------------------//
   public static void userInput(){
   Scanner scan = new Scanner(System.in);
   
   //-----------------------------------Introduction-----------------------------------//
   System.out.println("=====================================================");
   System.out.println("\t\tWelcome to the Flight Information System");
   System.out.println("=====================================================");
   
   //------------------------------------User Input------------------------------------//
   System.out.print("Enter the number of flights: ");
   int flight_count = scan.nextInt();
   scan.nextLine(); // Skip the newline 
   
      Flight[] flights = new Flight[flight_count]; // Created an array; flights

      for(int i = 0; i < flight_count; i++){
      System.out.println("-----------------------------------------------------");
      System.out.println("Enter details for Flight " + (i + 1) + ":");
      System.out.println("");
      
      System.out.print("Airline Name: ");
      String airlineName = scan.nextLine();
      
      System.out.print("Flight Number: ");
      String flightNumber = scan.nextLine();

      System.out.print("Flight Origin: ");
      String flightOrigin = scan.nextLine();
      
      System.out.print("Destination: ");
      String flightDestination = scan.nextLine();
      
      System.out.print("Available seats: ");
      int availableSeats = scan.nextInt();
      
      System.out.print("Airfare: ");
      double airfare = scan.nextDouble();
      scan.nextLine(); // Consume the newline left by previous nextDouble

      //----------------------Departure----------------------//
      System.out.print("Departure Time (HH:MM): ");
      String departure_input = scan.nextLine(); //String input by user
      
      String[] departureParts = departure_input.split(":"); // Split input by ":"
      int departure_hour = Integer.parseInt(departureParts[0]);
      int departure_minute = Integer.parseInt(departureParts[1]);
      LocalTime departureTime = LocalTime.of(departure_hour, departure_minute); // LocalTime object represent departure time
      
      //-----------------------Arrival-----------------------//
      System.out.print("Arrival Time (HH:MM): ");
      String arrival_input = scan.nextLine();
      
      String[] arrivalParts = arrival_input.split(":");
      int arrival_hour = Integer.parseInt(arrivalParts[0]);
      int arrival_minute = Integer.parseInt(arrivalParts[1]);
      LocalTime arrivalTime = LocalTime.of(arrival_hour, arrival_minute);
      
      System.out.print("Distance: ");
      double distance = scan.nextDouble();
      
      flights[i] = new Flight(airlineName, flightNumber, flightOrigin, flightDestination, availableSeats, airfare, departureTime, arrivalTime, distance);
      
      scan.nextLine(); // Skip the newline 
 
       } // loop end
       Flight.printDetails(flights);
    } // end userInput()
      
     
      public static void printDetails(Flight[] flights){  
      //-------------------------------------Before Sorting--------------------------------------//
      System.out.println("");   
      System.out.println("Before Sorting:");  
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.printf("%-20s %-15s %-15s %-15s %-18s %-15s %-15s %-15s %-15s %-15s\n",
                   "AIRLINE NAME", "FLIGHT NUMBER", "FLIGHT ORIGIN", "DESTINATION", "AVAILABLE SEATS", "AIRFARE", "DEPARTURE TIME", "ARRIVAL TIME", "DURATION", "DISTANCE");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");

      for (Flight f : flights)
      System.out.println (f);
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      
      //-------------------------------------After Sorting--------------------------------------//
      System.out.println("");   
      System.out.println("After Sorting:");  
      Flight.toSort(flights); // Call the sorting method
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.printf("%-20s %-15s %-15s %-15s %-18s %-15s %-15s %-15s %-15s %-15s\n",
                   "AIRLINE NAME", "FLIGHT NUMBER", "FLIGHT ORIGIN", "DESTINATION", "AVAILABLE SEATS", "AIRFARE", "DEPARTURE TIME", "ARRIVAL TIME", "DURATION", "DISTANCE");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");

      for (Flight f : flights)
      System.out.println (f);
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
   } // end printDetails()
}// end class



