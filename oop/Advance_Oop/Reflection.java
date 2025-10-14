package oop.Advance_Oop;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class obj = Class.forName("oop.Advance_Oop.Student");

        //class details
        System.out.println("class Name : " + obj.getName());
        System.out.println("class Name : " + obj.getSimpleName());

        //Method
        Method[] meth = obj.getDeclaredMethods();
        for(Method m : meth){
            System.out.println("Method Name : " + m.getName());
            System.out.println("Method type : " + m.getReturnType());
            System.out.println("modifier Name : " +  m.getModifiers());
        }

        Field[] fields = obj.getDeclaredFields();
        Student student = (Student) obj.newInstance();
        for(Field f : fields){
            System.out.println("field Name : " + f.getName());
            f.setAccessible(true);

            Object fieldValue = f.get(student);
            System.out.println("field Value: " + fieldValue);
            System.out.println("field type : " + f.getType());
            int mod = f.getModifiers();
            String modifierName = Modifier.toString(mod);
            System.out.println("Modifier : " + modifierName);
        }

        //constructor

        Constructor[] constructors = obj.getDeclaredConstructors();
        for(Constructor c : constructors){
            System.out.println("constructor name" + c.getName());
            Class[] paramTypes = c.getParameterTypes();
            System.out.println("Parameter Types: " + Arrays.toString(paramTypes));
        }
    }



}

class Student {
    private String name = "jeyakumar";
    int age = 21;
    public  String clg = "Nscet";
    Student(){
        name = "jeyakumar";
    }
    Student(String name,int age,String clg){
        this.name = name;
        this.age = age;
        this.clg = clg;
    }
    void displayDetails(){
        System.out.println("Name : " + name);
        System.out.println("age : " + age);
        System.out.println("clg : " + clg);
    }
    int getAge(){
        return age;
    }
    String getName(){
        return name;
    }
}