public class BilbosQuest {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Audiosettings.audioSettingsObject.reset(0);
        Menu.menu.menu();
    }
}