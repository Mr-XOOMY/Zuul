import java.io.BufferedReader;
import java.io.FileReader;

public class Riddle {

    static Riddle riddle = new Riddle();

    public void riddle1(){
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.riddle1();
        String riddleId = "riddle1";
        String riddleLocation = "Story/riddle1.txt";
        printRiddle(riddleLocation);
        try {
            Thread.sleep(14000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.riddlesInTheDark();
        Item.itemObject.inputItems(riddleId);
    }

    public void riddle2(){
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.riddle2();
        String riddleId = "riddle2";
        String riddleLocation = "Story/riddle2.txt";
        printRiddle(riddleLocation);
        try{
            Thread.sleep(14000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.riddlesInTheDark();
        Item.itemObject.inputItems(riddleId);
    }

     public void riddle3(){
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.riddle3();
        String riddleId = "riddle3";
        String riddleLocation = "Story/riddle3.txt";
        printRiddle(riddleLocation);
        try {
            Thread.sleep(18000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
         Music.musicObject.getDevice().stop();
         Music.musicObject.getDevice().close();
         Music.musicObject.riddlesInTheDark();
         Item.itemObject.inputItems(riddleId);
    }

    /**
     *
     * @param riddleLocation String with the location of the riddle.txt file, which is being read by a BufferedReader and prints it contents line for line to the terminal.
     */
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
