package mapper;

import pojo.Product;

import java.util.List;

public interface ProductMapper {
    public int add(Product product);

    public void delete(Product product);

    public int update(Product product);

    public Product getById(int id);

    public Product getByCategoryId(int cid);

    public List<Product> list();

//    public List<Product> getListProductByCategory(int cid);


}
