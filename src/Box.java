import java.util.ArrayList;

public abstract class Box<T extends ItemInterface> implements BoxInterface<T>{
    private String boxCode;
    private double volume;
    private String boxSerialNumber;
    private boolean isLoaded = false;
    private double totalprice = 0;


    public Box(String boxCode, double volume, String boxSerialNumber) {
        this.boxCode = boxCode;
        this.volume = volume;
        this.boxSerialNumber = boxSerialNumber;
    }

    public void addPricetoTotalPrice(double priceToBeAdded){
        this.totalprice+= priceToBeAdded;
    }

    public double getTotalprice(){
        return totalprice;
    }


    public String getBoxCode() {
        return boxCode;
    }

    public void setLoaded(){this.isLoaded = true;}

    public boolean getIsLoaded(){return isLoaded;}

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getBoxSerialNumber() {
        return boxSerialNumber;
    }

    public void setBoxSerialNumber(String boxSerialNumber) {
        this.boxSerialNumber = boxSerialNumber;
    }

}
