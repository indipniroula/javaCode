package aeroplane;

public class CrewMember extends Passenger {

    public CrewMember(String name, String surname) {
        super(name, surname);
    }

    @Override
    public boolean isAdult() {
        return true;
    }

}
