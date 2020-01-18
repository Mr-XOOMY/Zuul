import javax.sound.sampled.Clip;
import java.lang.reflect.Array;
import java.security.PKCS12Attribute;

public class Room {

    String[] inventory = new String[2];
    boolean mapRead = false;
    boolean correctItems = false;
    boolean firstrun = true;
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

    // Checks for items inside the inventory array.

    public boolean checkItems(){
        boolean sword = false;
        boolean magicalring = false;

        for(String item : inventory){
            if(item.equals("sword")){
                sword = true;
            }
            if(item.equals("magicalring")){
                magicalring = true;
            }
        }
        if(sword && magicalring){
            return true;
        } else{
            return false;
        }
    }

    public boolean getFirstRun(){
        return firstrun;
    }

    public void room1(){
        String[] items = {
                "Continue"
        };
        String locationId = "room1";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.theShire();
        Music.musicObject.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
        Art.artObject.drawHobbitHole();
        Storyline.storyLineObject.drawStory1();
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
        Music.musicObject.theMistyMountainsCold();
        Music.musicObject.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
        // ASCII art of dwarf
        Art.artObject.drawHobbitHole();
        //Storyline.storyLineObject.drawStory2();
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
        Music.musicObject.theAdventureBegins1();
        // ASCII art of contract
        //Art.artObject.drawHobbitHole();
        //Storyline.storyLineObject.drawStory3();
        Item.itemObject.drawItems(items);
        Countdown countDown = new Countdown();
        countDown.countDown(countDown, 5000);
        Item.itemObject.inputItems(items, locationId, countDown);
    }
    public void inputCommandRoom3(String command) {
        switch(command) {
            case "yes":
                Room room4 = new Room("room4");
                break;
            case "no":
                // use game-over function
                Music.musicObject.getDevice().stop();
                Music.musicObject.getDevice().close();
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
        Music.musicObject.theAdventureBegins2();
        // Gandalf geeft zwaard dus die word toegevoegd aan de inventory
        inventory[0] = "sword";
        // ASCI art of elf
        //Art.artObject.drawHobbitHole();
        //Storyline.storyLineObject.drawStory4();
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void inputCommandRoom4(String command){
        Room room5;
        switch(command){
            case "takeacorn":
                System.out.println("You grabbed the acorn to be sown in your front garden.");
                inventory[1] = "acorn";
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
                System.out.println("You chose not to interact, and followed the company of dwarves on their quest.");
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
        // create song
        // ASCII art of mointains/stonegiant
        //Art.artObject.drawHobbitHole();
        //Storyline.storyLineObject.drawStory5();
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
                // use game-over function
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
                "Inspect Shimmering",
                "Inspect Sound"
        };
        String locationId = "room6_1";
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.riddlesInTheDark();
        Art.artObject.drawSmeagol();
        Storyline.storyLineObject.drawStory6();
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }
    public void inputCommandRoom6_1 (String command, boolean firstrun){

        if (firstrun){
            switch(command){
                case "inspectshimmering":
                    System.out.println("You found a magical ring and put it into your pocket.");
                    //check array inventory full
                    if () {
                        System.out.println("You have no more pockets to put stuff. Which item do you want to drop?");
                        String[] items = {
                                "Sword",
                                "Acorn",
                                "Magical Ring"
                        };
                        Item.itemObject.drawItems(items);
                        String locationId = "room6_2";
                        Item.itemObject.inputItems(items, locationId);
                    }else {
                        inventory[1] = "magicalring";
                        inputCommandRoom6_1(false);
                    }
                    break;
                case "inspectsound":
                    //initiate riddle function
                    Room room6 = new Room("room7");
                    break;
            }
        }else {
            //initiate riddle function
            Room room6 = new Room("room7");
        }
    }

    public void inputCommandRoom6_2(String command){
        firstrun = false;
        switch (command){
            case "sword":
                inventory[0] = "magicalring";
                String[] items = {
                        "Inspect Sound"
                };
                String locationId = "room6_1"
                Item.itemObject.drawItems(items);
                Item.itemObject.inputItems(items, locationId);
                break;
            case "acorn":
                inventory[1] = "magicalring";
                String[] items = {
                        "Inspect Sound"
                };
                String locationId = "room6_1"
                Item.itemObject.drawItems(items);
                Item.itemObject.inputItems(items, locationId);
                break;
            case "magicalring":
                String[] items = {
                        "Inspect Sound"
                };
                String locationId = "room6_1"
                Item.itemObject.drawItems(items);
                Item.itemObject.inputItems(items, locationId);
                break;
        }
    }

    public void inputCommandRoom6_3(String command){
        switch (command){
            case "inspectsound":
                inventory[0] = "magicalring";
                inputCommandRoom6_1(false);
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
        Music.musicObject.riddlesInTheDark();
        //ASCII art of Erebor
        //Art.artObject.drawSmeagol();
        //Storyline.storyLineObject.drawStory7();
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