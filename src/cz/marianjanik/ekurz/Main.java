package cz.marianjanik.ekurz;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        //region 1. fáze

        // test konstruktorů

        Teacher teacher1 = new Teacher("Marek","Hilary");
	    Teacher teacher2 = new Teacher("Jan","Novák");
	    Teacher teacher3 = new Teacher("Jaroslav","Bush");

	    Student student1 =new Student("Petr", "Svoboda", LocalDate.parse("2011-03-06"),001);
        Student student2 =new Student("Milan", "Říha", LocalDate.parse("2010-03-16"),123);
	    Student student3 =new Student("Jindřich", "Nový", LocalDate.parse("2012-03-30"),345);
	    Student student4 =new Student("Miroslav", "Wolf", LocalDate.parse("2000-04-06"),4);
	    Student student5 =new Student("Zlatá", "Bing", LocalDate.parse("2000-04-06"),5);

	    // výpis getFullName - pouze v rodiči, student může použít; konstruktory - otázky
        System.out.println("----------------------\n\n" + teacher1.getFullName());
        System.out.println(student1.getAllStudentInfo());
        System.out.println(student1.getFullName());

        student4.setSurname("Paret");
        System.out.println("----------------------\n\n" + student4.getSurname());
        System.out.println(student4.getAllStudentInfo());
        student4.setName("Petr");
        System.out.println("---------- " + student4.getFullName());

        //endregion 1.fáze
        //-------------------------------------------------------------
        //region 2.fáze
        SchoolClass schoolClass1 = new SchoolClass("4.C",4, teacher2);
        schoolClass1.setStudent(student1);
        schoolClass1.setStudent(student2);
        schoolClass1.setStudent(student3);
        SchoolClass schoolClass2 = new SchoolClass("4.B",4, teacher3);
        schoolClass2.setStudent(student4);
        schoolClass2.setStudent(student5);





        //endregion

    }
}
