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
        //Art.drawArt("menu");
        //Storyline.drawStory("menu");
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