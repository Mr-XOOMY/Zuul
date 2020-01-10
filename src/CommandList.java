public class CommandList {

    public static void inputCommand(String command){
        switch (command) {
            case "menu":
                menu();
                break;
            case "play":
                play();
                break;
            case "quit":
                quit();
                break;
            case "about":
                about();
                break;
            case "soundsettings":
                soundSettings();
                break;
            case "a":
                a();
                break;
            case "b":
                b();
                break;
            case "c":
                c();
                break;
            case "d":
                d();
                break;
        }
    }

    public static void invalid(String[] items){
        System.out.println("You've typed an invalid command...");
        Item.drawItems(items);
    }

    public static void menu(){
        String[] items = {"Play", "Sound settings", "About", "Quit"};

        //draw picture
        //play audio
        Item.drawItems(items);
        Item.inputItems(items);
    }

    public static void play(){
        String[] items = {"A", "B", "C", "D"};
        System.out.println("You've started a game!");
        Item.drawItems(items);
        Item.inputItems(items);
    }

    public static void quit(){
        System.out.println("You've exited this program'");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void about(){
        System.out.println("This is the about page");
    }

    public static void soundSettings(){
        System.out.println("These are the sound settings");
    }

    public static void a(){
        System.out.println("You've chosen option A");
    }

    public static void b(){
        System.out.println("You've chosen option B");
    }

    public static void c(){
        System.out.println("You've chosen option C");
    }

    public static void d(){
        System.out.println("You've chosen option D");
    }
}