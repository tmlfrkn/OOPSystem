import java.util.ArrayList;

public class CountableBox<T extends ItemInterface> extends Box<T> implements ICountableBox<T> {
    private int numberOfItems;
    private final int productCostPerLiter = 2;
    private ArrayList<CountableItemInterface> countableItemList = new ArrayList<>();
    private double fullVolume = 0;

    private final String itemName = "Number box";

    private double productPrice;

    public CountableBox(String boxCode, double volume, String boxSerialNumber, int numberOfItems) {
        super(boxCode, volume, boxSerialNumber);
        this.numberOfItems = numberOfItems;
        this.productPrice = calculateProductPrice();

    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    private int getProductCostPerLiter() {
        return productCostPerLiter;
    }

    public double calculateProductPrice() {
        return getVolume() * productCostPerLiter;
    }

    public String getItemName() {
        return itemName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public void addItem(T item) {
        CountableItemInterface itemX = (CountableItem) item;
        fullVolume += item.getVolume();
        addPricetoTotalPrice(itemX.getProductPrice());
        countableItemList.add(itemX);

    }

    public ArrayList<CountableItemInterface> getCountableItemList() {
        return countableItemList;
    }

    public double getFullVolume() {
        return fullVolume;
    }

    @Override
    public boolean isProper(ItemInterface item) {
        return (item.getItemType().equals("CountableItem"));
    }

    public boolean isFit(ItemInterface item) {
        return (countableItemList.size() < numberOfItems) && (fullVolume + item.getVolume() < getVolume());
    }

    @Override
    public String getType() {
        return "CountableBox";
    }

    public String toString() {
        return (getItemName() + "Volume : " + getVolume() + "Kaç eleman var : " + getCountableItemList().size() + " "  + getProductPrice());
    }
}
