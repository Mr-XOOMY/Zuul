import javax.sound.sampled.Clip;

public class CommandList {

    public static void inputCommand(String command){
        switch (command) {
            case "menu":
                menu();
                break;
            case "back":
                back();
                break;
        }
    }

    public static void invalid(String[] items){
        System.out.println("You've typed an invalid command...");
        Item.drawItems(items);
    }

    public static void menu(){
        String[] items = {
                "Play",
                "Sound settings",
                "Music",
                "About",
                "Quit"
        };
        String locationId = "menu";
        Audiosettings.reset(0);
        Music.themeSong();
        Music.music.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
        Art.drawArt(locationId);
        //Storyline.drawStory("menu");
        try {
            Countdown.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Item.drawItems(items);
        Item.inputItems(items, locationId);
    }

    public static void back(){

        switch (Item.location.getPreviousLocationId()) {
            case "menu":
                CommandList.menu();
                break;
        }
    }
}