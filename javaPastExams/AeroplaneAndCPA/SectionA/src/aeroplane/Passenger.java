package aeroplane;

public abstract class Passenger {

    protected final String name;
    protected final String surname;

    public Passenger(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public abstract boolean isAdult();

    @Override
    public String toString() {
       return name + " " + surname;
    }
}
