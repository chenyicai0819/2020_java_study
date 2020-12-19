/*
public class Test {
    public static void main(String[] args) {
        Client client = new Client();//创建了一个客户对象


        client.clientID="1122111";
        client.clientName="陈益财";
        client.clientAdd="GUET";
        client.clientPhone="15500932013";


        Order order = new Order();
        order.orderID="11111";
        order.orderOur="手机";
        order.orderAmmout=888F;

        //客户和订单进行关联
        client.order=order;



        //客户要查询订单
        System.out.println("客户ID："+client.clientID);
        System.out.println("客户昵称："+client.clientName);
        System.out.println("客户电话："+client.clientPhone);
        System.out.println("收货地址："+client.clientAdd);
        System.out.println("订单号："+client.order.orderID);
        System.out.println("商品："+client.order.orderOur);
        System.out.println("订单金额："+client.order.orderAmmout);
    }
}
*/

public class Test {
    public static void main(String[] args) {
        Client client = new Client();//创建了一个客户对象
        client.setClientID("123456");
        client.setClientName("陈益财");
        client.setClientPhone("15500932013");
        client.setClientAdd("桂林电子科技大学");

        Order order = new Order();
        order.setOrderID("1111112");
        order.setOrderAmmout(888F);
        order.setOrderOur("手机");

        System.out.println("客户ID："+client.getClientID());
        System.out.println("客户昵称："+client.getClientName());
        System.out.println("收货地址："+client.getClientAdd());
        System.out.println("客户电话："+client.getClientPhone());
        System.out.println("订单号："+order.getOrderID());
        System.out.println("商品："+order.getOrderOur());
        System.out.println("订单金额："+order.getOrderAmmout());
    }
}

