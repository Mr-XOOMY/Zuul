import java.io.BufferedReader;
import java.io.FileReader;

public class Storyline {

    static Storyline storyLineObject = new Storyline();

    /**
     *
     * @param locationId String which contains a value for the switch case to call the correct method.
     */
    public void drawStory(String locationId){
        switch(locationId){
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
            case "room1":
                drawStory1();
                break;
            case "room2":
                drawStory2();
                break;
            case "room3":
                drawStory3();
                break;
            case "room4":
                drawStory4();
                break;
            case "room5":
                drawStory5();
                break;
            case "room6_1":
                drawStory6();
                break;
            case "room7":
                drawStory7();
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

    public void drawEndingRoom3(){
        String storyLocation = "Story/endingcountdown.txt";
        printStory(storyLocation);
    }

    public void drawEndingCountDown(){
        String storyLocation = "Story/endingcountdown.txt";
        printStory(storyLocation);
    }

    public void drawEndingRoom5(){
        String storyLocation = "Story/endingroom5.txt";
        printStory(storyLocation);
    }

    public void drawEndingSmeagol(){
        String storyLocation = "Story/endingsmeagol.txt";
        printStory(storyLocation);
    }

    public void drawEndingElrond(){
        String storyLocation = "Story/endingelrond.txt";
        printStory(storyLocation);
    }

    public void drawEndingSword(){
        String storyLocation = "Story/endingsword.txt";
        printStory(storyLocation);
    }

    public void drawEndingRing(){
        String storyLocation = "Story/endingring.txt";
        printStory(storyLocation);
    }

    public void drawEndingCompleted(){
        String storyLocation = "Story/endingcompleted.txt";
        printStory(storyLocation);
    }

    /**
     *
     * @param storyLocation String with the location of the story.txt file, which is being read by a BufferedReader and prints it contents line for line to the terminal.
     */
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
