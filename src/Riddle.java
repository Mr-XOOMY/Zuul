import java.io.BufferedReader;
import java.io.FileReader;

public class Riddle {

    public Riddle(){
        riddle1();
        riddle2();
        riddle3();
        riddle4();
        riddle5();
    }

    private void riddle1(){
        String riddleLocation = "Story/riddle1.txt";
        printRiddle(riddleLocation);
        Item.itemObject.inputItems(items, locationId);

    }

    public void inputCommandRiddle1 (String command){
        if(command != "mountain"){
            // Game Ending
        }
    }

    private void riddle2(){
        String riddleLocation = "Story/riddle2.txt";
        printRiddle(riddleLocation);
    }

    public void inputCommandRiddle2(String command){
        if(command != "wind"){
            // Game Ending
        }
    }

    private void riddle3(){
        String riddleLocation = "Story/riddle3.txt";
        printRiddle(riddleLocation);
    }

    public void inputCommandRiddle3(String command){
        if(command != "dark"){
//            Game Ending
        }
    }

    private void riddle4(){
        String riddleLocation = "Story/riddle4.txt";
        printRiddle(riddleLocation);
    }

    public void inputCommandRiddle4(String command){
        if(command != "fish"){
//            Game Ending
        }
    }

    private void riddle5(){
        String riddleLocation = "Story/riddle5.txt";
        printRiddle(riddleLocation);
    }

    public void inputCommandRiddle5(String command){
        if(command != "time"){
//            Game Ending
        }
    }

    public void printRiddle(String riddleLocation){
        try {
            BufferedReader input = new BufferedReader(new FileReader(riddleLocation));
            String line = input.readLine();
            while (line != null) {
                System.out.println(line);
                line = input.readLine();
            }
            input.close();
        } catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Riddle could not be printed.");
        }
    }


}
