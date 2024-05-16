public class Pasta extends UncountableItem {
    private final int productCostPerKg = 12;
    private final int productPricePerKg = 28;

    private final String itemName = "Pasta";


    private double productCost;
    private double productPrice;

    public Pasta(String itemCode, double mass, double volume, String serialNumber) {
        super(itemCode, mass, volume, serialNumber);
        this.productCost = calculateCost();
        this.productPrice = calculatePrice();

    }

    public int getProductCostPerKg() {
        return productCostPerKg;
    }

    public int getProductPricePerKg() {
        return productPricePerKg;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public double getProductCost() {
        return productCost;
    }

    @Override
    public String getItemName() {
        return this.itemName;
    }

    @Override
    public double calculatePrice() {
        return getProductPricePerKg() * getMass();
    }

    @Override
    public double calculateCost() {
        return getProductCostPerKg() * getMass();
    }

    public String toString() {
        return (getItemName() + "Volume : " + getVolume() + "Kg " + getMass() +" " + getProductCost() + " " + getProductPrice());
    }

}
