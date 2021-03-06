package cz.marianjanik.ekurz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student extends Teacher implements Comparable<Student>{
    private LocalDate birthdate;
    private int studentNumber;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yy");

    public Student(String nameStudent, String surnameStudent, LocalDate birthdate, int studentNumber) {
        super(nameStudent,surnameStudent);
        this.birthdate = birthdate;
        this.studentNumber = studentNumber;
    }

    // region getters and setters

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    // endregion

    /**
     * The method lists all information for printing.
     * @return text for printing.
     */
    public String getAllStudentInfo(){
        return getStudentNumber() + " - " + getFullName() + " " + formatter.format(getBirthdate());
    }

    /**
     * The method for sorting (Collections.sort).
     */
    @Override
    public int compareTo(Student second){
        return this.getSurname().compareTo(second.getSurname());
    }

}
