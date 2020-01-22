public class GameEnding {

    static GameEnding ending = new GameEnding();

    public void GameEnding (String ending) {
        switch (ending) {
            case "room3":
                endingRoom3();
                break;
            case "countdown":
                endingCountDown();
                break;
            case "room5":
                endingRoom5();
                break;
            case "elrond":
                endingElrond();
                break;
            case "sword":
                endingSword();
                break;
            case "ring":
                endingRing();
                break;
            case "completed":
                endingCompleted();
                break;
        }
    }

    private void endingRoom3 () {
        System.out.println("You are a coward and you should be ashamed of pulling back to your hobbit hole!");
        System.out.println("Press Enter to continue");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingCountDown () {
        System.out.println("You were to late with your decision and the dwarves are long long gone. You should have joined them earlier coward!");
        System.out.println("Press Enter to continue");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingRoom5 () {
        System.out.println("You attempted to follow the path, yet it was in vain. The bones of your miserable corpse were crushed to dust by the Stone Giants.");
        System.out.println("Press Enter to continue");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingSmeagol () {
        System.out.println("You were feasted on by smeagol because you failed to correctly answer the riddles!.");
        System.out.println("Press Enter to continue");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingElrond () {
        System.out.println("You didn't let Lord Elrond read the map so you could not find the secret entrance into Erobor. Quest FAILED!");
        System.out.println("Press Enter to continue");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingSword () {
        System.out.println("You dont have a sword to kill Smaug. Quest FAILED!");
        System.out.println("Press Enter to continue");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingRing () {
        System.out.println("You could not get undetected around Smaug, if you only had something to make you invisible. Quest FAILED!");
        System.out.println("Press Enter to continue");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingCompleted () {
        System.out.println("You killed the dragon Smaug en retrieved the Arkenstone. You've completed the quest.");
        System.out.println("Press Enter to continue");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }
}
