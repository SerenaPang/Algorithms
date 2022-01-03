package mock;

public class Word {
    int frequency;
    String word;
    public Word(int frequency, String word){
        this.frequency =frequency;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }
}
