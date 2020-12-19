import java.util.List;

public class Order {
    //订单号，订单中所包含的物品,订单所有者ID
    private String orderID;
    private String orderOur;//订单内容
    private float orderAmmout;
    private String orderForID;

    List<Client> clientList;

    public float getOrderAmmout() {
        return orderAmmout;
    }
    public void setOrderAmmout(float orderAmmout) {
        this.orderAmmout = orderAmmout;
    }

    public String getOrderForID() {
        return orderForID;
    }
    public void setOrderForID(String orderForID) {
        this.orderForID = orderForID;
    }

    public String getOrderID() {
        return orderID;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderOur() {
        return orderOur;
    }
    public void setOrderOur(String orderOur) {
        this.orderOur = orderOur;
    }

    public List<Client> getClientList() {
        return clientList;
    }
    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }


}

