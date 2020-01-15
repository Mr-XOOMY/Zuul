import javax.sound.sampled.Clip;

public class CommandList {

    static CommandList commandListObject = new CommandList();

    public CommandList(){
    }

    public void inputCommand(String command){
        switch (command) {
            case "back":
                commandListObject.back();
                break;
        }
    }

    public void invalid(String[] items, String locationdId){
        System.out.println("You've typed an invalid command...");
        if (!locationdId.equals("menu")) {
            Item.itemObject.drawItems(items);
        }
    }

    public void back(){

        switch (Item.itemObject.getPreviousLocationId()) {
            case "menu":
                Menu.menu.menu();
                break;
        }
    }
}