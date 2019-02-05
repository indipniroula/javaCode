package simpleoop.simpleinterfaces.peoplecompare;

public class Person {
    private String forename;
    private String surname;
    private String phoneNum;

    public Person(String forename, String surname, String phoneNum) {
        this.forename = forename;
        this.surname = surname;
        this.phoneNum = phoneNum;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String toString() {
        return "Name: " + forename + ", Surname: " + surname + ", Phone Num: " + phoneNum;
    }

}
