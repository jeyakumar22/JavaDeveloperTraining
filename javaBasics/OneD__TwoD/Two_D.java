package javaBasics.OneD__TwoD;

import java.util.Scanner;

public class Two_D {
   static Scanner ip = new Scanner(System.in);
        public static void main(String[] args) {
            while (true) {
                System.out.println("\n=== MATRIX OPERATIONS MENU ===");
                System.out.println("1. Rotate Matrix");
                System.out.println("2. Matrix Traversal");
                System.out.println("3. Exit");
                System.out.print("Choose an operation (1-3): ");

                int choice = ip.nextInt();

                switch (choice) {
                    case 1:
                        rotateMatrix();
                        break;
                    case 2:
                        matrixTraversal();
                        break;
                    case 3:
                        System.out.println("Thank you for using Matrix Operations!");
                        ip.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter 1-6.");
                }
            }
        }
       public static void matrixTraversal(){
            System.out.println("enter row  size of the matrix");
            int row = ip.nextInt();
            System.out.println("enter col size of the matrix");
            int col = ip.nextInt();
            int[][] matrix = new int[row][col];
            for (int i=0;i<row;i++){
                System.out.println("enter value of row" +(i+1));
                for(int j=0;j<col;j++){
                    System.out.println("enter valuse of column" +(j+1));
                    matrix[i][j] = ip.nextInt();
                }
            }
            for (int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

       public static void rotateMatrix(){
            System.out.println("enter row  size of the matrix");
            int row = ip.nextInt();
            System.out.println("enter col size of the matrix");
            int col = ip.nextInt();
            int[][] matrix = new int[row][col];
            for (int i=0;i<row;i++){
                System.out.println("enter value of row" +(i+1));
                for(int j=0;j<col;j++){
                    System.out.println("enter valuse of column" +(j+1));
                    matrix[i][j] = ip.nextInt();
                }
            }
            int[][] rotatedMatrix = new int[row][col];

            for (int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    rotatedMatrix[i][j] = matrix[row-j-1][i];
                }
            }

            for (int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    System.out.print(rotatedMatrix[i][j]);
                }
                System.out.println();
            }

        }


}
