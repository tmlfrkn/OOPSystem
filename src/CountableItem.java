public abstract class CountableItem extends Items implements CountableItemInterface{
    public CountableItem(String itemCode, double volume, String serialNumber) {
        super(itemCode, volume,serialNumber);
    }


    @Override
    public String getItemType() {
        return "CountableItem";
    }
}
