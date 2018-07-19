package pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.util.ArrayList;
@ExcelTarget("CategoryEntity")
public class Category {
    @Excel(name = "序号")
    private int id;
    @Excel(name = "种类名", height = 20, width = 30, isImportField = "true_st")
    private String name;
    private ArrayList<Product> products = new ArrayList<>();
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Category() {
    }
    public Category(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
}
