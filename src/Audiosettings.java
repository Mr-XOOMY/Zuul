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
    static Audiosettings device = new Audiosettings();

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

    public static void inputCommand(String command, String[] items){
        switch (command) {
            case "change":
                change(items);
                break;
            case "reset":
                reset(items);
                break;
            case "back":
                Music.music.getDevice().stop();
                Music.music.getDevice().close();
                CommandList.back();
                break;
        }
    }

    public static void change(String[] items){
        device.setAudioDevice();
        Music.soundCheck();
        System.out.println("When you hear the test audio track, then your sound is setup correctly."+System.lineSeparator()+"" +
                "When you don't hear the test audio track, please check if you have turned up your volume and please try the setup again or reset the changes to the default audio device.");
        Item.drawItems(items);
    }

    public static void reset(String[] items){
        device.setAudioDevice(0);
        Music.soundCheck();
        System.out.println("When you hear the test audio track, then your sound is setup correctly."+System.lineSeparator()+"" +
                "When you don't hear the test audio track, please check if you have turned up your volume and please try the setup again or reset the changes to the default audio device.");
        Item.drawItems(items);
    }

    public void setAudioDevice(){
        System.out.println("The current used audio device is, "+(deviceNumber+1)+") "+info.getDescription()+System.lineSeparator());
        deviceNumber = setDeviceNumber();
        info = audioDevice.get(deviceNumber);
        System.out.println("You have chosen audio device, "+(deviceNumber+1)+") "+info.getDescription());
    }

    public void setAudioDevice(int deviceNumber){
        info = audioDevice.get(deviceNumber);
        System.out.println("The audio device has been reset to default, "+(deviceNumber+1)+") "+info.getDescription());
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
            System.out.print("Enter audio device number: ");

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
