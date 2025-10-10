package javaBasics.OneD__TwoD;
import java.util.Arrays;
import java.util.Scanner;

public class Array {
    static Scanner ip = new Scanner(System.in);
    public static  void main(String[] args){
        //move zeros to end
        System.out.println("enter your choice");
        System.out.println("1.moveZeroToEnd");
        System.out.println("2.rotateArray");
        int choice = ip.nextInt();
        moveZeroToEnd();
        rotateArray();

    }
    public static void moveZeroToEnd(){
        int[] arr = {1,0,2,0,3,0,4,0,5,0,6,0,7};
        int i=0;
        for (int j=0;j<arr.length;j++){
            if (arr[j]!=0){
                int temp = arr[i];
                arr[i] =arr[j];
                arr[j] = temp;

                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }public static void rotateArray(){
        System.out.println("how many times do u want to rotate right");
        int times = ip.nextInt();
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println("before rotate");
        System.out.println(Arrays.toString(arr));
        times = times % arr.length;
        rotate(arr,0,times-1);
        rotate(arr,times,arr.length-1);
        rotate(arr,0,arr.length-1);
        System.out.println("after rotate");
        System.out.println(Arrays.toString(arr));
        System.out.println(times % arr.length);    }

    public static void rotate(int[] arr, int st, int end) {
        while(st<end){
            int temp =arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }
}
