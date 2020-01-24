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
            case "room4":
                Room.game.room4();
                break;
            case "room5":
                Room.game.room5();
                break;
            case "room6_1":
                Room.game.room6();
                break;
        }
    }
}