import java.util.List;

public class Client extends Person{
    private List<Order> orderList;

    private String login;
    private String password;

    public Client(String name, String address, String login, String password){
        super(name, address);
        this.login = login;
        this.password = password;
    }

    private Order findOpenOrder(){
        for (Order order: orderList) {
            if (order.getOrderStatus() == Status.OPEN)
                return order;
        }
        return null;
    }

    public void createOrder(int number, String address, List<Product> products) {
        Order newOrder = findOpenOrder();
        if (newOrder == null){
            orderList.add(new Order(number, address, products, Status.OPEN));
        }

    }

    public void ConfirmOrder(){
        for (Order order: orderList){
            if(order.getOrderStatus() == Status.OPEN)
                order.setOrderStatus(Status.ORDERED);
        }
    }

    public void setOrderList(List<Order> orderList){
        this.orderList = orderList;
    }

    public List<Order> getOrderList(){
        return this.orderList;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return this.login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public String toString() {
        return "Client: " + getName() +
                ", orders=" + orderList +
                '\n';
    }
}
