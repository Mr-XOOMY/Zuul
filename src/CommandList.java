public class CommandList {

    static CommandList commandListObject = new CommandList();

    public CommandList(){
    }

    public void inputCommand(String command, String roomId){
        switch (command) {
            case "menu":
                Menu.menu.menu();
                break;
            case "map":
                Map.map.map(roomId);
                break;
            case "back":
                back();
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

        switch (Item.itemObject.previousLocationId) {
            case "menu":
                Menu.menu.menu();
                break;
            case "room1":
                Room.game.room1();
                break;
            case "room2":
                Room.game.room2();
                break;
        }
    }
}