import java.io.BufferedReader;
import java.io.FileReader;

public class Storyline {

    static Storyline storyLineObject = new Storyline();

    // Draws ASCII artwork inside designated locations.
    public void drawStory(String storyName){
        switch(storyName){
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
            case "story1":
                drawStory1();
                break;
            case "story2":
                drawStory2();
                break;
            case "story3":
                drawStory3();
                break;
            case "story4":
                drawStory4();
                break;
            case "story5":
                drawStory5();
                break;
        }
    }

    public void drawSoundSettings(){
        String storyLocation = "Story/soundsettings.txt";
        printStory(storyLocation);
    }

    public void drawMusic(){
        String storyLocation = "Story/music.txt";
        printStory(storyLocation);
    }

    public void drawAbout(){
        String storyLocation = "Story/about.txt";
        printStory(storyLocation);
    }

    public void drawQuit(){
        String storyLocation = "Story/quit.txt";
        printStory(storyLocation);
    }

    public void drawStory1(){
        String storyLocation = "Story/story1.txt";
        printStory(storyLocation);
    }

    public void drawStory2(){
        String storyLocation = "Story/story2.txt";
        printStory(storyLocation);
    }

    public void drawStory3(){
        String storyLocation = "Story/story3.txt";
        printStory(storyLocation);
    }

    public void drawStory4(){
        String storyLocation = "Story/story4.txt";
        printStory(storyLocation);
    }

    public void drawStory5(){
        String storyLocation = "Story/story5.txt";
        printStory(storyLocation);
    }

    public void drawStory6(){
        String storyLocation = "Story/story6.txt";
        printStory(storyLocation);
    }

    public void drawStory7(){
        String storyLocation = "Story/story7.txt";
        printStory(storyLocation);
    }

    public void printStory(String storyLocation){
        try {
            BufferedReader input = new BufferedReader(new FileReader(storyLocation));
            String line = input.readLine();
            while (line != null) {
                System.out.println(line);
                line = input.readLine();
            }
            input.close();
        } catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Storyline could not be printed.");
        }
    }

}
