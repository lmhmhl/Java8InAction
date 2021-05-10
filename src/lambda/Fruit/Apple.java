package lambda.Fruit;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-04-30
 **/
class Apple extends Fruit {
    private Integer i;
    public String color;
    Apple() {

    }

    Apple(Integer i) {
        this.i = i;
    }
    Apple(String color){
        this.color=color;
    }
}