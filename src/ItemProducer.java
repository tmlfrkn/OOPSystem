import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ItemProducer<T extends ItemInterface> {
    private ArrayList<Container> containerArrayList = new ArrayList<>();
    private ArrayList<Box> boxArrayList = new ArrayList<>();
    private ArrayList<ItemInterface> itemsArrayList = new ArrayList<>();
    private ArrayList<String> serialNumberForProducts = new ArrayList<>();
    private double revenue;

    public ItemProducer() throws FileNotFoundException {
        this.revenue = 0;
    }

    public void initializeProducts(ArrayList<String> line) throws FileNotFoundException,ExistingSerialNumberException {
            String code = line.get(1);
            try {
                if(!isSerialNumberAlreadyExist(line.get(line.size() -1))){
                    switch (code) {
                        case "M1":
                            BoxOfMilk boxOfMilk = new BoxOfMilk(line.get(1), Double.parseDouble(line.get(2)), line.get(3));
                            revenue -= boxOfMilk.getProductCost();
                            printCountableItems(boxOfMilk);
                            this.itemsArrayList.add(boxOfMilk);
                            this.serialNumberForProducts.add(line.get(3));
                            break;

                        case "W1":
                            BoxOfWater boxOfWater = new BoxOfWater(line.get(1), Double.parseDouble(line.get(2)), line.get(3));
                            revenue -= boxOfWater.getProductCost();
                            printCountableItems(boxOfWater);
                            this.itemsArrayList.add(boxOfWater);
                            this.serialNumberForProducts.add(line.get(3));
                            break;

                        case "O1":

                            BoxOfOil boxOfOil = new BoxOfOil(line.get(1), Double.parseDouble(line.get(2)), line.get(3));
                            revenue -= boxOfOil.getProductCost();
                            printCountableItems(boxOfOil);
                            this.itemsArrayList.add(boxOfOil);
                            this.serialNumberForProducts.add(line.get(3));
                            break;

                        case "S1":

                            Sugar sugar = new Sugar(line.get(1), Double.parseDouble(line.get(2)),
                                    Double.parseDouble(line.get(3)), line.get(4));
                            revenue -= sugar.getProductCost();
                            printUncountableItems(sugar);
                            this.itemsArrayList.add(sugar);
                            this.serialNumberForProducts.add(line.get(4));
                            break;

                        case "F1":

                            Flour flour = new Flour(line.get(1), Double.parseDouble(line.get(2)),
                                    Double.parseDouble(line.get(3)), line.get(4));
                            revenue -= flour.getProductCost();
                            printUncountableItems(flour);
                            this.itemsArrayList.add(flour);
                            this.serialNumberForProducts.add(line.get(4));
                            break;


                        case "P1":

                            Pasta pasta = new Pasta(line.get(1), Double.parseDouble(line.get(2)),
                                    Double.parseDouble(line.get(3)), line.get(4));
                            revenue -= pasta.getProductCost();
                            printUncountableItems(pasta);
                            this.itemsArrayList.add(pasta);
                            this.serialNumberForProducts.add(line.get(4));
                            break;


                        case "R1":

                            Rice rice = new Rice(line.get(1), Double.parseDouble(line.get(2)),
                                    Double.parseDouble(line.get(3)), line.get(4));
                            revenue -= rice.getProductCost();
                            printUncountableItems(rice);
                            this.itemsArrayList.add(rice);
                            this.serialNumberForProducts.add(line.get(4));
                            break;


                        case "B1":

                            CountableBox countableBox = new CountableBox(line.get(1), Double.parseDouble(line.get(3)),
                                    line.get(4), Integer.parseInt(line.get(2)));
                            revenue -= countableBox.getProductPrice();
                            printCountableBoxes(countableBox);
                            this.boxArrayList.add(countableBox);
                            this.serialNumberForProducts.add(line.get(4));
                            break;

                        case "B2":

                            UncountableBox uncountableBox = new UncountableBox(line.get(1), Double.parseDouble(line.get(3)),
                                    line.get(4), Integer.parseInt(line.get(2)));
                            revenue -= uncountableBox.getProductPrice();
                            printUncountableBoxes(uncountableBox);
                            this.boxArrayList.add(uncountableBox);
                            this.serialNumberForProducts.add(line.get(4));
                            break;

                        case "C1":
                            Container container = new Container(line.get(1), Double.parseDouble(line.get(2)), line.get(3));
                            revenue -= container.getProductCost();
                            printContainers(container);
                            this.containerArrayList.add(container);
                            this.serialNumberForProducts.add(line.get(3));
                            break;
                    }
                }
                else{
                    throw new ExistingSerialNumberException();
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }


        










    /*
    public void initializeProducts(ArrayList<ArrayList<String>> commandList) throws FileNotFoundException,ExistingSerialNumberException {
        for (ArrayList<String> line : commandList) {
            String code = line.get(1);

            try {
                if(!isSerialNumberAlreadyExist(line.get(line.size() -1))){
                    switch (code) {
                        case "M1":
                            BoxOfMilk boxOfMilk = new BoxOfMilk(line.get(1), Double.parseDouble(line.get(2)), line.get(3));
                            revenue -= boxOfMilk.getProductCost();
                            printCountableItems(boxOfMilk);
                            this.itemsArrayList.add(boxOfMilk);
                            this.serialNumberForProducts.add(line.get(3));
                            break;

                        case "W1":
                            BoxOfWater boxOfWater = new BoxOfWater(line.get(1), Double.parseDouble(line.get(2)), line.get(3));
                            revenue -= boxOfWater.getProductCost();
                            printCountableItems(boxOfWater);
                            this.itemsArrayList.add(boxOfWater);
                            this.serialNumberForProducts.add(line.get(3));
                            break;

                        case "O1":

                            BoxOfOil boxOfOil = new BoxOfOil(line.get(1), Double.parseDouble(line.get(2)), line.get(3));
                            revenue -= boxOfOil.getProductCost();
                            printCountableItems(boxOfOil);
                            this.itemsArrayList.add(boxOfOil);
                            this.serialNumberForProducts.add(line.get(3));
                            break;

                        case "S1":

                            Sugar sugar = new Sugar(line.get(1), Double.parseDouble(line.get(2)),
                                    Double.parseDouble(line.get(3)), line.get(4));
                            revenue -= sugar.getProductCost();
                            printUncountableItems(sugar);
                            this.itemsArrayList.add(sugar);
                            this.serialNumberForProducts.add(line.get(4));
                            break;

                        case "F1":

                            Flour flour = new Flour(line.get(1), Double.parseDouble(line.get(2)),
                                    Double.parseDouble(line.get(3)), line.get(4));
                            revenue -= flour.getProductCost();
                            printUncountableItems(flour);
                            this.itemsArrayList.add(flour);
                            this.serialNumberForProducts.add(line.get(4));
                            break;


                        case "P1":

                            Pasta pasta = new Pasta(line.get(1), Double.parseDouble(line.get(2)),
                                    Double.parseDouble(line.get(3)), line.get(4));
                            revenue -= pasta.getProductCost();
                            printUncountableItems(pasta);
                            this.itemsArrayList.add(pasta);
                            this.serialNumberForProducts.add(line.get(4));
                            break;


                        case "R1":

                            Rice rice = new Rice(line.get(1), Double.parseDouble(line.get(2)),
                                    Double.parseDouble(line.get(3)), line.get(4));
                            revenue -= rice.getProductCost();
                            printUncountableItems(rice);
                            this.itemsArrayList.add(rice);
                            this.serialNumberForProducts.add(line.get(4));
                            break;


                        case "B1":

                            CountableBox countableBox = new CountableBox(line.get(1), Double.parseDouble(line.get(3)),
                                    line.get(4), Integer.parseInt(line.get(2)));
                            revenue -= countableBox.getProductPrice();
                            printCountableBoxes(countableBox);
                            this.boxArrayList.add(countableBox);
                            this.serialNumberForProducts.add(line.get(4));
                            break;

                        case "B2":

                            UncountableBox uncountableBox = new UncountableBox(line.get(1), Double.parseDouble(line.get(3)),
                                    line.get(4), Integer.parseInt(line.get(2)));
                            revenue -= uncountableBox.getProductPrice();
                            printUncountableBoxes(uncountableBox);
                            this.boxArrayList.add(uncountableBox);
                            this.serialNumberForProducts.add(line.get(4));
                            break;

                        case "C1":
                            Container container = new Container(line.get(1), Double.parseDouble(line.get(2)), line.get(3));
                            revenue -= container.getProductCost();
                            printContainers(container);
                            this.containerArrayList.add(container);
                            this.serialNumberForProducts.add(line.get(3));
                            break;
                        }
                    }
                else{
                    throw new ExistingSerialNumberException();
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
*/

    private boolean isSerialNumberAlreadyExist(String SerialNumber) {
        return serialNumberForProducts.contains(SerialNumber);
    }


    public ArrayList<Container> getContainerArrayList() {
        return containerArrayList;
    }

    public ArrayList<Box> getBoxArrayList() {
        return boxArrayList;
    }

    public ArrayList<ItemInterface> getItemsArrayList() {
        return itemsArrayList;
    }

    public <T extends CountableItemInterface> void printCountableItems(T item){
        System.out.println(item.getVolume() +" Liter "  + item.getItemName() + " has been produced with the serial number " +
                item.getSerialNumber() + "\t"+"Revenue : " + revenue);
    }
    public <T extends UncountableItemInterface> void printUncountableItems(T item){
        System.out.println(item.getMass() +" kg "  + item.getItemName() + " has been produced with the serial number " +
                item.getSerialNumber() + "\t"+"Revenue : " + revenue);

    }
    public <T extends IUncountableBox> void printUncountableBoxes(T item){
        System.out.println(item.getMass() +" Kg "  + item.getItemName() + " has been produced with the serial number " +
                item.getBoxSerialNumber() +"\t" +"Revenue : " + revenue);

    }
    public <T extends ICountableBox> void printCountableBoxes(T item){
        System.out.println(item.getVolume() +" Liter "  + item.getItemName() + " has been produced with the serial number " +
                item.getBoxSerialNumber() + "\t" +"Revenue : " + revenue);

    }
    public <T extends Container> void printContainers(T item){
        System.out.println(item.getVolume() +" Liter "  + item.getItemName() + " has been produced with the serial number " +
                item.getContainerSerialNumber() + "\t"	+"Revenue : " + revenue);
    }

    public ArrayList<String> getSerialNumberForProducts() {
        return serialNumberForProducts;
    }

    public double getRevenue() {
        return revenue;
    }



}
