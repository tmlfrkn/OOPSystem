public class BoxOfMilk extends CountableItem{
    private final String itemName = "Box of Milk";
    private final int productCostPerLiter = 5;
    private final int productPricePerLiter = 11;

    private double productCost;
    private double productPrice;

    public BoxOfMilk(String itemCode, double volume,String serialNumber) {
        super(itemCode, volume,serialNumber);
        this.productCost = calculateCost();
        this.productPrice = calculatePrice();
    }

    public int getProductCostPerLiter() {
        return productCostPerLiter;
    }

    public int getProductPricePerLiter() {
        return productPricePerLiter;
    }



    public double calculatePrice() {
        return getProductPricePerLiter() * getVolume();
    }

    public double calculateCost() {
        return getProductCostPerLiter() * getVolume();
    }
//productPrizeları üst class a yaz
    public double getProductCost() {
        return productCost;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    public double getProductPrice(){
        return productPrice;
    }

    @Override
    public String toString() {
        return (getItemName() + " " + getVolume() + " " + getProductCost() + " " + getProductPrice());
    }
}
