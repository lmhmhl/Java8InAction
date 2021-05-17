package immutable;

import com.sun.javafx.collections.ImmutableObservableList;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-17
 **/
public class immutable {
    ImmutableObservableList list = new ImmutableObservableList();
}

class Bird2 {
    Bird2(int i) {
    }

    Bird2(double d) {
    }

    Bird2() {

    }
}

class NoSynthesis {
    public static void main(String[] args) {
        Bird2 b = new Bird2(); // No default
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2(1.0);
    }
}

class Banana {
    public static void peel(Banana b, int i) {
    }

    void peel(int i) { /* ... */
        String string = this.toString();
        System.out.println(string);
    }
}

class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana();
        Banana b = new Banana();
        a.peel(1);
        b.peel(2);
        Banana.peel(b, 2);
    }
} ///:~