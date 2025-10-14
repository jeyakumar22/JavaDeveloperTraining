package javaBasics.fundamentals;

import java.util.*;
public class Random {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println(Math.random());
        int[] arr = new int[10];
        for (int i=0;i<3;i++){
            System.out.println("Enter the "+ i +" number" );
            arr[i] = input.nextInt() * 2;
        }
        System.out.println(Arrays.toString(arr));

    }
}