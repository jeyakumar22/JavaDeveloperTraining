package oop.pillars;

import java.util.Scanner;

public class Encapsulation {
    public static void main(String[] args) {
        Scanner ip =new Scanner(System.in);
        Bank sbi = new Bank(1234,100,"jk");

        while(true){
            System.out.println("\n BANKING MENU:");
            System.out.println("1. set new name");
            System.out.println("2. Withdraw Money");
            System.out.println("3. deposit Money");
            System.out.println("4. see details");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = ip.nextInt();

            switch (choice){
                case 1:
                    System.out.println( "to change name enter name");
                    ip.nextLine(); // clear buffer
                    String newName = ip.nextLine();
                    sbi.setName(newName);

                    break;
                case 2:
                    System.out.println("to withdraw enter money");
                    int n = ip.nextInt();
                    sbi.withdraw(n);
                    System.out.println("current balance"+sbi.getBalance());
                    break;

                case 3:
                    System.out.print("Enter deposit amount: ");
                    int depositAmt = ip.nextInt();
                    sbi.deposit(depositAmt);
                    System.out.println("current balance"+sbi.getBalance());
                    break;

                case 4:
                    System.out.print("see your bank details\n");
                    System.out.println("Name " +sbi.getName());
                    System.out.println("Account Number " +sbi.getAccNum());
                    System.out.println("Balance " +sbi.getBalance());
                    break;
                case 5:
                    System.out.println(" Thank you for banking with us");
                    System.out.println("Final Details:");
                    System.out.println("Name " +sbi.getName());
                    System.out.println("Account Number " +sbi.getAccNum());
                    System.out.println("Balance " +sbi.getBalance());
                    ip.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

 class Bank{
   private final int accNum;
   private double balance;
   private String name ;


   public Bank(int accNum,double balance,String name){
        this.accNum=accNum;
        this.balance=balance;
        this.name=name;
   }

     public double getBalance() {
         return  balance;
     }

     public String getName() {
         return name;
     }

     public int getAccNum() {
         return accNum;
     }

     /*public void setAccNum(int accNum) {
       if(accNum>0) this.accNum = accNum;
       else  System.out.println("not valid");
     }*/

     public void setName(String name) {
       if(name != null && !name.isEmpty()){
           this.name = name;
           System.out.println(" Name updated!");
       }
       else {
           System.out.println("not valid");
       }
     }
     public void withdraw(int n){
         if (n<balance){
             System.out.println("successfully withdraw " + n);
             balance-=n;
         }
         else System.out.println("not enough balance");
     }public void deposit(int n){
         if (n>0){
             balance+=n;
             System.out.println("successfully deposit " + n);
         }
         else System.out.println("not valid money");
     }
 }
