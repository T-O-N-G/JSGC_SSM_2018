package mapper;

import pojo.Order;

import java.util.List;

public interface OrderMapper {

    public int add(Order order);

    public void delete(Order order);

    public int update(Order order);

    public Order getById(int id);

    public List<Order> list();
}
