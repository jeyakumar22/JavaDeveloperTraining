package oop.Advance_Oop;

import java.util.Scanner;

public class AnonymousClass {
    static Scanner ip = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter num");
        int a = ip.nextInt();
        System.out.println("enter num");
        int b = ip.nextInt();
        Calculator cal = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }

            @Override
            public int sub(int a, int b) {
                return a-b;
            }

            @Override
            public int divide(int a, int b) {
                if(b==0) {
                    System.out.println("error divide by zero");
                    return 0;
                }
                return a/b;
            }

            @Override
            public int multi(int a, int b) {
                return a*b;
            }
        };
        System.out.println("add");
        System.out.println(cal.add(a,b));
        System.out.println("subtraction");
        System.out.println(cal.sub(a,b));
        System.out.println("divide");
        System.out.println(cal.divide(a,b));
        System.out.println("multiply");
        System.out.println(cal.multi(a,b));


        // lambda fn only one abstract meth
        newCalculator add = (x,y) ->  a+b;
        newCalculator sub = (x,y) ->  a-b;
        newCalculator multi = (x,y) ->  a*b;

        System.out.println("add");
        System.out.println(add.calc(a,b));
        System.out.println("subtraction");
        System.out.println(sub.calc(a,b));
        System.out.println("multiply");
        System.out.println(multi.calc(a,b));

    }
}
interface  Calculator{
    int add (int a,int b);
    int sub (int a,int b);
    int divide (int a,int b);
    int multi (int a,int b);
}

interface newCalculator{
    int calc(int a,int b);
}

