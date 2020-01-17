import java.lang.reflect.Array;
import java.security.PKCS12Attribute;

public class Room {

    String[] inventory = new String[2];

    boolean mapRead = false;
    boolean correctItems = false;

    // Checks for items inside the inventory array.

    public boolean checkItems(){
        boolean sword = false;
        boolean ring = false;

        for(String item : inventory){
            if(item.equals("sword")){
                sword = true;
            }
            if(item.equals("ring")){
                ring = true;
            }
        }
        if(sword == true && ring == true){
            return true;
        } else{
            return false;
        }
    }

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
            case "room3":
                room3();
                break;
            case "room4":
                room4();
                break;
            case "room5":
                room5();
                break;
            case "room6":
                room6();
                break;
            case "room7":
                room7();
                break;
        }
    }

    public void room1(){
        String[] items = {
                "Continue"
        };
        String locationId = "room1";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 1");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void inputCommandRoom1 (String command){
        switch(command){
            case "continue":
                Room room2 = new Room("room2");
                break;
        }
    }

    public void room2(){
        String[] items = {
                "Continue"
        };
        String locationId = "room2";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 2");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void inputCommandRoom2(String command){
        switch(command){
            case "continue":
                Room room3 = new Room("room3");
                break;
        }
    }
    public void room3(){
        String[] items = {
                "Yes",
                "No"
        };
        String locationId = "room3";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 3");
        System.out.println(Item.itemObject.roomId);
        Item.itemObject.drawItems(items);
        Countdown countDown = new Countdown();
        countDown.timer.schedule(countDown.task, 5000);
        Item.itemObject.inputItems(items, locationId, countDown);
    }
    public void inputCommandRoom3(String command) {
        switch(command) {
            case "yes":
                Room room4 = new Room("room4");
                break;
            case "no":
               Item.itemObject.roomId = null;
               Menu.menu.menu();
        }
    }

    public void room4(){
        String[] items = {
                "Take Acorn",
                "Persuade Thorin",
                "Do Not Interact"
        };
        String locationId = "room4";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 4");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void inputCommandRoom4(String command){
        Room room5;
        switch(command){
            case "takeacorn":
                System.out.println("You grabbed the acorn. To be sown in your front garden.");
                String[] items = {
                        "Persuade Thorin",
                        "Do Not Interact"
                };
                Item.itemObject.drawItems(items);
                break;
            case "persuadethorin":
                System.out.println("You have successfully persuaded Thorin to show the map to Lord Elrond, Lord of Rivendell, the only one who could translate the Moon runes on it.");
                mapRead = true;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                room5 = new Room("room5");
                break;
            case "donotinteract":
                System.out.println("You chose not to interact, and follwed the company of dwarfs on their quest.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                room5 = new Room("room5");
                break;
        }
    }

    public void room5(){
        String[] items = {
                "Follow Path",
                "Explore Cave"
        };
        String locationId = "room5";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 5");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }
    public void inputCommandRoom5(String command){
        switch(command){
            case "followpath":
                System.out.println("You attempted to follow the path, yet it was in vain. The bones of your miserable corpse were crushed to dust by the Stone Giants.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Item.itemObject.roomId = null;
                Menu.menu.menu();
                break;
            case "explorecave":
                System.out.println("While exploring the cave, you felt the earth disintegrate beneath your feet, and fell deep down into the core of the mountain.");
                Room room6 = new Room("room6");
                break;
        }
    }

    public void room6(){
        String[] items = {
                "continue"
        };
        String locationId = "room6";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 6");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }
    public void inputCommandRoom6(String command){
        switch(command){
            case "continue":
                Room room6 = new Room("room7");
                break;
        }
    }

    public void room7(){
        String[] items = {
                "continue"
        };
        String locationId = "room7";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 7");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }
    public void inputCommandRoom7(String command){
        switch(command){
            case "continue":
                Item.itemObject.roomId = null;
                Menu.menu.menu();
                break;
        }
    }
}