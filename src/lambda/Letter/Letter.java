package lambda.Letter;

import java.util.function.Function;
import java.util.logging.Logger;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-01
 **/
public class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("h", "l");
    }

    public static void func(Function<String,String> function){
        String string = function.apply("hahahaha");
        Logger.getLogger("log").info("This is log!\n");
        System.out.println(string);
    }

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline
                = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        func(transformationPipeline);
    }
}
