package stream.samples;

import java.util.Currency;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-06
 **/
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public Currency getCurrency(){
        return Currency.getInstance("");
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}

