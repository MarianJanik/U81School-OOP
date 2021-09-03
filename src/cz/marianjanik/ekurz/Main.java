package cz.marianjanik.ekurz;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        final String FILENAME1 = "4C1.txt";
        final String FILENAME2 = "4C2.txt";
        final String FILENAME3 = "4C3.txt";

        //region 1. fáze - konstruktory a OOP

        Teacher teacher1 = new Teacher("Marek","Hilary");
	    Teacher teacher2 = new Teacher("Jan","Novák");
	    Teacher teacher3 = new Teacher("Jaroslav","Bush");

	    Student student1 =new Student("Petr", "Svoboda", LocalDate.parse("2011-03-06"),1);
        Student student2 =new Student("Milan", "Resl", LocalDate.parse("2010-03-16"),123);
	    Student student3 =new Student("Jindřich", "Nový", LocalDate.parse("2012-03-30"),345);
	    Student student4 =new Student("Miroslav", "Wolf", LocalDate.parse("2009-04-06"),4);
	    Student student5 =new Student("Zlatá", "Bing", LocalDate.parse("2008-04-06"),5);
	    Student student6 =new Student("Klára", "Svobodová", LocalDate.parse("2009-04-06"),5);
	    Student student7 =new Student("Nela", "Nová", LocalDate.parse("2008-04-06"),5);

        System.out.println("\n\n---------------------- použití rodičovského getFullName (učitel, rodič):\n");
        System.out.println(teacher1.getFullName());
        System.out.println(student1.getFullName());
        System.out.println(student1.getAllStudentInfo());

        System.out.println("\n\n---------------------- použití dalších rodičovských setterů a getterů u studenta (potomka):\n");
        student4.setSurname("Paret");
        System.out.println(student4.getSurname());
        System.out.println(student4.getAllStudentInfo());
        student4.setName("Petr");
        System.out.println(student4.getFullName());

        //endregion 1.fáze

        //region 2.fáze - výpisy a zápisy
        SchoolClass schoolClass1 = new SchoolClass("4.C",4, teacher2);
        schoolClass1.setStudent(student1);
        schoolClass1.setStudent(student2);
        schoolClass1.setStudent(student3);
        schoolClass1.setStudent(student4);
        schoolClass1.setStudent(student5);
        schoolClass1.setStudent(student6);
        schoolClass1.setStudent(student7);

        System.out.println("\n\n------------------------------------------ výpis ad 1. (a zápis do souboru " + FILENAME1 + "),\n");
        WriteTo1 writer1 = new WriteTo1();
        writer1.writeToConsole(schoolClass1);
        try {
            writer1.writeToFile(FILENAME1,schoolClass1);
        } catch (FileNotFoundException e) {
            System.err.println("Soubor nebylo možné uložit.");
        }

        System.out.println("\n\n------------------------------------------ výpis ad 2. (a zápis do souboru " + FILENAME2 + "),\n");
        WriteTo2 writer2 = new WriteTo2();
        writer2.writeToConsole(schoolClass1);
        try {
            writer2.writeToFile(FILENAME2,schoolClass1);
        } catch (FileNotFoundException e) {
            System.err.println("Soubor nebylo možné uložit.");
        }


        System.out.println("\n\n------------------------------------------ výpis ad 3. - určený vzor na zápis: \n");
        WriteTo3 writer3 = new WriteTo3();
        writer3.writeToConsole(schoolClass1);

        System.out.println("\n\n------------------------------------------ ad 3. - řazení - úprava - @Overide compareTo - zápis do " + FILENAME3 + ".\n");
        Collections.sort(schoolClass1.studentList);
        writer3.writeToConsole(schoolClass1);

        try {
            writer3.writeToFile(FILENAME3,schoolClass1);
        } catch (FileNotFoundException e) {
            System.err.println("Soubor nebylo možné uložit.");
        }
        //endregion 2.fáze
    }
}
