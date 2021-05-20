package lazyGenerate;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-20
 **/
public interface MyList<T> {
    T head();
    MyList<T> tail();
    default boolean isEmpty() {
        return true;
    }
}