import java.util.Scanner;

public class Item {

    static Item itemObject = new Item();
    String previousLocationId;
    String currentLocationId;
    String roomId;

    public Item(){
    }

    public void drawItems(String[] items) {
        System.out.println();

        for (String item : items) {
            System.out.println(item);
        }
    }

    public void inputItems(String[] items, String locationId) {
        setLocationId(locationId);

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
                    case "soundsettings":
                        Audiosettings.audioSettingsObject.inputCommand(inputCommand, items);
                        break;
                    case "music":
                        Music.musicObject.inputCommand(inputCommand, items);
                        break;
                    case "about":
                        CommandList.commandListObject.inputCommand(inputCommand, roomId);
                        break;
                    case "quit":
                        Quit.quitObject.inputCommand(inputCommand);
                        break;
                    case "map":
                        CommandList.commandListObject.inputCommand(inputCommand, roomId);
                        break;
                    case "room1":
                        Room.game.inputCommandRoom1(inputCommand);
                        break;
                    case "room2":
                        Room.game.inputCommandRoom2(inputCommand);
                        break;
                    case "room4":
                        Room.game.inputCommandRoom4(inputCommand);
                        break;
                    case "room5":
                        Room.game.inputCommandRoom5(inputCommand);
                        break;
                    case "room6":
                        Room.game.inputCommandRoom6(inputCommand);
                        break;
                    case "room7":
                        Room.game.inputCommandRoom7(inputCommand);
                        break;
                }
            } else {
                if (inputCommand.equals("menu") || inputCommand.equals("map")) {
                    switch (currentLocationId) {
                        case "menu":
                        case "soundsettings":
                        case "music":
                        case "about":
                        case "quit":
                            CommandList.commandListObject.invalid(items, locationId);
                            break;
                        default:
                            CommandList.commandListObject.inputCommand(inputCommand, roomId);
                    }
                }else {
                    CommandList.commandListObject.invalid(items, locationId);
                }
            }
        }
    }

    public void inputItems(String[] items, String locationId, Countdown countDown) {
        setLocationId(locationId);

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
                    case "room3":
                        countDown.timer.cancel();
                        Room.game.inputCommandRoom3(inputCommand);
                        break;
                }
            } else {
                if (inputCommand.equals("menu") || inputCommand.equals("map")) {
                    CommandList.commandListObject.inputCommand(inputCommand, roomId);
                }else {
                    CommandList.commandListObject.invalid(items, locationId);
                }
            }
        }
    }

    public void setLocationId (String locationId){
        if (previousLocationId == null) {
            previousLocationId = locationId;
            currentLocationId = locationId;
        }else {
            previousLocationId = currentLocationId;
            currentLocationId = locationId;
        }

        switch (locationId){
            case "room1":
                roomId = locationId;
                break;
            case "room2":
                roomId = locationId;
                break;
            case "room3":
                roomId = locationId;
                break;
            case "room4":
                roomId = locationId;
                break;
            case "room5":
                roomId = locationId;
                break;
            case "room6":
                roomId = locationId;
                break;
            case "room7":
                roomId = locationId;
                break;
        }
    }
}