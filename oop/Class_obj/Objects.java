package oop.Class_obj;

//default constructor initialise a value so we got just o,null
public class Objects {

        int age;
        String name ;
        public static void main(String[] args){
            Objects obj= new Objects();
            //assign manually
            obj.age =10;
            obj.name ="jeyakumar";
            System.out.println(obj.age);
            System.out.println(obj.name);

            //assign using consructor it run while crating obj;
            Constructor con=new Constructor();
            System.out.println(con.age);
            System.out.println(con.name);

            //passing parameter to initialise
            Constructor con1=new Constructor(100,"C"); //perform constructor overloading
            System.out.println("\n"+con1.age);
            System.out.println(con1.name);

            //Method overloading
            MethodOverloading mo = new MethodOverloading();
            mo.add(10,11,12);
            mo.add(2,3);
            mo.add(88.2,11.8);
        }
}
class Constructor{
    int age;
    String name;
    Constructor(){
        System.out.println("\nobj created and value initialised\n");
        this.age=20;
        this.name="Java";
    }
    Constructor(int age,String name){
        this.age=age;
        this.name=name;
    }
}

class MethodOverloading {
    void add(int a, int b) {
        System.out.println("\naddition of 2 param :" + (a+b));
    }
    void add(double a, double b) {
        System.out.println("addition of 2 (double) param :" + (a+b));
    }
    void add(int a, int b, int c) {
        System.out.println("addition of 3 param :" + (a+b+c));
    }
}