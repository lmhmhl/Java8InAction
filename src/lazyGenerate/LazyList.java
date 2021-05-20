package lazyGenerate;


import java.util.function.Supplier;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-20
 **/
public class LazyList<T> implements MyList<T> {
    final T head;
    final Supplier<MyList<T>> tail;

    public LazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail.get();
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<Integer>(n, () -> from(n + 1));
    }

    public static void main(String[] args) {
        LazyList<Integer> numbers = from(2);
        Integer head = numbers.head();
        System.out.println(head);
        Integer head2 = numbers.tail().head();
        Integer head1 = numbers.tail().tail().head();
        System.out.println(head + " " + head2 + " " + head1);
    }
}
