import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Line;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import java.util.ArrayList;
import java.util.Scanner;

public class Audiosettings {

    int deviceNumber = 0;
    Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
    Mixer.Info info;
    ArrayList<Mixer.Info> audioDevice = new ArrayList<>();
    static Audiosettings audioSettingsObject = new Audiosettings();

    public Audiosettings(){
        for(Mixer.Info info : mixerInfo) {
            Mixer mixer = AudioSystem.getMixer(info);
            Line.Info lineInfo = new Line.Info(SourceDataLine.class);
            if(mixer.isLineSupported(lineInfo)){
                audioDevice.add(info);
            }
        }
        info = audioDevice.get(deviceNumber);
    }

    /**
     *
     * @param command String with the current command given by the user.
     * @param items Array[] with the possible commands a user can give.
     */
    public void inputCommand(String command, String[] items){
        switch (command) {
            case "change":
                audioSettingsObject.change();
                if (Item.itemObject.currentLocationId.equals("soundsettings")) {
                    System.out.println("The current used audio device is, "+(audioSettingsObject.deviceNumber+1)+") "+audioSettingsObject.info.getDescription());
                }
                Item.itemObject.drawItems(items);
                break;
            case "reset":
                audioSettingsObject.reset();
                if (Item.itemObject.currentLocationId.equals("soundsettings")) {
                    System.out.println("The current used audio device is, "+(audioSettingsObject.deviceNumber+1)+") "+audioSettingsObject.info.getDescription());
                }
                Item.itemObject.drawItems(items);
                break;
            case "playtestsound":
                Music.musicObject.soundCheck();
                break;
            case "back":
                Music.musicObject.getDevice().stop();
                Music.musicObject.getDevice().close();
                CommandList.commandListObject.back();
                break;
        }
    }

    public void change(){
        System.out.println("These are all the audio playback devices."+System.lineSeparator());
        audioSettingsObject.setAudioDevice();
        Music.musicObject.soundCheck();
        System.out.println("When you hear the test audio track, then your sound is setup correctly."+System.lineSeparator()+"" +
                "When you don't hear the test audio track, please check if you have turned up your volume and please try the setup again or reset the changes to the default audio device."+System.lineSeparator());
    }

    public void reset(){
        audioSettingsObject.setAudioDevice(0);
        Music.musicObject.soundCheck();
        System.out.println("When you hear the test audio track, then your sound is setup correctly."+System.lineSeparator()+"" +
                "When you don't hear the test audio track, please check if you have turned up your volume and please try the setup again or reset the changes to the default audio device."+System.lineSeparator());
    }

    /**
     *
     * @param deviceNumber A number which correspondents to an audiodevice.
     */
    public void reset(int deviceNumber){
        audioSettingsObject.setAudioDevice(deviceNumber);
    }

    public void setAudioDevice(){
        deviceNumber = setDeviceNumber();
        info = audioDevice.get(deviceNumber);
        System.out.println("You have chosen audio device, "+(deviceNumber+1)+") "+info.getDescription()+System.lineSeparator());
    }

    /**
     *
     * @param deviceNumber A number which correspondents to an audiodevice.
     */
    public void setAudioDevice(int deviceNumber){
        info = audioDevice.get(deviceNumber);
    }

    public int setDeviceNumber(){
        int count = 1;

        for(Mixer.Info info : audioDevice) {
            System.out.println(count+") "+info.getDescription());
            count++;
        }

        System.out.println();
        int amount = audioDevice.size();
        int number = 0;

        while (number < 1 || number > amount){
            Scanner input = new Scanner(System.in);  // Create a Scanner object
            System.out.print("> Enter audio device number: ");

            if (input.hasNextInt()){
                number = input.nextInt();  // Read user input
            }
        }

        return (number - 1);  // return index value (input number - 1)
    }

    public Mixer.Info getAudioDevice(){
        return info;
    }
}
