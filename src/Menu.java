public class Menu {

    public static void inputCommand (String command) {
        switch (command) {
            case "play":
                play();
                break;
            case "soundsettings":
                soundSettings();
                break;
            case "music":
                music();
                break;
            case "about":
                about();
                break;
            case "quit":
                quit();
                break;
        }
    }

    public static void play () {
        String[] items = {
                "A",
                "B",
                "C",
                "D"
        };
        String locationId = "game";
        System.out.println("You've started a game!");
        Item.drawItems(items);
        Item.inputItems(items, locationId);
    }

    public static void soundSettings () {
        String[] items = {
                "Change",
                "Reset",
                "Back"
        };
        String locationId = "soundsettings";
        System.out.println("WARNING! Only change audio device if needed. " +
                System.lineSeparator() +
                "Sometimes Linux wont chnage the audio output from the default output to another when switched and could be forced with this setting."+
                System.lineSeparator() +
                "Windows should not need this.");
        Item.drawItems(items);
        Item.inputItems(items, locationId);
    }

    public static void music () {
        String[] items = {
                "Sound Check",
                "Misty Mountains",
                "Back"
        };
        String locationId = "music";
        System.out.println("You choose to play music.");
        Item.drawItems(items);
        Item.inputItems(items, locationId);
    }


    public static void about () {
        String[] items = {
                "Back"
        };
        String locationId = "about";
        System.out.println("This game has been developed by Roland Regtop and Dimitri (Achternaam)");
        Item.drawItems(items);
        Item.inputItems(items, locationId);
    }

    public static void quit () {
        String[] items = {
                "Yes",
                "No"
        };
        String locationId = "quit";
        System.out.println("Are you sure you want to quit?");
        Item.drawItems(items);
        Item.inputItems(items, locationId);
    }
}
