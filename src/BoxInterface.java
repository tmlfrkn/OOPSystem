public interface BoxInterface<T extends ItemInterface> {
    public String getBoxCode();
    public double getVolume();
    public String getBoxSerialNumber();
    public String getItemName();
    public double getProductPrice();
    public boolean isProper(T item);
    public boolean getIsLoaded();
    public void setLoaded();
    public boolean isFit(T item);
    public void addItem(T item);
    public String getType();
    public void addPricetoTotalPrice(double priceToBeAdded);
    public double getTotalprice();
}
