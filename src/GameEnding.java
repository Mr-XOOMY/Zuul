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
            case "riddle":
                endingRiddle();
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
        countDown.timer.cancel();
        System.out.println("You are a coward and you should be ashamed of pulling back to your hobbit hole!");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Countdown endingRoom3 = new Countdown();
        endingRoom3.countDown(endingRoom3, 26000);
        Item.itemObject.inputItems(endingRoom3);
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Item.itemObject.roomId = null;
        Menu.menu.menu();
    }

    private void endingCountDown () {
        System.out.println("You were to late with your decision and the dwarves are long long gone. You should have joined them earlier coward!");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Countdown endingCountDown = new Countdown();
        endingCountDown.countDown(endingCountDown, 26000);
        Item.itemObject.inputItems(endingCountDown);
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Item.itemObject.roomId = null;
        Menu.menu.menu();
    }

    private void endingRoom5 () {
        System.out.println("You attempted to follow the path, yet it was in vain. The bones of your miserable corpse were crushed to dust by the Stone Giants.");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Countdown endingRoom5 = new Countdown();
        endingRoom5.countDown(endingRoom5, 26000);
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Item.itemObject.roomId = null;
        Menu.menu.menu();
    }

    private void endingRiddle () {
        System.out.println("You attempted to follow the path, yet it was in vain. The bones of your miserable corpse were crushed to dust by the Stone Giants.");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Countdown endingRiddle = new Countdown();
        endingRiddle.countDown(endingRiddle, 26000);
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Item.itemObject.roomId = null;
        Menu.menu.menu();
    }

    private void endingSmeagol () {
        System.out.println("You were feasted on by smeagol because you failed to correctly answer the riddles!.");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Countdown endingSmeagol = new Countdown();
        endingSmeagol.countDown(endingSmeagol, 26000);
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Item.itemObject.roomId = null;
        Menu.menu.menu();
    }

    private void endingElrond () {
        System.out.println("You didn't let Lord Elrond read the map so you could not find the secret entrance into Erobor. Quest FAILED!");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Countdown endingElrond = new Countdown();
        endingElrond.countDown(endingElrond, 26000);
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Item.itemObject.roomId = null;
        Menu.menu.menu();
    }

    private void endingSword () {
        System.out.println("You dont have a sword to kill Smaug. Quest FAILED!");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Countdown endingSword = new Countdown();
        endingSword.countDown(endingSword, 26000);
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Item.itemObject.roomId = null;
        Menu.menu.menu();
    }

    private void endingRing () {
        System.out.println("You could not get undetected around Smaug, if you only had something to make you invisible. Quest FAILED!");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Countdown endingRing = new Countdown();
        endingRing.countDown(endingRing, 26000);
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Item.itemObject.roomId = null;
        Menu.menu.menu();
    }

    private void endingCompleted () {
        System.out.println("You killed the dragon smaug en retrieved the Arkenstone. playYou've completed the quest.");
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Countdown endingCompleted = new Countdown();
        endingCompleted.countDown(endingCompleted, 26000);
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Item.itemObject.roomId = null;
        Menu.menu.menu();
    }
}
