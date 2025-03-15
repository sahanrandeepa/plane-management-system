

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;



public class W2051647_PlaneManagement {
private static Ticket[] ticketArray = new Ticket[52];
private static int ticketcount =0;


 public static void main(String[] args) {

        //this is the welcome massage of application
        System.out.println("\nWelcome to the Plane Management application...!");
        boolean existState = true;


        //2D string array use for identify if seat is available or sold. As soon as seat buy, "0" replace with "1"
        String[][] arr = {{"0","0","0","0","0","0","0","0","0","0","0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0","0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};


        //use a while loop for iterate the program while user want to exit
        while (existState) {

            //Use a string array with for each loop for display menu option.
            String[] menu = {
                    "\n***************************************************",
                    "*                  MENU OPTION                    *",
                    "***************************************************",
                    "\t1)\tBuy a seat",
                    "\t2)\tCancel a seat",
                    "\t3)\tFind first available seat",
                    "\t4)\tShow seating plan",
                    "\t5)\tPrint tickets information and total sales",
                    "\t6)\tSearch ticket",
                    "\t0)\tQuit",
                    "***************************************************",
                    "Please select an option:"};
            for (String temp : menu) {
                System.out.println(temp);
            }


            Scanner input = new Scanner(System.in);

            //use a try catch statement to catch inputmismatch exeption for check user input is an integer
            try {
                int option = input.nextInt();

                /*Use a switch case for call the method when user want and I import scanner for each block
                for miss some issues.
                 */
                switch (option) {
                    case 1:
                        buy_seat(arr);
                        Scanner input6 = new Scanner(System.in);
                        System.out.println("Press any key to exit the Menu Option...!");
                        input6.nextLine();
                        System.out.println("Welcome again...!");
                        break;

                    case 2:
                        cancel_seat(arr);
                        Scanner input7 = new Scanner(System.in);
                        System.out.println("Press any key to exit the Menu Option...!");
                        input7.nextLine();
                        break;

                    case 3:
                        find_first_available(arr);
                        Scanner input8 = new Scanner(System.in);
                        System.out.println("Press any key to exit the Menu Option...!");
                        input8.nextLine();
                        break;

                    case 4:
                        show_seating_plan(arr);
                        Scanner input9 = new Scanner(System.in);
                        System.out.println("Press any key to exit the Menu Option...!");
                        input9.nextLine();
                        break;

                    case 5:
                        print_ticket_info();
                        Scanner input10 = new Scanner(System.in);
                        System.out.println("Press any key to exit the Menu Option...!");
                        input10.nextLine();
                        break;

                    case 6:
                        search_ticket(arr);
                        Scanner input11 = new Scanner(System.in);
                        System.out.println("Press any key to exit the Menu Option...!");
                        input11.nextLine();
                        break;

                    case 0:
                        System.out.println("Program is exiting now...!");
                        System.out.println("******************* GOOD BYE **********************");
                        existState = false;
                        break;
                    default:
                        System.out.println("Please Enter a number between 0 - 6");
                        Scanner input14 = new Scanner(System.in);

                }

            }catch(InputMismatchException e){
                System.out.println("Please enter a number...!");
                Scanner input12 = new Scanner(System.in);
                System.out.println("Press any key to try again...!");
                input12.nextLine();
            }



        }


    }


    public static void buy_seat(String[][] arr) {


        Scanner input = new Scanner(System.in);
        System.out.println("Enter the row letter");

        //convert user input to uppercase
        String rowLetter1 = input.next().toUpperCase();
        char rowLetter;

        //Use this if condition for avoid some mistakes when convert user input to char
        if(rowLetter1.length() == 1){

            //use this try statement for catch illegal argument exception to check that user input is a letter
            try{  rowLetter=rowLetter1.charAt(0);


            int seatPrice;

            if (rowLetter == 'A' || rowLetter == 'D') {

                Scanner input2 = new Scanner(System.in);
                System.out.println("Enter the seat number 1-14");
                String seatNum1 = input2.nextLine();
                int seatNum;


                //use this try statement for catch Number format exception to Check user input is a number
                try {
                     seatNum = Integer.parseInt(seatNum1);
                //row A
                    if (rowLetter == 'A') {


                        if ((seatNum > 14) || (seatNum == 0)) {
                            System.out.println("Please enter valid seat number...!");


                        //check availability of seat of user want with arr Array
                        // if seat is available "0" replace with "1"
                        //Ask the user's personal information and store its for variables
                        } else if (arr[0][seatNum - 1].equals("0")) {
                            arr[0][seatNum - 1] = "1";
                            Scanner input1 = new Scanner(System.in);
                            System.out.println("Enter Your name:");
                            String name= input1.nextLine();
                            System.out.println("Enter your surname:");
                            String surname= input1.nextLine();
                            System.out.println("Enter your Email:");
                            String email = input1.nextLine();


                            //check the price of user's seat
                            if (seatNum<=5) {
                                seatPrice=200;
                            }else if(seatNum<10){
                                seatPrice=150;
                            } else {
                                seatPrice=180;
                            }

                            //Create a new instance of ticket and person classes
                            Person person1 = new Person(name,surname,email);
                            Ticket ticket= new Ticket('A',seatNum,seatPrice,person1);

                            //store the ticket object to the ticketarray , saving and increment of ticketcount
                            ticketArray[ticketcount]=ticket;
                            ticket.save();
                            ticketcount++;

                            System.out.println("Seat booked successfully..!");

                        } else {
                            System.out.println("Seat no:" + seatNum + " is not available. Try another one.");
                        }


                    //row D
                    } else {
                        if ((seatNum > 14) || (seatNum == 0)) {
                            System.out.println("Please enter valid seat number...!");

                        } else if (arr[3][seatNum - 1].equals("0")) {
                            arr[3][seatNum - 1] = "1";

                            Scanner input1 = new Scanner(System.in);
                            System.out.println("Enter Your name:");
                            String name= input1.nextLine();
                            System.out.println("Enter your surname:");
                            String surname= input1.nextLine();
                            System.out.println("Enter your Email:");
                            String email = input1.nextLine();

                            if (seatNum<=5) {
                                seatPrice=200;
                            }else if(seatNum<10){
                                seatPrice=150;
                            } else {
                                seatPrice=180;
                            }

                            Person person1 = new Person(name,surname,email);
                            Ticket ticket= new Ticket('D',seatNum,seatPrice,person1);
                            ticketArray[ticketcount]=ticket;
                            ticket.save();
                            ticketcount++;

                            System.out.println("Seat booked successfully..!");

                        } else {
                            System.out.println("Seat no:" + seatNum + " is not available. Try another one.");
                        }
                    }
                }catch(NumberFormatException e){
                    System.out.println("Please enter a number...!");
                }

            }

            else if (rowLetter == 'B' || rowLetter =='C') {

                Scanner input3 = new Scanner(System.in);
                System.out.println("Enter the seat number 1-12");
                String seatNum1 = input3.nextLine();

                int seatNum;
                try {
                    seatNum = Integer.parseInt(seatNum1);
                    //row B
                    if (rowLetter == 'B') {
                        if ((seatNum > 12) || (seatNum == 0)) {
                            System.out.println("Please enter valid seat number...!");

                        } else if (arr[1][seatNum - 1].equals("0")) {
                            arr[1][seatNum - 1] = "1";

                            Scanner input1 = new Scanner(System.in);
                            System.out.println("Enter Your name:");
                            String name = input1.nextLine();
                            System.out.println("Enter your surname:");
                            String surname = input1.nextLine();
                            System.out.println("Enter your Email:");
                            String email = input1.nextLine();

                            if (seatNum <= 5) {
                                seatPrice = 200;
                            } else if (seatNum < 10) {
                                seatPrice = 150;
                            } else {
                                seatPrice = 180;
                            }
                            Person person1 = new Person(name, surname, email);
                            Ticket ticket = new Ticket('B', seatNum, seatPrice, person1);
                            ticketArray[ticketcount] = ticket;
                            ticket.save();
                            ticketcount++;

                            System.out.println("Seat booked successfully..!");

                        } else {
                            System.out.println("Seat no:" + seatNum + " is not available. Try another one.");
                        }

                        //row C
                    } else {
                        if ((seatNum > 12) || (seatNum == 0)) {
                            System.out.println("Please enter valid seat number...!");

                        } else if (arr[2][seatNum - 1].equals("0")) {
                            arr[2][seatNum - 1] = "1";

                            Scanner input1 = new Scanner(System.in);
                            System.out.println("Enter Your name:");
                            String name = input1.nextLine();
                            System.out.println("Enter your surname:");
                            String surname = input1.nextLine();
                            System.out.println("Enter your Email:");
                            String email = input1.nextLine();

                            if (seatNum <= 5) {
                                seatPrice = 200;
                            } else if (seatNum < 10) {
                                seatPrice = 150;
                            } else {
                                seatPrice = 180;
                            }
                            Person person1 = new Person(name, surname, email);
                            Ticket ticket = new Ticket('C', seatNum, seatPrice, person1);
                            ticketArray[ticketcount] = ticket;
                            ticket.save();
                            ticketcount++;

                            System.out.println("Seat booked successfully..!");

                        } else {
                            System.out.println("Seat no:" + seatNum + " is not available. Try another one.");
                        }
                    }
                }catch(NumberFormatException e){
                    System.out.println("Please enter a number...!");
                }

            }else{
                System.out.println("Row letter is incorrect. Try again ...!");
            }

        }catch(IllegalArgumentException e){
            System.out.println("Row letter must be a letter...!");
        }
        }else{
            System.out.println("Row letter must be a single letter...!");
        }

    }

    public static void cancel_seat(String[][] arr) {


        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the row letter");
        String rowlet=input.nextLine();

        //use this for avoid rowletter be a word. (eg:-when user enter "aaa" system take it as "a")
        if (rowlet.length()==1) {

            //convert input for char
            char rowLetter = rowlet.toUpperCase().charAt(0);

            int rowNum = 0;


            //initialize row letter as a for future calculations
            switch (rowLetter) {
                case 'A':

                    break;
                case 'B':
                    rowNum = 1;
                    break;
                case 'C':
                    rowNum = 2;
                    break;
                case 'D':
                    rowNum = 3;
                    break;
                default:
                    System.out.println("Your input for row number is incorrect. Try again...!");
                    return;
            }
            System.out.println("Please enter the seat number");
            int seatNum = input.nextInt();

            //use this statement for check user input a correct seat number available in plane
            if (((rowNum == 0 || rowNum == 3) && (seatNum > 14)) || ((rowNum == 1 || rowNum == 2) && (seatNum > 12))) {
                System.out.println("Your seat number is out of range. Try again...!");

            //check the seat is booked before with arr Array . if seat is bought before "1" replace with"0"
            } else if (arr[rowNum][seatNum - 1].equals("1")) {
                System.out.println("Your seat booking cancelled successfully...!");

                //create a new ticket instance and iterate it with for loop
                //check seat is available and if it's available clear the information regarded with this seat
                //delete the creted .txt file
                //decrement of ticketcount
                for (int i = 0; i < ticketcount; i++) {
                    Ticket cancel = ticketArray[i];

                    if (rowLetter == cancel.getRow() && seatNum == cancel.getSeat()) {
                        String row = String.valueOf(cancel.getRow());
                        File f = new File(row + cancel.getSeat() + ".txt");
                        f.delete();
                        ticketArray[i] = null;
                        for (int j = i; j < ticketcount; j++) {
                            if (ticketArray[j] == null) {
                                ticketArray[j] = ticketArray[j + 1];
                            } else {
                                break;

                            }

                        }
                    }


                }
                ticketcount--;
                arr[rowNum][seatNum - 1] = "0";


            } else {
                System.out.println("Your seat number is not reserved. Try again...!");
            }
        }else {
            System.out.println("Row letter must be a one letter. Try again...!");
        }
    }

    public static void find_first_available(String[][] arr){

        for (int i = 0; i < 14; i++) {
            if(arr[0][i].equals("0")){
                System.out.println("The first available seat is row A seat number "+(i+1)+".");
                return;
            }
        }
        for (int i = 0; i < 12; i++) {
            if(arr[1][i].equals("0")){
                System.out.println("The first available seat is row B seat number "+(i+1)+".");
                return;
            }
        }
        for (int i = 0; i < 12; i++) {
            if(arr[2][i].equals("0")){
                System.out.println("The first available seat is row C seat number "+(i+1)+".");
                return ;
            }
        }
        for (int i = 0; i < 14; i++) {
            if(arr[3][i].equals("0")){
                System.out.println("The first available seat is row D seat number "+(i+1)+".");
                return;
            }

        }




    }

    public static void show_seating_plan(String[][] arr){

        System.out.println("\n*** This is the seating plan ***");
        System.out.println(" ");


        //print arr Array with for loop
        for (int i = 0; i < 14; i++) {
            if (arr[0][i].equals("0")) {
                System.out.print('O');
                System.out.print(" ");
            }else{
                System.out.print('X');
                System.out.print(" ");
            }
        }
        System.out.print("\n");


        for (int i = 0; i < 12; i++) {
            if (arr[1][i].equals("0")) {
                System.out.print('O');
                System.out.print(" ");
            }else{
                System.out.print('X');
                System.out.print(" ");
            }
        }
        System.out.println("\n");

        for (int i = 0; i <12 ; i++) {
            if (arr[2][i].equals("0")) {
                System.out.print('O');
                System.out.print(" ");
            } else {
                System.out.print('X');
                System.out.print(" ");
            }
        }
        System.out.print("\n");

        for (int i = 0; i < 14; i++) {
            if (arr[3][i].equals("0")){
                System.out.print('O');
                System.out.print(" ");
            }else{
                System.out.print('X');
                System.out.print(" ");
            }
        }
        System.out.println("\n");
        System.out.println("X - Sold seats");
        System.out.println("O - Available seats");
        System.out.println("\n");
    }

    public static void print_ticket_info(){

     System.out.println("\n***** Tickets information *****\n");

       //use forloop iterate with ticketcount and call printticket method in ticket file
        for (int i = 0; i < ticketcount; i++) {
            Ticket printticket = ticketArray[i];
            printticket.printTicket();
            System.out.println("\n");
        }


        //count the total price of sold tickets with using ticket array
        System.out.println("***** Total price of the tickets *****");
        int total=0;
        for (int i = 0; i < ticketcount; i++) {
            Ticket ticketprice = ticketArray[i];
            total = total+ticketprice.getPrice();
        }
        System.out.println("");
        System.out.print("Total: £"+total+" (");
        for (int i = 0; i < ticketcount; i++) {
            Ticket linebuild = ticketArray[i];
            System.out.print(linebuild.getRow()+""+linebuild.getSeat()+" = £"+linebuild.getPrice()+" + ");
        }
        System.out.print("\b\b)");
        System.out.println("\n");
    }

    public static void search_ticket(String[][] arr){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the row letter");
        String rowlet = input.nextLine();

        //check user input is a one letter
        if (rowlet.length()==1) {

            char rowletter = rowlet.toUpperCase().charAt(0);

            int rowNum = 0;

            switch (rowletter) {
                case 'A':
                    break;
                case 'B':
                    rowNum = 1;
                    break;
                case 'C':
                    rowNum = 2;
                    break;
                case 'D':
                    rowNum = 3;
                    break;
                default:
                    System.out.println("Your row number is incorrect. Try again...!");
                    return;
            }
            System.out.println("Enter the seat number");

            Scanner input13 = new Scanner(System.in);
            int seatNum = input13.nextInt();

                //use this condition for check seat number is available in the plane
                if (arr[rowNum].length>= seatNum) {



                        for (int i = 0; i < ticketArray.length; i++) {
                            Ticket search = ticketArray[i];


                            //check the ticket array with user inputs and print information regarding ticket
                            //try to catch null point exception for null elements in ticket array
                            try{
                                if ((search.getRow() == rowletter)&&(search.getSeat() == seatNum)) {
                                        System.out.println("This is the information of your ticket");
                                        search.printTicket();
                                        System.out.println();
                                        return;
                                }


                            } catch (NullPointerException e) {
                                System.out.println("This seat is available.");
                                return;
                            }
                        }


                } else {
                    System.out.println("Enter valid seat number...!");
                }

        }else {
            System.out.println("Row letter must be a one letter. Try again...!");
        }

    }

}




