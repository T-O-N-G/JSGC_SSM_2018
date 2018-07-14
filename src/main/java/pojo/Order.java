package pojo;

import java.util.List;

public class Order {
    private int id;
    private String code;
    private List<OrderItem> orderItemList;

    public Order() {
    }

    public Order(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public Order(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String toString(){
        return String.format("Order: {id: %d, code: %s}", id, code);
    }
}
