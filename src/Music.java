import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    static Music musicObject = new Music();
    Clip device;
    String nowPlaying;

    public Music(){
        //Audiosettings playDevice = new Audiosettings();

        try{
            device = AudioSystem.getClip(Audiosettings.audioSettingsObject.getAudioDevice());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void inputCommand(String command, String[] items) {
        switch (command) {
            case "soundcheck":
                soundCheck();
                System.out.println(nowPlaying);
                Item.itemObject.drawItems(items);
                break;
            case "themesong":
                themeSong();
                if (Item.itemObject.getCurrentLocationId().equals("music")) {
                    System.out.println(nowPlaying);
                    Item.itemObject.drawItems(items);
                }
                break;
            case "mistymountains":
                mistyMountains();
                if (Item.itemObject.getCurrentLocationId().equals("music")) {
                    System.out.println(nowPlaying);
                    Item.itemObject.drawItems(items);
                }
                break;
            case "back":
                getDevice().stop();
                getDevice().close();
                CommandList.commandListObject.back();
                break;
        }
    }

    public void soundCheck () {
        getDevice().stop();
        getDevice().close();
        String songName = "Sound Check";
        String songLocation = "AudioFiles/soundcheck.wav";
        nowPlaying = playMusic(songLocation, songName);
    }

    public void themeSong (){
        getDevice().stop();
        getDevice().close();
        String songName = "Theme Song";
        String songLocation = "AudioFiles/themesong.wav";
        nowPlaying = playMusic(songLocation, songName);
    }

    public void mistyMountains (){
        getDevice().stop();
        getDevice().close();
        String songName = "Misty Mountains";
        String songLocation = "AudioFiles/mistymountains.wav";
        nowPlaying = playMusic(songLocation, songName);
    }

    public String playMusic (String musicLocation, String songName){
        try{
            File musicPath = new File(musicLocation);

            if(musicPath.exists()){
                AudioInputStream song = AudioSystem.getAudioInputStream(musicPath);
                getDevice().open(song);
                getDevice().start();
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
