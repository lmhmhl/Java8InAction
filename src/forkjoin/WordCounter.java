package forkjoin;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-10
 **/
public class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace((c))) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    public WordCounter combine(WordCounter w1) {
        return new WordCounter(counter + w1.counter, w1.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}
