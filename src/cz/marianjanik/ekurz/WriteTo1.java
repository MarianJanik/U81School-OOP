package cz.marianjanik.ekurz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;


public class WriteTo1 implements ReadWrite{

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

    private String getInfoForWrite(SchoolClass schoolClass){
        StringBuilder builder = new StringBuilder();
        builder.append("##################################\nTřída: " + schoolClass.getName()
                + " (ročník: " + schoolClass.getGrade() + ")\nTřídní učitel: " + schoolClass.getTeacher().getSurname()
                + ", " + schoolClass.getTeacher().getName() + "\nPočet studentů: " + schoolClass.size()
                + "\n\n##################################\n");
        int counter = 1;
        for (Student student:schoolClass.studentList) {
            builder.append("# " + counter + " # ID" + myFormat.format(student.getStudentNumber()) + " - " + student.getFullName()
                    + " (" + student.getBirthdate().getYear() + ")\n");
            counter++;
        }
        return builder.toString();
    }
}
