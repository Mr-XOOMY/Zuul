/**
 * @author Roland Regtop and Dimitri Kalaïtzakis
 * @version 1.0
 */

public class BilbosQuest {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Audiosettings.audioSettingsObject.reset(0);
        Menu.menu.menu();
    }
}