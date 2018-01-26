package com.starks.english;

/**
 * Created by RCP on 1/26/2018.
 */

public class Mean {
    private int id;
    private String word;
    private String meaning;
    private String sentence;

    public Mean(int id, String word, String meaning, String sentence) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.sentence = sentence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
