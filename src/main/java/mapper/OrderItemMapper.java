package mapper;

import pojo.Order;
import pojo.OrderItem;

public interface OrderItemMapper {
    public int add(OrderItem orderItem);

    public void delete(OrderItem orderItem);

    //内置函数
    public Order _getByOrderId();
}
