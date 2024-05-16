import java.util.ArrayList;

public class Container<T extends BoxInterface>{
    private String containerCode;
    private double volume;

    private String containerSerialNumber;
    private final int productCostPerLiter = 1;

    private final String itemName = "Container";

    private ArrayList<BoxInterface> boxList = new ArrayList<BoxInterface>();

    private double fullVolume = 0;

    private double productCost;
    private boolean isShipped = false;


    public Container(String containerCode, double volume, String containerSerialNumber) {
        this.containerCode = containerCode;
        this.volume = volume;
        this.containerSerialNumber = containerSerialNumber;
        this.productCost = calculateProductCost();
    }

    public void add(T box){
        boxList.add(box);
        fullVolume += box.getVolume();
    }

    public ArrayList<BoxInterface> getBoxList() {
        return boxList;
    }

    public double getFullVolume() {
        return fullVolume;
    }

    public boolean getIsShipped() {
        return isShipped;
    }
    public void setShipped(){
        this.isShipped = true;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public double getVolume() {
        return volume;
    }

    public String getContainerSerialNumber() {
        return containerSerialNumber;
    }

    public double calculateProductCost(){return getProductCostPerLiter() * getVolume();}

    private int getProductCostPerLiter() {return productCostPerLiter;}

    public String getItemName() {return itemName;}

    public double getProductCost() {return productCost;}

    public boolean isFit(T box){
        System.out.println("Box ın volume u : " + box.getVolume());
        System.out.println("Container ın volume u " + this.getVolume());
        System.out.println("Container ın total volume u" + this.fullVolume);
        return (box.getVolume() + this.fullVolume < this.getVolume());
    }

}
