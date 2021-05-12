package designPattern.templateMethod;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-11
 **/
class Database {


    static Customer getCustomerWithId(int id) {
        Customer customer = new Customer(id);
        return customer;
    }
}
