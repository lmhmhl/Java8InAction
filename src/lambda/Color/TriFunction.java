package lambda.Color;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-04-30
 **/

@FunctionalInterface
public interface TriFunction<T, U, V, R>{ R apply(T t, U u, V v);
}