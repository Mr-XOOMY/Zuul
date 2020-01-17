public class Room {

    static Room game = new Room();

    public Room(){
    }

    public Room(String roomId){

        switch (roomId) {
            case "room1":
                room1();
                break;
            case "room2":
                room2();
                break;
        }
    }

    public void room1(){
        String[] items = {
                "A",
                "B",
        };
        String locationId = "room1";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("This is Room1");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void inputCommandRoom1 (String command){
        switch(command){
            case "a":
                Room room2 = new Room("room2");
                break;
            case "b":
                Menu.menu.menu();
                break;
        }
    }

    public void room2(){
        String[] items = {
                "A",
                "B",
        };
        String locationId = "room2";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("This is room2");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void inputCommandRoom2(String command){
        switch(command){
            case "a":
                Menu.menu.menu();
                break;
            case "b":
                Item.itemObject.roomId = null;
                Menu.menu.menu();
                break;
        }
    }
}
