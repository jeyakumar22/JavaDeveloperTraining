package oop.pillars;

public class Interfaces {
    public static void main(String[] args) {
        Bulb tubeLight = new Bulb("tube light");
            System.out.println(tubeLight.name);
            tubeLight.setBrightness(1000);
            tubeLight.setColor();
            tubeLight.turnOn();
            tubeLight.setMaxBrightness();

        Fan seiling = new Fan();
            seiling.turnOn();
            seiling.emergencyOff();

    }
}

interface Swiitchable{
   void turnOn();
   void turnOff();

   default void emergencyOff(){
       log();
       turnOff();
   }
   default void scheduledOff(){
       log();
       turnOff();
   }
private static void log(){
    System.out.println("Notification : Automatically turned off ");
}
}
interface Brightness {
    int LEVEL = 100;

    void setBrightness(int n);

    default void setMaxBrightness() {
        setBrightness(LEVEL);
        System.out.println("brightness set to maximum: " + LEVEL);
    }
    static boolean isValidBrightness(int n) {
        return n >= 0 && n <= LEVEL;
    }
}

interface ColorChangable{

    void  setColor();

    static boolean isValidColor(String clr){
        if(clr.equals("white") || clr.equals("blue") || clr.equals("yellow")){
            return true;
        }
        return false;
    }

}


class Bulb implements Swiitchable,Brightness,ColorChangable {
    String name;
    Bulb(String name){
        this.name= name;
    }

    public void setBrightness(int n) {
        if(Brightness.isValidBrightness(n)){
            System.out.println("brightness set successfully");
        }
        else{
            System.out.println("set valid brightness");
        }
    }

    public void setColor() {
        if(ColorChangable.isValidColor("white")){
            System.out.println("bulb color set");
        }
        else{
            System.out.println("not valid color");
        }
    }


    public void turnOn() {
        System.out.println("bulb turned on");
    }


    public void turnOff() {
        System.out.println("bulb turned off");
    }

}

class Fan implements Swiitchable{

    public void turnOn() {
        System.out.println("fan turned on");
    }

    public void turnOff() {
        System.out.println("fan turned off");
    }
}