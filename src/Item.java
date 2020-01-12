import javax.sound.sampled.Clip;
import java.util.Scanner;

public class Item {

    static Item location = new Item();
    String previousLocationId;
    String currentLocationId;

    public static void drawItems(String[] items) {
        System.out.println();

        for (String item : items) {
            System.out.println(item);
        }
    }

    public static void inputItems(String[] items, String locationId) {
        location.setPreviousLocationId(locationId);
        location.setCurrentLocationId(locationId);

        //noinspection InfiniteLoopStatement
        while (true) {
            Scanner input = new Scanner(System.in);  // Create a Scanner object
            System.out.print("> ");
            String inputCommand = input.nextLine();
            inputCommand = inputCommand.replaceAll("\\s+", "").toLowerCase();
            boolean command = false;

            for (String item : items) {
                item = item.replaceAll("\\s+", "").toLowerCase();
                if (inputCommand.equals(item)) {
                    command = true;
                    break;
                }
            }

            if (command) {
                switch (locationId) {
                    case "menu":
                        Music.music.getDevice().stop();
                        Music.music.getDevice().close();
                        Menu.inputCommand(inputCommand);
                        break;
                    //case "game":
                    //    Game.inputCommand(inputCommand);
                    //    break;
                    case "soundsettings":
                        Audiosettings.inputCommand(inputCommand, items);
                        break;
                    case "music":
                        Music.inputCommand(inputCommand, items);
                        break;
                    case "about":
                        CommandList.inputCommand(inputCommand);
                        break;
                    case "quit":
                        Quit.inputCommand(inputCommand);
                        break;
                }
            } else if (inputCommand.equals("menu") && !location.getCurrentLocationId().equals("menu")) {
                CommandList.inputCommand(inputCommand);
            }else {
                CommandList.invalid(items);
            }
        }
    }

    public void setPreviousLocationId (String locationId){
        if (previousLocationId == null) {
            previousLocationId = locationId;
        }else {
            previousLocationId = currentLocationId;
        }
    }

    public void setCurrentLocationId (String locationId){
        currentLocationId = locationId;
    }

    public String getPreviousLocationId (){
        return previousLocationId;
    }

    public String getCurrentLocationId (){
        return currentLocationId;
    }
}