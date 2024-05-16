import java.util.ArrayList;

public class UncountableBox<T extends ItemInterface> extends Box<T> implements IUncountableBox<T>{
    private final int productCostPerKg = 3;

    private final String itemName = "Mass box";
    private double productPrice;
    private double mass;
    private double fullMass = 0;
    private double fullVolume = 0;
    private ArrayList<T> itemList = new ArrayList<>();


    public UncountableBox(String boxCode, double volume, String boxSerialNumber, double mass) {
        super(boxCode, volume, boxSerialNumber);
        this.productPrice = calculateProductPrice();
        this.mass = mass;
    }
    public double getMass() {
        return this.mass;
    }


    public void addItem(T item){
        UncountableItemInterface itemX = (UncountableItem) item;
        itemList.add(item);
        addPricetoTotalPrice(itemX.getProductPrice());
        fullMass += itemX.getMass();
        fullVolume += itemX.getVolume();
    }

    private int getProductCostPerKg() {
        return productCostPerKg;
    }
    public double calculateProductPrice(){
        return  getVolume() * getProductCostPerKg();
    }

    public String getItemName() {
        return itemName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public boolean isProper(T item) {
        return (item.getItemType().equals("UncountableItem"));
    }

    public boolean isFit(ItemInterface item){
        UncountableItemInterface itemX = (UncountableItem) item;
        if ((this.fullMass + itemX.getMass() < getMass()) && (fullVolume + item.getVolume() < getVolume())) {
            return true;
        }
        return false;
    }

    public double getFullMass() {
        return fullMass;
    }

    public double getFullVolume() {
        return fullVolume;
    }

    public ArrayList<T> getItemList() {
        return itemList;
    }

    @Override
    public String getType() {
        return "UncountableBox";
    }

    public String toString() {
        return (getItemName() + "Volume : " + getVolume() + "Kg :" + getMass()  +"Kaç eleman var : " + getItemList().size() + " "  + getProductPrice());
    }
}
