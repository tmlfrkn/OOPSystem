public interface ItemInterface{
    public String getItemCode();
    public double getVolume();
    public String getSerialNumber();
    public double calculatePrice();
    public double calculateCost();//Uncountable countable a ayrı ayrı implement et
    public boolean getIsLoaded();
    public void setLoadItems();
    public String getItemType();

}
