public abstract class UncountableItem extends Items implements UncountableItemInterface{
    private double mass;


    public UncountableItem(String itemCode, double mass, double volume, String serialNumber) {
        super(itemCode, volume, serialNumber);
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public String getItemType() {
        return "UncountableItem";
    }

}
