public class Quit {

    public static void inputCommand(String command) {
        switch (command) {
            case "yes":
                yes();
                break;
            case "no":
                CommandList.back();
                break;
        }
    }

    public static void yes () {
        System.out.println(System.lineSeparator() + "Goodbye");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
