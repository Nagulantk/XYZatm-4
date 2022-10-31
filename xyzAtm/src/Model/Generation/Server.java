package Model.Generation;

import java.util.ArrayList;
public class Server {

    private  ArrayList<Customer> customerList=new java.util.ArrayList<>();

    public  ArrayList<Customer> getList1() {
        return customerList;
    }

    public  void setList1(Customer customer) {
     customerList.add(customer);
    }
    private static Server server=new Server();

private Server()
{

}
public static Server getServer()
{
    return server;
}



}
