package inheritinstance;

public class Product implements Promotion {
    String name;
    int price;
    int weight;

    int deliveryPrice;

    public Product(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}
