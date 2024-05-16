import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class FileIO {
    public ArrayList<ArrayList<String>> read(String relativePath) throws FileNotFoundException{
        File file = new File(relativePath);
        ArrayList<ArrayList<String>> returnArraylist = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                ArrayList<String> tempArrayList = new ArrayList<>();
                String[] tempArray = scanner.nextLine().split(",");
                for(int i = 0;i< tempArray.length;i++){
                    tempArrayList.add(tempArray[i]);
                }
                returnArraylist.add(tempArrayList);
            }
            return returnArraylist;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }


}
