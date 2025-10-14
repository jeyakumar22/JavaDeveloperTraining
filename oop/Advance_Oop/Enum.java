package oop.Advance_Oop;

public class Enum {
    public static void main(String[] args) {
        TrafficLight now = TrafficLight.RED;
        System.out.println(now);
        System.out.println("Duration : " + now.getDuration());
        System.out.println("Instruction : " + now.getAction());

        System.out.println( " traffic light learning ");
        TrafficLight[] lights = TrafficLight.values();
        for(TrafficLight tl : lights){
            System.out.println(tl.name() + " " + tl.ordinal());
            System.out.println("Duration : " + tl.getDuration());
            System.out.println("Instruction : " + tl.getAction());
        }
    }
}

interface TrafficBehavior {
    int getDuration();       // How long this light stays
    String getAction();      // What should drivers do
}

enum TrafficLight implements  TrafficBehavior{
    RED(30,"STOP - wait for green signal"),
    YELLOW(5,"Wait - be ready"),
    GREEN (25,"Go ");

    private int duration;
    private String instruction;

    TrafficLight(int duration,String instruction){
        this.duration =duration;
        this.instruction =instruction;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getAction() {
        return instruction;
    }

    public String toString() {
        return this.name() + " Light - " + instruction + " (" + duration + " seconds)";
    }
}

