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
        Art.artObject.drawArt(locationId);
        Storyline.storyLineObject.drawStory(locationId);
        System.out.println("The current used audio device is, "+(Audiosettings.audioSettingsObject.deviceNumber+1)+") "+Audiosettings.audioSettingsObject.info.getDescription());
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void music () {
        String[] items = {
                "Sound Check",
                "Theme Song",
                "The Shire",
                "The Misty Mountains Cold",
                "Riddles in the Dark",
                "Back"
        };
        String locationId = "music";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Art.artObject.drawArt(locationId);
        Storyline.storyLineObject.drawStory(locationId);
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }


    public void about () {
        String[] items = {
                "Back"
        };
        String locationId = "about";
        Art.artObject.drawArt(locationId);
        Storyline.storyLineObject.drawStory(locationId);
        Item.itemObject.drawItems(items);
        //Countdown countDown = new Countdown();
        //countDown.timer.schedule(countDown.task, 5000);
        Item.itemObject.inputItems(items, locationId);
    }

    public void quit () {
        String[] items = {
                "Yes",
                "No"
        };
        String locationId = "quit";
        Art.artObject.drawArt(locationId);
        Storyline.storyLineObject.drawStory(locationId);
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
        Art.artObject.drawArt(locationId);
        Item.itemObject.inputItems(items, locationId);
    }
}