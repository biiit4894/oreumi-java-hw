package inheritinstance;

public interface Promotion {
    default int getDiscountAmount() {
        return 0;
    }
}
