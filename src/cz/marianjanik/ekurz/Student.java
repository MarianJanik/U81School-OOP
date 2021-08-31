package cz.marianjanik.ekurz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student extends Teacher{
//    private String nameStudent;
//    private String surnameStudent;
    private LocalDate birthdate;
    private int studentNumber;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yy");

    public Student(String nameStudent, String surnameStudent, LocalDate birthdate, int studentNumber) {
//        this.nameStudent = nameStudent;
//        this.surnameStudent = surnameStudent;
        super(nameStudent,surnameStudent);
        this.birthdate = birthdate;
        this.studentNumber = studentNumber;
    }

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

    public String getAllStudentInfo(){
        return getStudentNumber() + " - " + getFullName() + " " + formatter.format(this.birthdate); //TODO lepší je get nebo this?
    }
}
