public class Quit {

    static Quit quitObject = new Quit();

    public void inputCommand(String command) {
        switch (command) {
            case "yes":
                yes();
                break;
            case "no":
                CommandList.commandListObject.back();
                break;
        }
    }

    public void yes () {
        System.out.println("Goodbye");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
