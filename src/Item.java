import java.util.Scanner;

public class Item {

    static Item itemObject = new Item();
    String previousLocationId;
    String currentLocationId;
    String roomId;

    public Item(){
    }

    /**
     *
     * @param items Array[] with the possible commands a user can give.
     */
    public void drawItems(String[] items) {
        System.out.println();

        for (String item : items) {
            System.out.println(item);
        }
    }

    /**
     *
     * @param items Array[] with the possible commands a user can give.
     * @param locationId String which contains the current locationId.
     */
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
                    case "map":
                        CommandList.commandListObject.inputCommand(inputCommand, roomId);
                        break;
                    case "quit":
                        Quit.quitObject.inputCommand(inputCommand);
                        break;
                    case "room1":
                        Music.musicObject.getDevice().stop();
                        Music.musicObject.getDevice().close();
                        Room.game.inputCommandRoom1(inputCommand);
                        break;
                    case "room2":
                        Music.musicObject.getDevice().stop();
                        Music.musicObject.getDevice().close();
                        Room.game.inputCommandRoom2(inputCommand);
                        break;
                    case "room3":
                        Music.musicObject.getDevice().stop();
                        Music.musicObject.getDevice().close();
                        long endTime = System.currentTimeMillis();
                        if ((endTime - startTime) > 36000) {
                            GameEnding.ending.ending("countdown");
                        }else {
                            Room.game.inputCommandRoom3(inputCommand);
                        }
                        break;
                    case "room4":
                        Room.game.inputCommandRoom4(inputCommand);
                        break;
                    case "room5":
                        Music.musicObject.getDevice().stop();
                        Music.musicObject.getDevice().close();
                        Room.game.inputCommandRoom5(inputCommand);
                        break;
                    case "room6_1":
                        Room.game.inputCommandRoom6_1(inputCommand);
                        break;
                    case "room6_2":
                        Room.game.inputCommandRoom6_2(inputCommand);
                        break;
                }
            } else {
                switch (inputCommand) {
                    case "menu":
                        switch (currentLocationId) {
                            case "menu":
                            case "soundsettings":
                            case "music":
                            case "about":
                            case "quit":
                            case "room3":
                            case "room6_2":
                                CommandList.commandListObject.invalid(items, locationId, "You've typed an invalid command...");
                                break;
                            case "room1":
                            case "room2":
                            case "room4":
                            case "room5":
                            case "room6":
                            case "room6_1":
                                Music.musicObject.getDevice().stop();
                                Music.musicObject.getDevice().close();
                                CommandList.commandListObject.inputCommand(inputCommand, roomId);
                            default:
                                Music.musicObject.getDevice().stop();
                                Music.musicObject.getDevice().close();
                                CommandList.commandListObject.inputCommand(inputCommand, roomId);
                        }
                        break;
                    case "map":
                        switch (currentLocationId) {
                            case "menu":
                            case "soundsettings":
                            case "music":
                            case "about":
                            case "quit":
                            case "room3":
                            case "room6_2":
                                CommandList.commandListObject.invalid(items, locationId, "You've typed an invalid command...");
                                break;
                            case "room1":
                            case "room2":
                            case "room4":
                            case "room5":
                            case "room6":
                            case "room6_1":
                                CommandList.commandListObject.inputCommand(inputCommand, roomId);
                            default:
                                Music.musicObject.getDevice().stop();
                                Music.musicObject.getDevice().close();
                                CommandList.commandListObject.inputCommand(inputCommand, roomId);
                        }
                        break;
                    case "back":
                        switch (currentLocationId) {
                            case "room4":
                            case "room5":
                            case "room6":
                            case "room6_1":
                                CommandList.commandListObject.invalid(items, locationId, "You can't go back now coward! You've already signed the contract!");
                                break;
                            default:
                                CommandList.commandListObject.invalid(items, locationId, "You've typed an invalid command...");
                        }
                        break;
                    default:
                        CommandList.commandListObject.invalid(items, locationId, "You've typed an invalid command...");
                        break;
                }
            }
        }
    }

    /**
     *
     * @param riddleId String which contains a value for the switch case to call the correct method.
     */
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
                        System.out.println("Your answer is correct!"+System.lineSeparator());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Riddle.riddle.riddle2();
                    } else {
                        GameEnding.ending.ending("smeagol");
                    }
                    break;
                case "riddle2":
                    if (inputCommand.equals("wind")) {
                        System.out.println("Your answer is correct!"+System.lineSeparator());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }Riddle.riddle.riddle3();
                    } else {
                        GameEnding.ending.ending("smeagol");
                    }
                    break;
                case "riddle3":
                    if (inputCommand.equals("time")) {
                        System.out.println("Your answer is correct!"+System.lineSeparator());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //noinspection unused
                        Room room7 = new Room("room7");
                    } else {
                        GameEnding.ending.ending("smeagol");
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
            //noinspection unused
            String inputCommand = input.nextLine();

            Music.musicObject.getDevice().stop();
            Music.musicObject.getDevice().close();
            Item.itemObject.roomId = null;
            Room.game.inventory[0] = null;
            Room.game.inventory[1] = null;
            Room.game.firstRunRoom4 = true;
            Room.game.firstRun1Room6 = true;
            Room.game.firstRun2Room6 = true;
            Room.game.firstRunRoom6_1 = true;
            Menu.menu.menu();
        }
    }

    /**
     *
     * @param locationId String which contains the current locationId.
     */
    public void setLocationId (String locationId){
        if (previousLocationId == null) {
            previousLocationId = locationId;
        }else {
            previousLocationId = currentLocationId;
        }
        currentLocationId = locationId;

        switch (locationId){
            case "room1":
            case "room2":
            case "room3":
            case "room4":
            case "room5":
            case "room6":
                roomId = locationId;
                break;
        }
    }
}