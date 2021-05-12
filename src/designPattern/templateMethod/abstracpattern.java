package designPattern.templateMethod;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-11
 **/
abstract class OnlineBanking {
    public void processCustomer(int id) {
        Database database = new Database();
        Customer c = database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);
}
