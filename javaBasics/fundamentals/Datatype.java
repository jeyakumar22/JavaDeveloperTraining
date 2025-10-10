package javaBasics.fundamentals;

public class Datatype {
    public static  void main (String args[]){
        byte a =10;
        //byte b =200; 1 byte mem
        short b =1000; //2 byte
        int c =1000000000; //4 byte
        long d = 1000000000L; //8 byte
        float e = 100.00f;  // 4 byte
        double f = 1000.99d; // 8 byte
        char g =65;  //2 byte
        boolean h =true; //1 bit
        var i =true;  // dynamically java found the dtype
        System.out.println("char  "+ g);

        //type casting

        //1.Widening  (automatic)
        int age = 20;
        double age_ = age;

        // 2.manual
        double rs = 100.89d;
        int rs_ = (int)rs;
        System.out.println(age +" "+age_);
        System.out.println(rs +" "+rs_);

        String num ="10";
        int num_ = Integer.parseInt(num);
        System.out.println(num_);
    }
}
