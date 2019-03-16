package aeroplane;

public abstract class NonCrewPassenger extends Passenger {

    private int age;

    public NonCrewPassenger(String name, String surname, int age) {
        super(name, surname);
        this.age = age;
    }

    @Override
    public boolean isAdult() {
        return age >= 18;
    }

    public abstract boolean isBusiness();

    @Override
    public String toString() {
        if (isBusiness()) {
            return "Name:" + name + " Age:" + age +
                    " Type: Business";
        } else {
            return "Name:" + name + " Age:" + age +
                    " Type: Economy";
        }
    }
}
