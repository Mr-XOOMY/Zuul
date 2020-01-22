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
            case "smeagol":
                endingSmeagol();
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
        Art.artObject.drawQuestFailed();
        Storyline.storyLineObject.drawEndingRoom3();
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingCountDown () {
        Art.artObject.drawQuestFailed();
        Storyline.storyLineObject.drawEndingCountDown();
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingRoom5 () {
        Art.artObject.drawQuestFailed();
        Storyline.storyLineObject.drawEndingRoom5();
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingSmeagol () {
        Art.artObject.drawQuestFailed();
        Storyline.storyLineObject.drawEndingSmeagol();
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingElrond () {
        Art.artObject.drawQuestFailed();
        Storyline.storyLineObject.drawEndingElrond();
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingSword () {
        Art.artObject.drawQuestFailed();
        Storyline.storyLineObject.drawEndingSword();
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingRing () {
        Art.artObject.drawQuestFailed();
        Storyline.storyLineObject.drawEndingRing();
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questFailed();
        Item.itemObject.inputItems();
    }

    private void endingCompleted () {
        Art.artObject.drawQuestCompleted();
        Storyline.storyLineObject.drawEndingCompleted();
        Music.musicObject.getDevice().stop();
        Music.musicObject.getDevice().close();
        Music.musicObject.questCompleted();
        Item.itemObject.inputItems();
    }
}
