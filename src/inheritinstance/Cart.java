package inheritinstance;

public class Cart {
    private Product[] products;

    public Cart(Product[] products) {
        this.products = products;
    }


    public int calculateDeliveryCharge() {
        int totalWeight = getTotalWeight();
        int totalPrice = getTotalPrice();

        int charge = getFinalCharge(totalPrice, getBaseCharge(totalWeight));
        return charge;
    }

    private int getTotalWeight() {
        int weight = 0;
        for(Product product : products) {
            weight += product.getWeight();
        }
        return weight;
    }

    private int getTotalPrice() {
        int price = 0;
        for(Product product : products) {
            price += product.getPrice();
        }
        return price;
    }

    private int getBaseCharge(int weight) {
        int charge;
        if(weight < 3) {
            charge = 1000;
        } else if(weight < 10) {
            charge = 5000;
        } else {
            charge = 10000;
        }
        return charge;
    }

    private int getFinalCharge(int price, int charge) {
        if(price >= 30000 && price < 100000) {
            charge -= 1000;
        } else if(price >= 100000) {
            charge = 0;
        }
        return charge;
    }



}
