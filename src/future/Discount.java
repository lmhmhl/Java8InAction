package future;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-13
 **/
public enum Discount {

    NONE(0),
    SILVER(5),
    GOLD(10),
    PLATINUM(15), DIAMOND(20);

    private final int percentage;

    Discount(int i) {
        this.percentage=i;
    }
}
