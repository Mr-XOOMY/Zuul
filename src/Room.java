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
                "continue"
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
                "continue"
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
                "yes",
                "no"
        };
        String locationId = "room3";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 3");
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
                "continue"
        };
        String locationId = "room4";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 4");
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void inputCommandRoom4(String command){
        switch(command){
            case "continue":
            Room room5 = new Room("room5");
            break;
        }
    }

    public void room5(){
        String[] items = {
                "continue"
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
            case "continue":
                Room room6 = new Room("room6");
                break;
        }
    }

    public void room6(){
        String[] items = {
                "continue"
        };
        String locationId = "room5";
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
        String locationId = "room5";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        System.out.println("Entered Room 6");
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