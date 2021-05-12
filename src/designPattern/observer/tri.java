package designPattern.observer;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-11
 **/

interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}