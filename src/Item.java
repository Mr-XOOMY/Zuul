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
                        CommandList.commandListObject.inputCommand(inputCommand);
                        break;
                    case "quit":
                        Quit.quitObject.inputCommand(inputCommand);
                        break;
                    case "room1":
                        Room.game.inputCommandRoom1(inputCommand);
                        break;
                    case "room2":
                        Room.game.inputCommandRoom2(inputCommand);
                        break;
                }
            } else {
                if (inputCommand.equals("menu")) {
                    switch (currentLocationId) {
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
                    case "about":
                        countDown.timer.cancel();
                        System.out.println("You were on time!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        CommandList.commandListObject.inputCommand(inputCommand);
                        break;
                }
            } else {
                if (inputCommand.equals("menu")) {
                    switch (currentLocationId) {
                        case "about":
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
        }
    }
}