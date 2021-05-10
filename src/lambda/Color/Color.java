package lambda.Color;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-04-30
 **/

public class Color {

    private Color(int a, int b, int c){
        System.out.println(a+"   +   "+b+"  +  "+c);
    }

    private static Color func(TriFunction<Integer,Integer,Integer,Color> triFunction, ColorType type){
        return triFunction.apply(type.first,type.second,type.third);
    }

    public static void main(String[] args) {
        System.out.println(func(Color::new, ColorType.RED));
        System.out.println(func(Color::new, ColorType.BLUE));
    }
}
