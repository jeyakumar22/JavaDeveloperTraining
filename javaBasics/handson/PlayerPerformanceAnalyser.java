package javaBasics.handson;

import java.util.Arrays;
import java.util.Scanner;
public class PlayerPerformanceAnalyser {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String pref = "yes";
        while(pref.equals("yes")){

            System.out.println("enter player name : ");
            String name  = input.nextLine();
            System.out.println("enter no of match played : ");
            int count  = input.nextInt();

            int[] scores = new int[count];
            for (int i=0;i<count;i++){
                System.out.println("enter score of match : " +(i+1));
                scores[i] = input.nextInt();
            }
            //analys
            int total =0;
            int centuries=0,halfCenturies = 0,doubleCenturies=0;
            int highest=-1,lowest=Integer.MAX_VALUE;
            for(int i:scores){
                if(i>highest){
                    highest=i;
                }
                if(i<lowest){
                    lowest = i;
                }
                total+=i;
                if (i>=50 &&i<=99){
                    halfCenturies++;
                }
                else if(i>=100 && i<=199){
                    centuries++;
                }
                else if(i>=200){
                    doubleCenturies++;
                }
            }
            float avg =  (float) total/scores.length;

            System.out.println("\n--- PLAYER PERFORMANCE ---");
            System.out.println("Total Runs: " + total);
            System.out.println("Average Score: " + avg );
            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);
            System.out.println("Half-Centuries (50-99): " + halfCenturies);
            System.out.println("Centuries (100+): " + centuries);
            System.out.println("DoubleCenturies (200+): " + doubleCenturies);
            System.out.println("all Match scorse" + Arrays.toString(scores));
            System.out.println("----------------------");
            input.nextLine(); // to avoid empty space
            System.out.println("type Yes to do more player or press any to esc ");
            pref  = input.nextLine().toLowerCase();
        }
    }
}
