package cz.marianjanik.ekurz;

import java.util.ArrayList;

public class SchoolClass {
    private String name;
    private int grade;
    private Teacher teacher;

    ArrayList<Student> studentList = new ArrayList<>();

    public SchoolClass(String name, int grade, Teacher teacher) {
        this.name = name;
        this.grade = grade;
        this.teacher = teacher;
    }

    public SchoolClass(String name, int grade) {
        this(name,grade,null);
    }

    public void setStudent(Student newStudent){
        studentList.add(newStudent);
    }

    public void removeStudent(Student removeStudent){
        studentList.remove(removeStudent);
    }

    public void removeStudent(int index){
        studentList.remove(index);
    }

    public int size(){
        return studentList.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
