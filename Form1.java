/*
Name: Form1
Project: Flight Information System Project
By: Johanne Christiana Menez (S4675880)
April 2024
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Comparator;

public class Form1 extends JFrame {

    // Class to represent a flight
    private class Flight {
        String airlineName;
        String flightNumber;
        String flightOrigin;
        String flightDestination;
        int availableSeats;
        double airfare;
        String departureTime;
        String arrivalTime;
        double distance;

        //-------------------------------------------------------------------//
        // Constructor: Sets up this Flight object with the specified
        // details of the flight
        //-------------------------------------------------------------------//
        public Flight(String airlineName, String flightNumber, String flightOrigin, String flightDestination,
                      int availableSeats, double airfare, String departureTime, String arrivalTime, double distance) {
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
         public String getFlightNumber() 
         {
         return flightNumber;
         }
         
         public String getFlightName()
         {
         return airlineName;
         }
         
        // Override toString() to customize display in JTextArea
        public String toString() {
            return "Airline Name: " + airlineName +
                    "\nFlight Number: " + flightNumber +
                    "\nFlight Origin: " + flightOrigin +
                    "\nFlight Destination: " + flightDestination +
                    "\nAvailable Seats: " + availableSeats +
                    "\nAirfare: " + airfare +
                    "\nDeparture Time: " + departureTime +
                    "\nArrival Time: " + arrivalTime +
                    "\nDistance: " + distance + "\n\n";
        }
    }

    // JTextFields for User to input data
    private JTextField input_airlineName;
    private JTextField input_flightNumber;
    private JTextField input_flightOrigin;
    private JTextField input_flightDestination;
    private JTextField input_availableSeats;
    private JTextField input_airfare;
    private JTextField input_departureTime;
    private JTextField input_arrivalTime;
    private JTextField input_distance;

    // Menu
    private JMenuBar menuBar;

    // Buttons
    private JButton addButton, showButton;
    private JTextArea displayArea;
    
    // Added JLabel for displaying text above JTextArea
    private JLabel displayLabel;
    
    // Array to store Flight objects
    private Flight[] flights; 
    private int flight_count;

    //------------------------------------------------------Flight GUI------------------------------------------------------//
    public Form1() {
        super("Flight Information System");
        menuBar = new JMenuBar(); // Initialize the menu bar
        flights = new Flight[10]; // Initialize array with size 10      
        flight_count = 0;
        
        setLayout(new BorderLayout()); // Set BorderLayout for the JFrame

        //---------------------------------------------------START PANELS---------------------------------------------------//
        //----------------------------Panel for holding input components----------------------------//
        JPanel inputPanel = new JPanel(new GridLayout(4, 4)); // Grid layout for input fields

        // Creating panels for each set of text fields
        JPanel airlinePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        airlinePanel.add(new JLabel("Airline Name:"));
        input_airlineName = new JTextField(17);
        airlinePanel.add(input_airlineName);

        JPanel flightNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        flightNumberPanel.add(new JLabel("Flight Number:"));
        input_flightNumber = new JTextField(17);
        flightNumberPanel.add(input_flightNumber);

        JPanel originPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        originPanel.add(new JLabel("Flight Origin:"));
        input_flightOrigin = new JTextField(17);
        originPanel.add(input_flightOrigin);

        JPanel destinationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        destinationPanel.add(new JLabel("Flight Destination:"));
        input_flightDestination = new JTextField(14);
        destinationPanel.add(input_flightDestination);

        JPanel seatsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        seatsPanel.add(new JLabel("Available Seats:"));
        input_availableSeats = new JTextField(16);
        seatsPanel.add(input_availableSeats);

        JPanel airfarePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        airfarePanel.add(new JLabel("Airfare:"));
        input_airfare = new JTextField(20);
        airfarePanel.add(input_airfare);

        JPanel departurePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        departurePanel.add(new JLabel("Departure Time:"));
        input_departureTime = new JTextField(15);
        departurePanel.add(input_departureTime);

        JPanel arrivalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        arrivalPanel.add(new JLabel("Arrival Time:"));
        input_arrivalTime = new JTextField(18);
        arrivalPanel.add(input_arrivalTime);

        JPanel distancePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        distancePanel.add(new JLabel("Distance:"));
        input_distance = new JTextField(19);
        distancePanel.add(input_distance);

        // Menu
        JMenu displayMenu = new JMenu("Sort by");
        // Create menu items
        JMenuItem sortItem = new JMenuItem("Flight Number");
        JMenuItem sortItem_FlightName = new JMenuItem("Flight Name");
        
        // Buttons
        addButton = new JButton("Add");
        showButton = new JButton("Show");

        // Adding panels to the input panel
        inputPanel.add(airlinePanel);
        inputPanel.add(flightNumberPanel);
        inputPanel.add(originPanel);
        inputPanel.add(destinationPanel);
        inputPanel.add(seatsPanel);
        inputPanel.add(airfarePanel);
        inputPanel.add(departurePanel);
        inputPanel.add(arrivalPanel);
        inputPanel.add(distancePanel);
        
        //-------------------------------Menu Panel-------------------------------//   
        // Add menu items to the menu
        displayMenu.add(sortItem);
        displayMenu.add(sortItem_FlightName);
        
        // Add the menu to the menu bar
        menuBar.add(displayMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);
        
        //----------------------------Panel for buttons----------------------------//
        // Creating a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // add button to Panel
        buttonPanel.add(addButton);
        buttonPanel.add(showButton);

        // Changing button size
        //                                        x    y
        addButton.setPreferredSize(new Dimension(145, 35));
        showButton.setPreferredSize(new Dimension(145, 35));
        
        // Add the button panel to the input panel
        inputPanel.add(buttonPanel);

        //--------Display Panel for holding display components for the set of input fields--------//
        // Panel for holding Airline Name 1
        JPanel displayPanel1 = new JPanel(new BorderLayout());
        JLabel displayLabel1 = new JLabel("Airline Name");
        JTextArea displayArea1 = new JTextArea(15, 40);
        displayArea1.setEditable(false);
        displayPanel1.add(displayLabel1, BorderLayout.NORTH);
        displayPanel1.add(new JScrollPane(displayArea1), BorderLayout.CENTER);

        // Flight Number 2
        JPanel displayPanel2 = new JPanel(new BorderLayout());
        JLabel displayLabel2 = new JLabel("Flight Number");
        JTextArea displayArea2 = new JTextArea(15, 40);
        displayArea2.setEditable(false);
        displayPanel2.add(displayLabel2, BorderLayout.NORTH);
        displayPanel2.add(new JScrollPane(displayArea2), BorderLayout.CENTER);

        // Flight Origin 3
        JPanel displayPanel3 = new JPanel(new BorderLayout());
        JLabel displayLabel3 = new JLabel("Flight Origin");
        JTextArea displayArea3 = new JTextArea(15, 40);
        displayArea3.setEditable(false);
        displayPanel3.add(displayLabel3, BorderLayout.NORTH);
        displayPanel3.add(new JScrollPane(displayArea3), BorderLayout.CENTER);

        // Flight Destination 4
        JPanel displayPanel4 = new JPanel(new BorderLayout());
        JLabel displayLabel4 = new JLabel("Flight Destination");
        JTextArea displayArea4 = new JTextArea(15, 40);
        displayArea4.setEditable(false);
        displayPanel4.add(displayLabel4, BorderLayout.NORTH);
        displayPanel4.add(new JScrollPane(displayArea4), BorderLayout.CENTER);
        
        // Available Seats 5
        JPanel displayPanel5 = new JPanel(new BorderLayout());
        JLabel displayLabel5 = new JLabel("Available Seats");
        JTextArea displayArea5 = new JTextArea(15, 40);
        displayArea5.setEditable(false);
        displayPanel5.add(displayLabel5, BorderLayout.NORTH);
        displayPanel5.add(new JScrollPane(displayArea5), BorderLayout.CENTER);

        // Airfare 6
        JPanel displayPanel6 = new JPanel(new BorderLayout());
        JLabel displayLabel6 = new JLabel("Airfare");
        JTextArea displayArea6 = new JTextArea(15, 40);
        displayArea6.setEditable(false);
        displayPanel6.add(displayLabel6, BorderLayout.NORTH);
        displayPanel6.add(new JScrollPane(displayArea6), BorderLayout.CENTER);
        
        // Departure Time 7 
        JPanel displayPanel7 = new JPanel(new BorderLayout());
        JLabel displayLabel7 = new JLabel("Departure Time");
        JTextArea displayArea7 = new JTextArea(15, 40);
        displayArea7.setEditable(false);
        displayPanel7.add(displayLabel7, BorderLayout.NORTH);
        displayPanel7.add(new JScrollPane(displayArea7), BorderLayout.CENTER);
        
        // Arrival Time 8
        JPanel displayPanel8 = new JPanel(new BorderLayout());
        JLabel displayLabel8 = new JLabel("Arrival Time");
        JTextArea displayArea8 = new JTextArea(15, 40);
        displayArea8.setEditable(false);
        displayPanel8.add(displayLabel8, BorderLayout.NORTH);
        displayPanel8.add(new JScrollPane(displayArea8), BorderLayout.CENTER);
 
         // Distance 9
        JPanel displayPanel9 = new JPanel(new BorderLayout());
        JLabel displayLabel9 = new JLabel("Distance");
        JTextArea displayArea9 = new JTextArea(15, 40);
        displayArea9.setEditable(false);
        displayPanel9.add(displayLabel9, BorderLayout.NORTH);
        displayPanel9.add(new JScrollPane(displayArea9), BorderLayout.CENTER);
         
        //----------------------------Panel for holding the display panels----------------------------//
        JPanel mainDisplayPanel = new JPanel(new GridLayout(1, 9));
        mainDisplayPanel.add(displayPanel1);
        mainDisplayPanel.add(displayPanel2);
        mainDisplayPanel.add(displayPanel3);
        mainDisplayPanel.add(displayPanel4);
        mainDisplayPanel.add(displayPanel5);
        mainDisplayPanel.add(displayPanel6);
        mainDisplayPanel.add(displayPanel7);
        mainDisplayPanel.add(displayPanel8);
        mainDisplayPanel.add(displayPanel9);
        
        // Add components to the JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(mainDisplayPanel, BorderLayout.CENTER);
        
        //---------------------------------------------------END PANELS---------------------------------------------------//
        
        // --------------------------------------------------------------------//
        // Action listeners for buttons
        // This tells what action should be performed when button/item is clicked
        // It updates the display areas (e.g., JTextAreas)
        //--------------------------------------------------------------------//
        
        // addButton
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToArray();
            }
        });
        // showButton
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayArray(displayArea1, displayArea2, displayArea3, displayArea4, displayArea5, displayArea6, displayArea7, displayArea8, displayArea9);
            }
        });
              
        // sortItem
        sortItem.addActionListener(new ActionListener() { 
           public void actionPerformed(ActionEvent e) { 
                Arrays.sort(flights, 0, flight_count, Comparator.comparing(f -> f.flightNumber));
                displayArray(displayArea1, displayArea2, displayArea3, displayArea4, displayArea5, displayArea6, displayArea7, displayArea8, displayArea9);
            } 
        });
        
        // flightName sort
        sortItem_FlightName.addActionListener(new ActionListener() { 
           public void actionPerformed(ActionEvent e) { 
                Arrays.sort(flights, 0, flight_count, Comparator.comparing(f -> f.airlineName));
                displayArray(displayArea1, displayArea2, displayArea3, displayArea4, displayArea5, displayArea6, displayArea7, displayArea8, displayArea9);
            } 
        });

        
        //--------------------------------------------------------------------//
        // End Action listeners
        //--------------------------------------------------------------------//
     
    } // end Form1()

    private void addToArray() {
        if (flight_count < flights.length) {
            try {
                // Read user inputs
                String airlineName = input_airlineName.getText();
                String flightNumber = input_flightNumber.getText();
                String flightOrigin = input_flightOrigin.getText();
                String flightDestination = input_flightDestination.getText();
                int availableSeats = Integer.parseInt(input_availableSeats.getText());
                double airfare = Double.parseDouble(input_airfare.getText());
                String departureTime = input_departureTime.getText();
                String arrivalTime = input_arrivalTime.getText();
                double distance = Double.parseDouble(input_distance.getText());

                // Create a new Flight object
                Flight flight = new Flight(airlineName, flightNumber, flightOrigin, flightDestination,
                        availableSeats, airfare, departureTime, arrivalTime, distance);
                // Add the flight to the flights array
                flights[flight_count++] = flight;

                // Clear input fields
                input_airlineName.setText("");
                input_flightNumber.setText("");
                input_flightOrigin.setText("");
                input_flightDestination.setText("");
                input_availableSeats.setText("");
                input_airfare.setText("");
                input_departureTime.setText("");
                input_arrivalTime.setText("");
                input_distance.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid entries only");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Array is full.");
        }
    }// end addToArray()

    private void displayArray(JTextArea displayArea1, JTextArea displayArea2, JTextArea displayArea3, JTextArea displayArea4, JTextArea displayArea5, 
                              JTextArea displayArea6, JTextArea displayArea7, JTextArea displayArea8, JTextArea displayArea9) {
        // Clear previous data in the JTextAreas
        displayArea1.setText("");
        displayArea2.setText("");
        displayArea3.setText("");
        displayArea4.setText("");
        displayArea5.setText("");
        displayArea6.setText("");
        displayArea7.setText("");
        displayArea8.setText("");
        displayArea9.setText("");

        //--------------------------------------------------------------------//
        // Append information of each flight to the respective 
        // JTextAreas based on flight_count. 
        // This is the display Area where the inputs go:
        //--------------------------------------------------------------------//
        
        for (int i = 0; i < flight_count; i++) {
                displayArea1.append(flights[i].airlineName + "\n");
                displayArea2.append(flights[i].flightNumber + "\n");
                displayArea3.append(flights[i].flightOrigin + "\n");
                displayArea4.append(flights[i].flightDestination + "\n");
                displayArea5.append(flights[i].availableSeats + "\n");
                displayArea6.append(flights[i].airfare + "\n");
                displayArea7.append(flights[i].departureTime + "\n");
                displayArea8.append(flights[i].arrivalTime + "\n");
                displayArea9.append(flights[i].distance + "\n");
        }
    } // end displayArray()
    
   //-----------Main-----------//
    public static void main(String[] args) {
        Form1 gui = new Form1();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1850, 900); // Adjusted size for better visibility
        gui.setVisible(true);    
    } // end main
} // end class
