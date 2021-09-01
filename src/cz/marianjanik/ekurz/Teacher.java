package cz.marianjanik.ekurz;

public class Teacher {
    private String name;
    private String surname;

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // region getters and setters

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

    // endregion

    /**
     * The method lists all information for printing.
     * @return text for printing.
     */
    public String getFullName(){
        return this.name + " " + this.surname;
    }

}
