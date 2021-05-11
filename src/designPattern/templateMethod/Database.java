package designPattern.templateMethod;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-11
 **/
public class Database {

    public static Customer getCustomerWithId(int id) {
        new designPattern.templateMethod.Customer(id);
        return null;
    }
}
