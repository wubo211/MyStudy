package com.study.desion.builder;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/18 16:52
 **/
public class Product {

    private int id;
    private String name;
    private int type;
    private long price;

    public Product() {
    }

    public Product(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.price = builder.price;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public final static class Builder{
        private int id;
        private String name;
        private int type;
        private long price;

        public Builder() {
        }

        public Builder(Product product){
            this.id = product.getId();
            this.name = product.getName();
            this.type = product.getId();
            this.price = product.getPrice();
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        public Builder setPrice(long price) {
            this.price = price;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }

}
