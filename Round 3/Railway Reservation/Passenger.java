public class Passenger {
    private static int idprovider = 0;
    private int id;
    private String name;
    private int age;
    private char preference;
    private String berth;
    private int seatnumber;

    Passenger(String name, int age, char preference) {
        this.id = ++idprovider;
        this.name = name;
        this.age = age;
        this.preference = preference;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        Passenger.idprovider = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }

    public char getpreference() {
        return preference;
    }

    public void setpreference(char preference) {
        this.preference = preference;
    }

    public String getberth() {
        return berth;
    }

    public void setberth(String berth) {
        this.berth = berth;
    }

    public int getseatnumber() {
        return seatnumber;
    }

    public void setseatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }

    public String toString() {
        return "Id: " + this.getid() + "\nName: " + this.getname() + "\nAge: " + this.getage() + "\nPreference: "
                + this.getpreference() + "\nBerth: " + this.getberth() + "\nSeatNumber: " + this.getseatnumber();
    }

}
