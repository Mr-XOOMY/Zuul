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
        long startTime = System.currentTimeMillis();
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
                    case "room3":
                        long endTime = System.currentTimeMillis();
                        if ((endTime - startTime) > 36000) {
                            System.out.println(endTime);
                            GameEnding.ending.GameEnding("countdown");
                        }else {
                            Room.game.inputCommandRoom3(inputCommand);
                        }
                        break;
                    case "room4":
                        Room.game.inputCommandRoom4(inputCommand);
                        break;
                    case "room5":
                        Room.game.inputCommandRoom5(inputCommand);
                        break;
                    case "room6_1":
                        Room.game.inputCommandRoom6_1(inputCommand, Room.game.getFirstRun());
                        break;
                    case "room6_2":
                        Room.game.inputCommandRoom6_2(inputCommand);
                        break;
                    //case "room7":
                    //    Room.game.inputCommandRoom7(inputCommand);
                    //    break;
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
                            Music.musicObject.getDevice().stop();
                            Music.musicObject.getDevice().close();
                            CommandList.commandListObject.inputCommand(inputCommand, roomId);
                    }
                }else {
                    CommandList.commandListObject.invalid(items, locationId);
                }
            }
        }
    }

    public void inputItems(String riddleId) {

        //noinspection InfiniteLoopStatement
        while (true) {
            Scanner input = new Scanner(System.in);  // Create a Scanner object
            System.out.print("> ");
            String inputCommand = input.nextLine();
            inputCommand = inputCommand.replaceAll("\\s+", "").toLowerCase();
            System.out.println();

            switch (riddleId) {
                case "riddle1":
                    if (inputCommand.equals("mountain")) {
                        System.out.println("Your answer is correct!");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Room room7 = new Room("room7");
                    } else {
                        GameEnding.ending.GameEnding("smeagol");
                    }
                    break;
                case "riddle2":
                    if (inputCommand.equals("wind")) {
                        System.out.println("Your answer is correct!");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Room room7 = new Room("room7");
                    } else {
                        GameEnding.ending.GameEnding("smeagol");
                    }
                    break;
                case "riddle3":
                    if (inputCommand.equals("dark")) {
                        System.out.println("Your answer is correct!");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Room room7 = new Room("room7");
                    } else {
                        GameEnding.ending.GameEnding("smeagol");
                    }
                    break;
                case "riddle4":
                    if (inputCommand.equals("fish")) {
                        System.out.println("Your answer is correct!");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Room room7 = new Room("room7");
                    } else {
                        GameEnding.ending.GameEnding("smeagol");
                    }
                    break;
                case "riddle5":
                    if (inputCommand.equals("time")) {
                        System.out.println("Your answer is correct!");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Room room7 = new Room("room7");
                    } else {
                        GameEnding.ending.GameEnding("smeagol");
                    }
                    break;
            }
        }
    }

    public void inputItems() {

        //noinspection InfiniteLoopStatement
        while (true) {
            Scanner input = new Scanner(System.in);  // Create a Scanner object
            System.out.print("> ");
            String inputCommand = input.nextLine();
            inputCommand = inputCommand.replaceAll("\\s+", "").toLowerCase();
            System.out.println();
            boolean command = false;

            Music.musicObject.getDevice().stop();
            Music.musicObject.getDevice().close();
            Item.itemObject.roomId = null;
            Room.game.inventory[0] = null;
            Room.game.inventory[1] = null;
            Menu.menu.menu();
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