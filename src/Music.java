import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    static Music music = new Music();
    Clip device;
    static String nowPlaying;

    public Music(){
        Audiosettings playDevice = new Audiosettings();

        try{
            device = AudioSystem.getClip(playDevice.getAudioDevice());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void inputCommand(String command, String[] items) {
        switch (command) {
            case "soundcheck":
                soundCheck();
                System.out.println(nowPlaying);
                Item.drawItems(items);
                break;
            case "mistymountains":
                mistyMountains();
                if (Item.location.getCurrentLocationId().equals("music")) {
                    System.out.println(nowPlaying);
                    Item.drawItems(items);
                }
                break;
            case "back":
                music.getDevice().stop();
                music.getDevice().close();
                CommandList.back();
                break;
        }
    }

    public static void soundCheck () {
        music.getDevice().stop();
        music.getDevice().close();
        String songName = "Sound Check";
        String songLocation = "AudioFiles/soundcheck.wav";
        nowPlaying = playMusic(songLocation, songName);
    }

    public static void mistyMountains (){
        music.getDevice().stop();
        music.getDevice().close();
        String songName = "Misty Mountains";
        String songLocation = "AudioFiles/mistymountains.wav";
        nowPlaying = playMusic(songLocation, songName);
    }

    public static String playMusic (String musicLocation, String songName){
        try{
            File musicPath = new File(musicLocation);

            if(musicPath.exists()){
                AudioInputStream song = AudioSystem.getAudioInputStream(musicPath);
                music.getDevice().open(song);
                music.getDevice().start();
                return "You're playing "+songName+".";
            }else{
                return "Can't play song.";
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return "Can't play song.";
        }
    }

    public Clip getDevice () {
        return this.device;
    }
}
