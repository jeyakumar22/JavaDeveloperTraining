package oop.Methods_recursion;

public class Recursion {

    public static  void  main ( String[] args){
        System.out.println("Print reverse");
        print(10);//desc
        System.out.println("\n");
        System.out.println("Print forward");
        print1(10);//asc
    }
    static void print(int n){
        if (n==0){
            return ;
        }
        System.out.print(n+" " );
        print(n-1);
    }static void print1(int n){
        if (n==0){
            return ;
        }
        print1(n-1);
        System.out.print(n+" " );

    }
}
