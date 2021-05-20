package lazyGenerate;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-20
 **/
public class Pair<X,Y> {
    public final X x;
    public final Y y;
    public Pair(X x,Y y){
        this.x=x;
        this.y=y;
    }

    public static void main(String[] args) {
        com.sun.tools.javac.util.Pair<String, String> o= new com.sun.tools.javac.util.Pair<>("a", " s");
        System.out.println(o.fst+" "+o.snd);
    }
}
