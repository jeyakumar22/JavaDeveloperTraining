package oop.Advance_Oop;

import java.util.ArrayList;


public class NestedClass {
    public static void main(String[] args) {
            Collage c1 = new Collage("NSCET",5865);
            Collage.Student s1 = c1.new Student("jeyakumar",12);
            s1.displayStd();

            //create static obj no need c1;
            Collage.Course sub = new Collage.Course("javaPrograming",123);
            sub.displayCourse();

            c1.addCourse("Spring",321);


            Collage.Course.displayAllCourses();


    }
}

class Collage{
    private static String university = "Anna University";
    private String clgName;
    private int clgId;

    Collage(String clgName , int clgId){
        this.clgName = clgName;
        this.clgId = clgId;
    }
    void display(){
        System.out.println("university " +university);
        System.out.println("Collage Name and Collage ID : " + clgName  +  " " + clgId);
    }

    void addCourse(String courseName , int courseId){
        Collage.Course sub2 = new Collage.Course(courseName,courseId);
        sub2.displayCourse();
    }

    class Student{
         String stdName;
         int rollNo;

        Student(String stdName , int rollNo){
            this.stdName = stdName;
            this.rollNo = rollNo;
        }
        void displayStd(){
            System.out.println("Student Name and rollNo : " + stdName  +  " " + rollNo);
            Collage.this.display();
        }

    }

    static class Course {
        String courseName;
        int courseCode;

        private static ArrayList<Course> allCourses = new ArrayList<>();
        Course(String courseName , int courseCode){
            this.courseName = courseName;
            this.courseCode = courseCode;
            allCourses.add(this);
        }

        void displayCourse(){
            System.out.println("Course Name and CourseCode : " + courseName +" " +courseCode );
        }

        static void displayAllCourses() {
            System.out.println("all course");
            for(Course course : allCourses) {
                course.displayCourse();
            }
        }
    }
}