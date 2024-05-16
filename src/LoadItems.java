import java.util.ArrayList;
//Bu class gidicek
public class LoadItems {

    private ArrayList<Container> remainContainerArrayList = new ArrayList<>();
    private ArrayList<BoxInterface>  remainBoxArrayList = new ArrayList<>();
    private ArrayList<ItemInterface> remainItemsArrayList = new ArrayList<>();
//Bunlar silinecek ItemProducerDaki kullanılacak

    public LoadItems(ArrayList<Container> remainContainerArrayList, ArrayList<BoxInterface> remainBoxArrayList, ArrayList<ItemInterface> remainItemsArrayList) {
        this.remainContainerArrayList = remainContainerArrayList;
        this.remainBoxArrayList = remainBoxArrayList;
        this.remainItemsArrayList = remainItemsArrayList;
    }

    public boolean load(ArrayList<String> command) {
        try {
            if ((!(command.get(1).startsWith("B") && command.get(1).startsWith("C")) && command.get(2).startsWith("B"))) {
                BoxInterface box = findBox(command.get(2), remainBoxArrayList);
                ItemInterface item = findItem(command.get(1), remainItemsArrayList);
                if (item.getIsLoaded()) {
                    throw new SameItemsCannotBeLoadAgain();

                } else {
                    if (box.getIsLoaded()) {
                        throw new ItemCanNotLoadToLoadedBox();
                    }
                    else{
                        if(box.isProper(item)){
                            if(box.isFit(item)){
                                box.addItem(item);
                                return true;
                            }
                        }
                        else {
                            throw new ItemIsNotProperForCountableBox();
                        }
                    }

                }
            } else if ((!(command.get(1).startsWith("B") && command.get(1).startsWith("C")) && command.get(2).startsWith("C"))) {
                throw new ItemCannotLoadDirectlyContainer();

            } else if (command.get(1).startsWith("B") && command.get(2).startsWith("C")) {
                BoxInterface box = findBox(command.get(1), remainBoxArrayList);
                Container container = findContainer(command.get(2), remainContainerArrayList);
                if (container.getIsShipped()) {
                    throw new ContainerIsShippedException();
                }
                else {
                    if (box.getIsLoaded()) {
                        throw new BoxAlreadyLoaded();
                    } else {
                        if (container.isFit(box)) {
                            throw new ContainerCanNotTakeBox();
                        } else {
                            container.add(box);
                            return true;
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









    /*
    public void Load(ArrayList<String> commandList){
        try {
            if (checkIsExist(commandList.get(0),this.remainItemsArrayList,this.remainBoxArrayList,this.remainContainerArrayList)) {
                try {
                    if (!checkAlreadyUsed(alreadyUsedCodes, commandList.get(0))) {

                    }
                    else{

                    }
                }catch (Exception e){
                    e.getMessage();
                }
            }
            else {
                throw new EntityNotExist();
            }
        }catch (Exception e){
            e.getMessage();
        }

    }

    public boolean checkIsExist(String serialCode,ArrayList<ItemInterface> itemList,ArrayList<BoxInterface> boxInterfaceList,ArrayList<Container> containerArrayList){
        for(ItemInterface i:itemList){
            if(i.getSerialNumber().equals(serialCode)){
                return true;
            }

            }
        for(BoxInterface b: boxInterfaceList){
            if(b.getBoxSerialNumber().equals(serialCode)){
                return true;
            }

        }
        for(Container c:containerArrayList){
            if(c.getContainerSerialNumber().equals(serialCode)){
                return true;
            }

        }
        return false;
    }
*/





    public ArrayList<Container> getRemainContainerArrayList() {
        return remainContainerArrayList;
    }

    public ArrayList<BoxInterface> getRemainBoxArrayList() {
        return remainBoxArrayList;
    }

    public ArrayList<ItemInterface> getRemainItemsArrayList() {
        return remainItemsArrayList;
    }


}
