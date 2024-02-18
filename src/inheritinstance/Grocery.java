package inheritinstance;

public class Grocery extends Product {
    private int discount;

    Grocery(String name, int price, int weight) {
        super(name, price, weight);
    }

    @Override
    public int getDiscountAmount() {
        return 2000;
    }

}
