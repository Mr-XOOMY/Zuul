import java.util.Scanner;

public class Item {

    static Item itemObject = new Item();
    String previousLocationId;
    String currentLocationId;

    public Item(){
    }

    public void drawItems(String[] items) {
        System.out.println();

        for (String item : items) {
            System.out.println(item);
        }
    }

    public void inputItems(String[] items, String locationId) {
        setPreviousLocationId(locationId);
        setCurrentLocationId(locationId);

        //noinspection InfiniteLoopStatement
        while (true) {
            Scanner input = new Scanner(System.in);  // Create a Scanner object
            System.out.print("> ");
            String inputCommand = input.nextLine();
            inputCommand = inputCommand.replaceAll("\\s+", "").toLowerCase();
            System.out.println();
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
                        Menu.menu.inputCommand(inputCommand);
                        break;
                    //case "game":
                    //    Game.inputCommand(inputCommand);
                    //    break;
                    case "soundsettings":
                        Audiosettings.audioSettingsObject.inputCommand(inputCommand, items);
                        break;
                    case "music":
                        Music.musicObject.inputCommand(inputCommand, items);
                        break;
                    case "about":
                        CommandList.commandListObject.inputCommand(inputCommand);
                        break;
                    case "quit":
                        Quit.quitObject.inputCommand(inputCommand);
                        break;
                }
            } else {
                if (inputCommand.equals("menu")) {
                    switch (getCurrentLocationId()) {
                        case "menu":
                        case "soundsettings":
                        case "music":
                        case "about":
                        case "quit":
                            CommandList.commandListObject.invalid(items, locationId);
                            break;
                        default:
                            CommandList.commandListObject.inputCommand(inputCommand);
                    }
                }else {
                    CommandList.commandListObject.invalid(items, locationId);
                }
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