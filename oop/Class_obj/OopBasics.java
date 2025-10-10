package oop.Class_obj;

//static keywords
//static meth can't access the not static thing
//but a non static meth can access every thing
public class OopBasics {
    static int clgCode = 5865;
    static String clgName ="NSCET";

    int studetId ;
    String studentName ;

    //static block
    static int a=10;
    static{
        System.out.println("\nclass loaded " + a);
    }
    //

    OopBasics(int id ,String name){
        this.studetId = id;
        this.studentName = name;
    }
    void display() {
        System.out.println(clgCode + " " + clgName);  // Static variables
        System.out.println(studentName + " " + studetId); // Instance variables
    }

    //non static access instance variables
    void displayStdInfo() {
        System.out.println(this.studentName + " " + this.studetId);
    }

    //  static method, pass object as parameter
    static void displayStdInfoStatic(OopBasics student) {
        System.out.println(student.studentName + " " + student.studetId);
    }

    // static method - only accesses static data
    static void displayCollegeInfo() {
        System.out.println("College: " + clgName + " (" + clgCode + ")");
        // Cannot access studentName or studetId here - they're instance variables
    }
    public static void main(String[] args){
        System.out.println(clgCode +" " + clgName); //access without using obj
        OopBasics std = new OopBasics(12,"jk");
        System.out.println(std.studentName +" "+std.studetId);

    }

}

