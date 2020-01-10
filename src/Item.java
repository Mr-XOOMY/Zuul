import java.util.Scanner;

public class Item {

    public static void drawItems(String[] items){
        for (String item : items) {
            System.out.println(item);
        }
    }

    public static void inputItems(String[] items){
        boolean run = true;
        while (run){

            Scanner input = new Scanner(System.in);  // Create a Scanner object
            System.out.print("> ");
            String inputCommand = input.nextLine();
            inputCommand = inputCommand.replaceAll("\\s+", "").toLowerCase();

            boolean command = false;
            for (String item : items) {
                item = item.replaceAll("\\s", "").toLowerCase();
                if (inputCommand.equals(item)){
                    command = true;
                    break;
                }
            }

            if (command){
                if (inputCommand.equals("quit")){
                    run = false;
                    CommandList.inputCommand("quit");
                }else {
                    CommandList.inputCommand(inputCommand);
                }
            }else if(inputCommand.equals("menu")){
                CommandList.inputCommand(inputCommand);
            }else{
                CommandList.invalid(items);
            }
        }
    }
}