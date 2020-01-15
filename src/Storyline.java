import java.io.BufferedReader;
import java.io.FileReader;

public class Storyline {
    // Draws ASCII artwork inside designated locations.
    public static void drawStory(String storyName){
        switch(storyName){
            case "story1":
                drawStory1();
                break;
            case "story2":
                break;
            case "story3":
                break;
            case "story4":
                break;
            case "story5":
                break;
        }
    }

    public static void drawStory1(){
        String storyLocation = "Story/story1.txt";
        printStory(storyLocation);
    }

    public static void drawStory2(){
        String storyLocation = "Story/story2.txt";
        printStory(storyLocation);
    }

    public static void drawStory3(){
        String storyLocation = "Story/story3.txt";
        printStory(storyLocation);
    }

    public static void drawStory4(){
        String storyLocation = "Story/story4.txt";
        printStory(storyLocation);
    }

    public static void drawStory5(){
        String storyLocation = "Story/story5.txt";
        printStory(storyLocation);
    }

    public static void printStory(String storyLocation){
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
            System.out.println("ACII Art could not be printed.");
        }
    }

}
