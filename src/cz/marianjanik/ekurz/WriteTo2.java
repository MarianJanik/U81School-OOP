package cz.marianjanik.ekurz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class WriteTo2 implements ReadWrite{

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
        builder.append(schoolClass.getName() + ", " + schoolClass.getTeacher().getFullName() + "\n");
        for (Student student:schoolClass.studentList) {
            builder.append("ID" + myFormat.format(student.getStudentNumber()) + ", " + student.getFullName() + "\n");
        }
        return builder.toString();
    }
}
