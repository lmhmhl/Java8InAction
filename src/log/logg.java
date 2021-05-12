package log;


import com.oracle.tools.packager.Log;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-10
 **/

public class logg {
    public static final Logger LOGGER = LoggerFactory.getLogger(logg.class);
    public static void main(String[] args) {
        LOGGER.error("error");
    }
}
