import javax.sound.sampled.Clip;

public class Menu {

    static Menu menu = new Menu();

    public Menu(){

    }

    public void inputCommand (String command) {
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

    public void play () {
        String[] items = {
                "A",
                "B",
                "C",
                "D"
        };
        String locationId = "game";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("You've started a game!");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void soundSettings () {
        String[] items = {
                "Change",
                "Reset",
                "Play test sound",
                "Back"
        };
        String locationId = "soundsettings";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Art.drawArt(locationId);
        System.out.println("WARNING! Only change audio device if needed. " +
                System.lineSeparator() +
                "Sometimes Linux wont chnage the audio output from the default output to another when switched and could be forced with this setting."+
                System.lineSeparator() +
                "Windows should not need this."+System.lineSeparator());
        System.out.println("The current used audio device is, "+(Audiosettings.audioSettingsObject.deviceNumber+1)+") "+Audiosettings.audioSettingsObject.info.getDescription());
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void music () {
        String[] items = {
                "Sound Check",
                "Theme Song",
                "Misty Mountains",
                "Back"
        };
        String locationId = "music";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Art.drawArt(locationId);
        System.out.println("You choose to play music.");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }


    public void about () {
        String[] items = {
                "Back"
        };
        String locationId = "about";
        Art.drawArt(locationId);
        System.out.println("This game has been developed by Roland Regtop and Dimitri Kalaïtzakis.");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void quit () {
        String[] items = {
                "Yes",
                "No"
        };
        String locationId = "quit";
        Art.drawArt(locationId);
        System.out.println("Are you sure you want to quit?");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void menu(){
        String[] items = {
                "Play",
                "Sound settings",
                "Music",
                "About",
                "Quit"
        };
        String locationId = "menu";
        if (!Music.musicObject.getDevice().isRunning()) {
            Music.musicObject.themeSong();
            Music.musicObject.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
        }
        Art.drawArt(locationId);
        Item.itemObject.inputItems(items, locationId);
    }
}
