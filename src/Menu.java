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

        if (Item.itemObject.roomId == null){
            Room room1 = new Room("room1");
        }else {
            switch (Item.itemObject.roomId) {
                case "room1":
                    Room.game.room1();
                    break;
                case "room2":
                    Room.game.room2();
                    break;
                case "room3":
                    Room.game.room3();
                    break;
                case "room4":
                    Room.game.room4();
                    break;
                case "room5":
                    Room.game.room5();
                    break;
                case "room6":
                    Room.game.room6();
                    break;
                case "room7":
                    Room.game.room7();
                    break;
            }
        }
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
                "Theme Song",
                "The Shire",
                "The Misty Mountains Cold",
                "The Adventure Begins 1",
                "The Adventure Begins 2",
                "A Thunder Battle",
                "Riddles in the Dark",
                "Quest Completed",
                "Quest Failed",
                "Smaug",
                "Smeagol",
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