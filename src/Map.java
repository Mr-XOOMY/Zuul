import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

    static Map map = new Map();

    /**
     *
     * @param roomId String which contains a value for the switch case to call the correct method.
     */
    public void map(String roomId){
        switch (roomId) {
            case "room1":
            case "room2":
                drawMap1();
                break;
            case "room4":
                drawMap2();
                break;
            case "room5":
            case "room6_1":
                drawMap3();
                break;
        }
    }

    private void drawMap1(){
        String mapLocation = "Map/map1.txt";
        printMap(mapLocation);
        String[] items = {
                "Back"
        };
        String locationId = "map";
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    private void drawMap2(){
        String mapLocation = "Map/map2.txt";
        printMap(mapLocation);
        String[] items = {
                "Back"
        };
        String locationId = "map";
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    private void drawMap3(){
        String mapLocation = "Map/map3.txt";
        printMap(mapLocation);
        String[] items = {
                "Back"
        };
        String locationId = "map";
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    /**
     *
     * @param mapLocation String with the location of the map.txt file, which is being read by a BufferedReader and prints it contents line for line to the terminal.
     */
    private void printMap (String mapLocation) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(mapLocation));
            String line = input.readLine();
            while (line != null) {
                System.out.println(line);
                line = input.readLine();
            }
            input.close();
        } catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Map could not be printed.");
        }
    }
}
