import java.io.FileWriter;
import java.io.IOException;

class Ticket {
   private char row;
   private int seat;
   private int price;
   private Person person;


   //build a constructor
    public Ticket(char row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }


//declare getters and setters
    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


//create printticket method
    public void printTicket(){
        System.out.println(person);
        System.out.println("Row letter: "+row);
        System.out.println("Seat number: "+seat);
        System.out.println("Price: £"+ price);
    }

    //create save method
    void save() {
        String row = String.valueOf(getRow());
        try {
            FileWriter w = new FileWriter(row + seat + ".txt");
            w.append("Row: ").append(String.valueOf(row)).append("\nSeat: ").append(String.valueOf(seat)).append("\nPrice: £").append(String.valueOf(price)).append("\nName: ").append(person.getName()).append("\nSurname: ").append(person.getSurname()).append("\nEmail: ").append(person.getEmail());
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
