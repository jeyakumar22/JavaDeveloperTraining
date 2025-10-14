package oop.Advance_Oop;

public class SingletonClass {
    public static void main(String[] args) {
        //cant crate as below obj is private insise of class
        //Dbconnection d1 = new Dbconnection();

        Dbconnection db = Dbconnection.getInstance();
        System.out.println(db);
        Dbconnection db1 = Dbconnection.getInstance();
        System.out.println(db1);

        db.getConnection();
        db1.getConnection();
    }


}

class Dbconnection {
    private static Dbconnection dbObj;

    private Dbconnection() {
        System.out.println("constructor");
    }
    public void getConnection(){
        System.out.println("connected to db");
    }
    public static Dbconnection getInstance() {
        if(dbObj == null){
            dbObj = new Dbconnection();
        }
        return dbObj;
    }

}