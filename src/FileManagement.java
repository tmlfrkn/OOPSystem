import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileManagement {
    private FileIO fileIO;
    ArrayList<ArrayList<String>> commandList;


    public FileManagement() throws FileNotFoundException {
        this.fileIO  = new FileIO();
        this.commandList = fileIO.read("src/ExampleCommands.csv");
    }

    public void doTask() throws FileNotFoundException, ExistingSerialNumberException {
        Merchant merchant = new Merchant();
        merchant.readTask(this.commandList);
    }




    public ArrayList<ArrayList<String>> produceList(){
        ArrayList<ArrayList<String>> returnedList = new ArrayList<>();
        for(ArrayList<String> line : this.commandList){
            if(line.get(0).equals("1")){
                returnedList.add(line);
            }
        }
        return returnedList;
    }

    public ArrayList<ArrayList<String>> loadList(){
        ArrayList<ArrayList<String>> returnedList = new ArrayList<>();
        for(ArrayList<String> line : this.commandList){
            if(line.get(0).equals("2")){
                returnedList.add(line);
            }
        }
        return returnedList;
    }

    public ArrayList<ArrayList<String>> shipList(){
        ArrayList<ArrayList<String>> returnedList = new ArrayList<>();
        for(ArrayList<String> line : this.commandList){
            if(line.get(0).equals("3")){
                returnedList.add(line);
            }
        }
        return returnedList;
    }

    public ArrayList<ArrayList<String>> showList(){
        ArrayList<ArrayList<String>> returnedList = new ArrayList<>();
        for(ArrayList<String> line : this.commandList){
            if(line.get(0).equals("4")){
                returnedList.add(line);
            }
        }
        return returnedList;
    }




}
