import java.io.BufferedReader;
import java.io.FileReader;

public class Storyline {
    // Draws ASCII artwork inside designated locations.
    public static void drawStory(String storyName){
        switch(storyName){
            case "menu":

                break;
            case "soundsettings":

                break;
            case "music":
                break;
            case "about":
                break;
            case "quit":
                break;


        }
    }
/*
    public static void drawMenu(){
        String artLocation = "Art/menu.txt";
        printArt(artLocation);
    }

    public static void drawSoundSettings(){
        String artLocation = "Art/soundsettings.txt";
        printArt(artLocation);
    }

    public static void drawMusic(){
        String artLocation = "Art/music.txt";
        printArt(artLocation);
    }

    public static void drawAbout(){
        String artLocation = "Art/about.txt";
        printArt(artLocation);
    }

    public static void drawQuit(){
        String artLocation = "Art/quit.txt";
        printArt(artLocation);
    }

    public static void printArt(String artLocation){
        try {
            BufferedReader input = new BufferedReader(new FileReader(artLocation));
            String line = input.readLine();
            while (line != null) {
                System.out.println(line);
                line = input.readLine();
            }
            input.close();
        } catch(Exception ex){
            ex.printStackTrace();
            System.out.println("ACII Art could not be printed.");
        }
    }
*/
}
