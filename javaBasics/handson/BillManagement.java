package javaBasics.handson;
import java.util.*;
public class BillManagement {
    public static void main (String[] args){
                Scanner ip = new Scanner(System.in);
                String choice = "yes";

                while (choice.equalsIgnoreCase("yes")) {
                    System.out.println("\n Billing system ");

                    System.out.println("Enter number of items: ");
                    int count = ip.nextInt();
                    double[] prices = new double[count];
                    double total = 0;

                    for (int i = 0; i < count; i++) {
                        System.out.print("Item " + (i + 1) + ": price");
                        prices[i] = ip.nextDouble();
                        total += prices[i];
                    }
                    System.out.println("Select category:");
                    System.out.println("1. Grocery");
                    System.out.println("2. Electronics");
                    System.out.println("3. Clothing");
                    System.out.println("4. Stationery");
                    System.out.print("Enter category code: ");
                    int code = ip.nextInt();

                    double discountPercent = 0;

                    switch (code) {
                        case 1:
                            discountPercent = 5;
                            break;
                        case 2:
                            discountPercent = 10;
                            break;
                        case 3:
                            discountPercent = 15;
                            break;
                        case 4:
                            discountPercent = 8;
                            break;
                        default:
                            System.out.println("Invalid category! No discount applied.");
                            continue; // skip rest of loop and restart
                    }

                    double discount = total * (discountPercent / 100);
                    double finalAmount = total - discount;

                    System.out.println("\n--- BILL SUMMARY ---");
                    System.out.println("Total before discount: " + total);
                    System.out.printf("Discount (%.0f%%): %.2f\n", discountPercent, discount);

                    System.out.println("Final amount to pay: " + finalAmount);

                    System.out.print("\nDo you want to continue shopping? (yes/no): ");
                    choice = ip.next().toLowerCase();

                    if (choice.equals("no")) {
                        System.out.println("Thank you for shopping with us!");
                        break; // exit loop completely
                    }
                }
                ip.close();
            }
        }



