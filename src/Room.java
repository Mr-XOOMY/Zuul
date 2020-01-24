import javax.sound.sampled.Clip;

public class Room {

    String[] inventory = new String[2];
    boolean mapRead = false;
    boolean sword = false;
    boolean magicalring = false;
    boolean firstRunRoom4 = true;
    boolean firstRun1Room6 = true;
    boolean firstRun2Room6 = true;
    boolean firstRunRoom6_1 = true;
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

    public void checkItems(){

        for(String item : inventory){
            if (item != null) {
                if(item.equals("sword")){
                    sword = true;
                }else if (item.equals("magicalring")){
                    magicalring = true;
                }
            }
        }
    }

    public boolean getFirstRunRoom4(){
        return firstRunRoom4;
    }

    public boolean getFirstRun1Room6(){
        return firstRun1Room6;
    }

    public boolean getFirstRun2Room6(){
        return firstRun2Room6;
    }

    public boolean getFirstRunRoom6_1(){
        return firstRunRoom6_1;
    }

    public void room1(){
        String[] items = {
                "Continue"
        };
        String locationId = "room1";
        Art.artObject.drawHobbitHole();
        Storyline.storyLineObject.drawStory1();
        if (!Music.musicObject.getDevice().isRunning()) {
            Music.musicObject.theShire();
            Music.musicObject.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
        }
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void inputCommandRoom1 (String command){
        if ("continue".equals(command)) {
            Room room2 = new Room("room2");
        }
    }

    public void room2(){
        String[] items = {
                "Continue"
        };
        String locationId = "room2";
        Art.artObject.drawThorinOakenshield();
        Storyline.storyLineObject.drawStory2();
        if (!Music.musicObject.getDevice().isRunning()) {
            Music.musicObject.theMistyMountainsCold();
            Music.musicObject.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
        }
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    public void inputCommandRoom2(String command){
        if ("continue".equals(command)) {
            Room room3 = new Room("room3");
        }
    }
    public void room3(){
        String[] items = {
                "Yes",
                "No"
        };
        String locationId = "room3";
        Art.artObject.drawContract();
        Storyline.storyLineObject.drawStory3();
        if (!Music.musicObject.getDevice().isRunning()) {
            Music.musicObject.theAdventureBegins1();
            Music.musicObject.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
        }
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }
    public void inputCommandRoom3(String command) {
        switch(command) {
            case "yes":
                Room room4 = new Room("room4");
                break;
            case "no":
                GameEnding.ending.ending("room3");
        }
    }

    public void room4(){

        if(getFirstRunRoom4()){
            String[] items = {
                    "Take Acorn",
                    "Persuade Thorin",
                    "Do Not Interact"
            };
            String locationId = "room4";
            Art.artObject.drawLordElrond();
            Storyline.storyLineObject.drawStory4();
            if (!Music.musicObject.getDevice().isRunning()) {
                Music.musicObject.theAdventureBegins2();
                Music.musicObject.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
            }
            game.inventory[0] = "sword";
            Item.itemObject.drawItems(items);
            Item.itemObject.inputItems(items, locationId);
        }
        String[] items = {
                "Persuade Thorin",
                "Do Not Interact"
        };
        String locationId = "room4";
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);

    }

    public void inputCommandRoom4(String command){
        game.firstRunRoom4 = false;
        Room room5;
        switch(command){
            case "takeacorn":
                System.out.println("You grabbed the acorn to be sown in your front garden.");
                game.inventory[1] = "acorn";
                String[] items = {
                        "Persuade Thorin",
                        "Do Not Interact"
                };
                String locationId = "room4";
                Item.itemObject.drawItems(items);
                Item.itemObject.inputItems(items, locationId);
                break;
            case "persuadethorin":
                System.out.println("You have successfully persuaded Thorin to show the map to Lord Elrond, Lord of Rivendell, the only one who could translate the Moon runes on it.");
                game.mapRead = true;
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Music.musicObject.getDevice().stop();
                Music.musicObject.getDevice().close();
                room5 = new Room("room5");
                break;
            case "donotinteract":
                System.out.println("You chose not to interact, and followed the company of dwarves on their quest.");
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Music.musicObject.getDevice().stop();
                Music.musicObject.getDevice().close();
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
        Art.artObject.drawCave();
        Storyline.storyLineObject.drawStory5();
        if (!Music.musicObject.getDevice().isRunning()) {
            Music.musicObject.aThunderBattle();
            Music.musicObject.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
        }
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }
    public void inputCommandRoom5(String command){
        switch(command){
            case "followpath":
                GameEnding.ending.ending("room5");
                break;
            case "explorecave":
                System.out.println("While exploring the cave, you felt the earth disintegrate beneath your feet, and fell deep down into the core of the mountain.");
                Room room6 = new Room("room6");
                break;
        }
    }

    public void room6(){

        if(game.getFirstRun1Room6()){
            String[] items = {
                    "Inspect Shimmering",
                    "Inspect Sound"
            };
            String locationId = "room6_1";
            Art.artObject.drawSmeagol();
            Storyline.storyLineObject.drawStory6();

            if(game.getFirstRun2Room6()){
                Music.musicObject.getDevice().stop();
                Music.musicObject.getDevice().close();
                Music.musicObject.smeagol();
                try {
                    Thread.sleep(3100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                game.firstRun2Room6 = false;
            }

            if (!Music.musicObject.getDevice().isRunning()) {
                Music.musicObject.riddlesInTheDark();
                Music.musicObject.getDevice().loop(Clip.LOOP_CONTINUOUSLY);
            }
            Item.itemObject.drawItems(items);
            Item.itemObject.inputItems(items, locationId);
        } else {
            String[] items = {
                    "Inspect Sound"
            };
            String locationId = "room6_1";
            Item.itemObject.drawItems(items);
            Item.itemObject.inputItems(items, locationId);
        }

    }
    public void inputCommandRoom6_1 (String command){
        game.firstRun1Room6 = false;
        if (game.getFirstRunRoom6_1()){
            switch(command){
                case "inspectshimmering":
                    if (inventory[1] != null) {
                        System.out.println("You found a magical ring but you have no more pockets to spare to put stuff. Which item do you want to drop?");
                        String[] items = {
                                "Sword",
                                "Acorn",
                                "Magical Ring"
                        };
                        Item.itemObject.drawItems(items);
                        String locationId = "room6_2";
                        Item.itemObject.inputItems(items, locationId);
                    }else {
                        System.out.println("You found a magical ring and put it into your pocket.");
                        game.inventory[1] = "magicalring";
                        String[] items = {
                                "Inspect Sound"
                        };
                        String locationId = "room6_1";
                        Item.itemObject.drawItems(items);
                        Item.itemObject.inputItems(items, locationId);
                    }
                    break;
                case "inspectsound":
                    Riddle.riddle.riddle1();
                    break;
            }
        }else {
            Riddle.riddle.riddle1();
        }
    }

    public void inputCommandRoom6_2(String command){
        game.firstRunRoom6_1 = false;
        String[] items = {
                "Inspect Sound"
        };
        String locationId = "room6_1";
        switch (command){
            case "sword":
                game.inventory[0] = "magicalring";
                Item.itemObject.drawItems(items);
                Item.itemObject.inputItems(items, locationId);
                break;
            case "acorn":
                game.inventory[1] = "magicalring";
                Item.itemObject.drawItems(items);
                Item.itemObject.inputItems(items, locationId);
                break;
            case "magicalring":
                Item.itemObject.drawItems(items);
                Item.itemObject.inputItems(items, locationId);
                break;
        }
    }

    public void room7(){
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Storyline.storyLineObject.drawStory7();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Art.artObject.drawSmaug();
        Music.musicObject.smaug();
        try {
            Thread.sleep(17000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        game.checkItems();
        if (game.mapRead && game.sword && game.magicalring) {
            GameEnding.ending.ending("completed");
        }else if (!game.mapRead) {
            GameEnding.ending.ending("elrond");
        } else if (!game.sword) {
            GameEnding.ending.ending("sword");
        }else {
            GameEnding.ending.ending("ring");
        }

    }
}