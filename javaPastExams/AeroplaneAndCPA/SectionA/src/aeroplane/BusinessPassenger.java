package aeroplane;

public class BusinessPassenger extends NonCrewPassenger {

    private Luxury luxury;

    public BusinessPassenger(String name, String surname, int age, Luxury luxury) {
        super(name, surname, age);
        this.luxury = luxury;
    }

    @Override
    public boolean isBusiness() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString()
                + " Luxury: " + luxury.toString();
    }
}
