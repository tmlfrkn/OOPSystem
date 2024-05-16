public abstract class Items implements ItemInterface{
    private String itemCode;
    private double volume;
    private String SerialNumber;
    private boolean isLoaded = false;

    public Items(String itemCode, double volume,String serialNumber) {
        this.itemCode = itemCode;
        this.volume = volume;
        this.SerialNumber = serialNumber;
    }

    public void setLoadItems(){this.isLoaded = true;}

    public boolean getIsLoaded(){return  isLoaded;}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }
}
