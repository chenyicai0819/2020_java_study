import java.util.List;

public class Client {
    //客户名，客户ID，客户地址，客户电话
    private String clientName;
    private String clientID;
    private String clientPhone;
    private String clientAdd;

    private Order order;

    public String getClientID(){
        return clientID;
    }
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAdd() {
        return clientAdd;
    }
    public void setClientAdd(String clientAdd) {
        this.clientAdd = clientAdd;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public String getClientPhone() {
        return clientPhone;
    }
    public void setClientPhone(String clientPhone) {
        //判断电话号码是否全都是数字
        String error="";
        try{
            int phineNumber=Integer.parseInt(clientPhone);
        }catch(NumberFormatException e){
            error="字符串格式错误";
        }
        if(!error.equals("")){
            return;
        }
        else{
            this.clientPhone = clientPhone;
        }

    }
    //List<Order> orderList;
}
