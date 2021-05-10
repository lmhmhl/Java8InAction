package lambda.Color;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-04-30
 **/
public enum ColorType {
    RED(231, 43, 4), BLUE(3, 5, 6), GREEN(654, 6, 6);
    int first, second, third;

    ColorType(int i, int i1, int i2) {
        this.first = i;
        this.second = i1;
        this.third = i2;
    }
}
