import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Merchant{
    private ArrayList<Container> containerArrayList = new ArrayList<>();
    private ArrayList<BoxInterface> boxArrayList = new ArrayList<>();
    private ArrayList<ItemInterface> itemsArrayList = new ArrayList<>();
    private double revenue = 0;
    private ArrayList<String> serialNumberForProducts = new ArrayList<>();

    public Merchant() throws FileNotFoundException {


    }


    public void readTask(ArrayList<ArrayList<String>> commandList) throws FileNotFoundException, ExistingSerialNumberException {
        for(ArrayList<String> command: commandList){
            String commandTitle = command.get(0);
            switch (commandTitle){
                case "1":
                    initializeProducts(command);
                    break;
                case "2":
                    load(command);
                    break;
                case "3":
                    ship(command);
            }
        }
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

    private boolean isSerialNumberAlreadyExist(String SerialNumber) {
        return serialNumberForProducts.contains(SerialNumber);
    }



    private <T extends CountableItemInterface> void printCountableItems(T item){
        System.out.println(item.getVolume() +" Liter "  + item.getItemName() + " has been produced with the serial number " +
                item.getSerialNumber() + "\t"+" Revenue : " + revenue);
    }
    private <T extends UncountableItemInterface> void printUncountableItems(T item){
        System.out.println(item.getMass() +" kg "  + item.getItemName() + " has been produced with the serial number " +
                item.getSerialNumber() + "\t"+" Revenue : " + revenue);

    }
    private <T extends IUncountableBox> void printUncountableBoxes(T item){
        System.out.println(item.getMass() +" Kg "  + item.getItemName() + " has been produced with the serial number " +
                item.getBoxSerialNumber() +"\t" +"  Revenue : " + revenue);

    }
    private <T extends ICountableBox> void printCountableBoxes(T item){
        System.out.println(item.getVolume() +" Liter "  + item.getItemName() + " has been produced with the serial number " +
                item.getBoxSerialNumber() + "\t" +" Revenue : " + revenue);

    }
    private <T extends Container> void printContainers(T item){
        System.out.println(item.getVolume() +" Liter "  + item.getItemName() + " has been produced with the serial number " +
                item.getContainerSerialNumber() + "\t"	+"  Revenue : " + revenue);
    }





    public boolean load(ArrayList<String> command) {
        try {
            if ((!(command.get(1).startsWith("B") && command.get(1).startsWith("C")) && command.get(2).startsWith("B"))) {
                BoxInterface box = findBox(command.get(2), boxArrayList);
                ItemInterface item = findItem(command.get(1), itemsArrayList);
                if (item.getIsLoaded()) {
                    System.out.println("Item with the serial number " + item.getSerialNumber() + " can not be loaded to the box " +
                            box.getBoxSerialNumber() +"\t");
                    throw new SameItemsCannotBeLoadAgain();

                } else {
                    if (box.getIsLoaded()) {
                        System.out.println("Item with the serial number " + item.getSerialNumber() + " can not be loaded to the box " +
                                box.getBoxSerialNumber() +"\t");
                        throw new ItemCanNotLoadToLoadedBox();
                    }
                    else{
                        if(box.isProper(item)){
                            if(box.isFit(item)){
                                System.out.println("Item with the serial number " + item.getSerialNumber() + " has been loaded to the box "
                                        + box.getBoxSerialNumber());
                                item.setLoadItems();
                                System.out.println(item);
                                box.addItem(item);
                                System.out.println(box);
                                return true;
                            }
                            else{
                                System.out.println("Item with the serial number " + item.getSerialNumber() + " can not be loaded to the box "
                                        + box.getBoxSerialNumber());
                                throw new MassBoxCanNotHoldCapacityException();
                            }
                        }
                        else {
                            System.out.println("Item with the serial number " + item.getSerialNumber() + " can not be loaded to the box " +
                                    box.getBoxSerialNumber() +"\t");
                            throw new ItemIsNotProperForCountableBox();
                        }
                    }
                }
            } else if (!command.get(1).startsWith("B") && !command.get(1).startsWith("C") && command.get(2).startsWith("C")){
                ItemInterface item = findItem(command.get(1), itemsArrayList);
                System.out.println("Item with the serial number " + item.getSerialNumber() + " can not be loaded to the container");
                throw new ItemCannotLoadDirectlyContainer();

            } else if (command.get(1).startsWith("B") && command.get(2).startsWith("C")) {
                BoxInterface box = findBox(command.get(1), boxArrayList);
                Container container = findContainer(command.get(2),containerArrayList);
                if (container.getIsShipped()) {
                    System.out.println("Box with the serial number " + box.getBoxSerialNumber() + " can not be loaded to the container"
                    + container.getContainerSerialNumber());
                    throw new ContainerIsShippedException();
                }
                else {
                    if (box.getIsLoaded()) {
                        System.out.println("Box with the serial number " + box.getBoxSerialNumber() + " can not be loaded to the container"
                                + container.getContainerSerialNumber() + "\t");
                        throw new BoxAlreadyLoaded();
                    } else {
                        if (container.isFit(box)) {
                            System.out.println("Box with the serial number " + box.getBoxSerialNumber() + " has been loaded to the container"
                                    + container.getContainerSerialNumber() + "\t");
                            container.add(box);
                            return true;

                        } else {
                            System.out.println("Box with the serial number " + box.getBoxSerialNumber() + " can not be loaded to the container "
                                    + container.getContainerSerialNumber() + "\t");
                            throw new ContainerCanNotTakeBox();
                        }
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean ship(ArrayList<String> command){
        if(command.get(1).startsWith("C")){
            Container container = findContainer(command.get(1),containerArrayList);
            if(!container.getIsShipped()){
                container.setShipped();
                revenue +=  sumTotalEarnEachShippedContainer(container);
                System.out.println("Container C001 has been shipped\t\t\t" + " Revenue: " + revenue);
                return true;

            }
            else{
                System.out.println("Containers can not shipped\t\t\t" + " Revenue: " + revenue);
                return false;
            }
        }
        else{
            System.out.println("Items and Boxes can not be directly shipped\t\t\t" + " Revenue: " + revenue);
            return false;
        }
    }

    public double sumTotalEarnEachShippedContainer(Container container){
        ArrayList<BoxInterface> boxList =  container.getBoxList();
        double returnedPrice = 0;
        for(BoxInterface box : boxList){
            System.out.println(box.getBoxSerialNumber());
            System.out.println(box.getTotalprice());
            returnedPrice += box.getTotalprice();
        }
        return returnedPrice;
    }




    public ItemInterface findItem(String serialCode, ArrayList<ItemInterface> itemList) {
        for (ItemInterface item : itemList) {
            if (item.getSerialNumber().equals(serialCode)) {
                return item;
            }
        }
        return null;
    }
    public BoxInterface findBox(String serialCode, ArrayList<BoxInterface> boxList) {
        for (BoxInterface box : boxList) {
            if (box.getBoxSerialNumber().equals(serialCode)) {
                return box;
            }
        }
        return null;
    }
    public Container findContainer(String serialCode, ArrayList<Container> containerList) {
        for (Container container : containerList) {
            if (container.getContainerSerialNumber().equals(serialCode)) {
                return container;
            }
        }
        return null;
    }



    public ArrayList<Container> getContainerArrayList() {
        return containerArrayList;
    }

    public ArrayList<BoxInterface> getBoxArrayList() {
        return boxArrayList;
    }

    public ArrayList<ItemInterface> getItemsArrayList() {
        return itemsArrayList;
    }

    public double getRevenue() {
        return revenue;
    }
}
