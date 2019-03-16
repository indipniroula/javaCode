package aeroplane;

public class EconomyPassenger extends NonCrewPassenger {

    public EconomyPassenger(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public boolean isBusiness() {
        return false;
    }
}
