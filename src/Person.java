import javax.lang.model.element.Name;



class Person {
    private String name;
    private String surname;
    private String email;


    //build a constructor
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


    //declare getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //create printperson method
    public void printPerson(){
        System.out.println("Name: "+name);
        System.out.println("Surname: "+surname);
        System.out.println("Email: "+email);
    }

    //override and return string
    public String toString(){
        return "Name: " +name +"\nSurname: "+surname +"\nEmail: "+email;
    }

}

