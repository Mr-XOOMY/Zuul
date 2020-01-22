import java.io.BufferedReader;
import java.io.FileReader;

public class Art {

    static Art artObject = new Art();

    // Draws ASCII artwork inside designated locations.
    public void drawArt(String artName){
        switch(artName){
            case "menu":
                drawMenu();
                break;
            case "soundsettings":
                drawSoundSettings();
                break;
            case "music":
                drawMusic();
                break;
            case "about":
                drawAbout();
                break;
            case "quit":
                drawQuit();
                break;
        }
    }

    public void drawMenu(){
        String artLocation = "Art/menu.txt";
        printArt(artLocation);
    }

    public void drawSoundSettings(){
        String artLocation = "Art/soundsettings.txt";
        printArt(artLocation);
    }

    public void drawMusic(){
        String artLocation = "Art/music.txt";
        printArt(artLocation);
    }

    public void drawAbout(){
        String artLocation = "Art/about.txt";
        printArt(artLocation);
    }

    public void drawQuit(){
        String artLocation = "Art/quit.txt";
        printArt(artLocation);
    }

    public void drawHobbitHole(){
        String artLocation = "Art/hobbithole.txt";
        printArt(artLocation);
    }

    public void drawThorinOakenshield(){
        String artLocation = "Art/thorinoakenshield.txt";
        printArt(artLocation);
    }

    public void drawContract(){
        String artLocation = "Art/contract.txt";
        printArt(artLocation);
    }

    public void drawLordElrond(){
        String artLocation = "Art/lordelrond.txt";
        printArt(artLocation);
    }

    public void drawCave(){
        String artLocation = "Art/cave.txt";
        printArt(artLocation);
    }

    public void drawSmeagol(){
        String artLocation = "Art/smeagol.txt";
        printArt(artLocation);
    }

    public void drawSmaug(){
        String artLocation = "Art/smaug.txt";
        printArt(artLocation);
    }

    public void drawQuestFailed(){
        String artLocation = "Art/questfailed.txt";
        printArt(artLocation);
    }

    public void drawQuestCompleted(){
        String artLocation = "Art/questcompleted.txt";
        printArt(artLocation);
    }

    public void printArt(String artLocation){
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

}
