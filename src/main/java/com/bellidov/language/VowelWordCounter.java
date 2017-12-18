package com.bellidov.language;


import java.util.Objects;

// should be unike by word length
public class VowelWordCounter {
    
    private int wordLength = 0;
    private int vowelCounter = 0;
    private int wordCounter = 0;

    public VowelWordCounter(int vowelCounter, int wordLength) {
        this.wordLength = wordLength;
        this.vowelCounter = vowelCounter;
        wordCounter++;
    }
    
    public int getVowelCounter() {
        return vowelCounter;
    }

    public void increaseVowelCounter(int vowelCounter) {
        this.vowelCounter += vowelCounter;
        wordCounter++;
    }

    public int getWordCounter() {
        return wordCounter;
    }

    public int getWordLength() {
        return wordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VowelWordCounter)) return false;
        VowelWordCounter that = (VowelWordCounter) o;
        return wordLength == that.wordLength;
    }

    @Override
    public int hashCode() {

        return Objects.hash(wordLength);
    }
}
