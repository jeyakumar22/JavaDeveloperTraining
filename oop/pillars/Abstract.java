package oop.pillars;

public class Abstract {
    public static void main(String[] args) {
        Product ht = new Electronics(1,"heater",2.2,1000);
        ht.info();
        ht.applyDiscount();
        System.out.println(ht.getWarrenty());
        ht.shipping();
        ht.doorDelivery();

        Dress d = new Dress(2,"saree",180.7,200);
        d.info();
        d.applyDiscount();
        System.out.println(d.getWarrenty());        d.shipping();
    }
}

abstract  class Product{
    int id;
    String name;
    double weight;
    double price;

    Product(int id,String name,double weight,double price){
        this.id =id;
        this.name =name;
        this.weight =weight;
        this.price =price;
    }

    void info(){
        System.out.println("product id: "+id +" Name: "+name + " Weight: "+weight +" price: "+price );
    }
    void doorDelivery(){
        System.out.println("Product will come to your home soon");
    }
    abstract void applyDiscount();
    abstract int getWarrenty();
    abstract void shipping();
}


class Electronics extends  Product {
    Electronics(int id, String name, double weight, double price) {
        super(id, name, weight, price);
    }

    void applyDiscount() {
        System.out.println("Electronics item have 10% discount");
        System.out.println("Discount applied" + (price - (price * 0.1)));
    }

    int getWarrenty() {
        System.out.println("Electronics item have 2 year warrenty");
        System.out.println("warrenty applied");
        return 24;
    }

    void shipping() {
        System.out.println("shipping cost applied based on weight");
        System.out.println("shipping amount" + (weight * 10));

    }

}
    class Dress extends  Product {
        Dress(int id, String name, double weight, double price) {
            super(id, name, weight, price);
        }

        void applyDiscount() {
            System.out.println("cloths  have 15% discount");
            System.out.println("Discount applied" + (price - (price * 0.15)));

        }

        int getWarrenty() {
            System.out.println("cloth item have 3 month warrenty");
            System.out.println("warrenty applied" );
            return 3;
        }

        void shipping() {
            System.out.println("shipping cost applied based on product");
            if(name.equals("saree")){
                System.out.println("shipping amount" + 10 + "rs");
            }
            else{
                System.out.println("shipping amount" + 5 + "rs");
            }
        }

    }  //concrete
