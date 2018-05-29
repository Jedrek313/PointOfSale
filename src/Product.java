public class Product {

private String name;
private double price;
private String barCode;

    public Product(String barCode, String name, double price){
        this.barCode = barCode;
        this.name=name;
        this.price=price;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Override
    public String toString(){
        return "Product: " + name + " Price: " + price;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Product))return false;
        Product oProduct = (Product)o;
        if(oProduct.getBarCode().equals(this.getBarCode()) &&
                oProduct.getPrice()==this.getPrice() &&
                oProduct.getName().equals(this.getName())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;

    }
}
