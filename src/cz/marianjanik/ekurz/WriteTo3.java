package cz.marianjanik.ekurz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class WriteTo3 implements ReadWrite{

    DecimalFormat myFormat = new DecimalFormat("000");

    @Override
    public void writeToConsole(SchoolClass schoolClass) {
        System.out.println(getInfoForWrite(schoolClass));
    }

    @Override
    public void writeToFile(String fileName,SchoolClass schoolClass) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))){
            writer.print(getInfoForWrite(schoolClass));
        }
    }

    String getInfoForWrite(SchoolClass schoolClass){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yy");
        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        builder.append("Třída: " + schoolClass.getName() + " - třídní učitel: "
                + schoolClass.getTeacher().getName() + " "
                + schoolClass.getTeacher().getSurname().toUpperCase()
                + "\n\n_________________________  žáci mladší 12 let:\n\n");

        int counter1 = 1;
        int counter2 = 1;
        for (Student student:schoolClass.studentList) {
            if (getAge(student.getBirthdate())<12) {
                builder.append(counter1 + ". " + student.getName() + " " + student.getSurname().toUpperCase() +
                        ", " + formatter.format(student.getBirthdate()) + "  (věk " + getAge(student.getBirthdate())
                        + " let) --- ID " + myFormat.format(student.getStudentNumber()) + "\n");
                counter1++;
            } else {
                builder2.append(counter2 + ". " + student.getName() + " " + student.getSurname().toUpperCase() +
                        ", " + formatter.format(student.getBirthdate()) + "  (věk " + getAge(student.getBirthdate())
                        + " let) --- ID " + myFormat.format(student.getStudentNumber()) + "\n");
                counter2++;
            }
        }
        builder.append("\n_________________________  žáci 12 letí a starší:\n\n");
        builder.append(builder2);
        int counter = counter1 + counter2;
        builder.append("-------------------------------------------------------\n"
                + schoolClass.getName() + " - celkový počet žáků: " + counter + "\n");
        return builder.toString();
    }

    private int getAge(LocalDate birthDate){
        int age = Period.between(birthDate,LocalDate.now()).getYears();
        return age;
    }
}
