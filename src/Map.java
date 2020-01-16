import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

    static Map map = new Map();

    public void map(String roomId){
        switch (roomId) {
            case "room1":
                drawRoom1();
                break;
            case "room2":
                drawRoom2();
                break;
        }
    }

    private void drawRoom1(){
        String mapLocation = "Map/room1.txt";
        printMap(mapLocation);
        String[] items = {
                "Back"
        };
        String locationId = "map";
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

    private void drawRoom2(){
        String mapLocation = "Map/room2.txt";
        printMap(mapLocation);
        String[] items = {
                "Back"
        };
        String locationId = "map";
        Item.itemObject.drawItems(items);
        Item.itemObject.inputItems(items, locationId);
    }

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
