import model.Product;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

public class PointOfSaleTest{

    public static PointOfSale pointOfSale;

    @BeforeClass
    public static void setUp(){
        pointOfSale = new PointOfSale();
    }

    @Test
    public void addingProductProperly(){
        Product milk = new Product("100","Milk",1.99);
        pointOfSale.addProduct(milk);
        Assert.assertTrue(pointOfSale.getProducts().contains(milk));
    }

    @Test
    public void addingProductTotalPriceEquals(){
        Product milk = new Product("100","Milk",1.99);
        pointOfSale.addProduct(milk);
        Assert.assertEquals(pointOfSale.getTotalPrice(), milk.getPrice(), 0.005);
    }

    @Test
    public void addingThreeTheSameProductsProperly(){
        Product milk = new Product("100","Milk",1.99);
        pointOfSale.addProduct(milk);
        pointOfSale.addProduct(milk);
        pointOfSale.addProduct(milk);
        Assert.assertEquals(pointOfSale.getProducts().size(), 3);
        Iterator iterator = pointOfSale.getProducts().iterator();
        while(iterator.hasNext()) {
            Assert.assertEquals(iterator.next(), milk);
        }
    }

    @Test
    public void addingThreeProductsShouldGaveProperlyTotalPrice(){
        Product milk = new Product("100","Milk",1.99);
        Product water = new Product("101","Water",2.99);
        Product apple = new Product("102","Apple",3.99);
        pointOfSale.addProduct(milk);
        pointOfSale.addProduct(water);
        pointOfSale.addProduct(apple);
        Assert.assertEquals(pointOfSale.getTotalPrice(), milk.getPrice()+water.getPrice()+apple.getPrice(), 0.005);
    }

    @Test
    public void endTransactionShouldClearProductList(){
        Product milk = new Product("100","Milk",1.99);
        pointOfSale.addProduct(milk);
        pointOfSale.endTransaction();
        Assert.assertTrue(pointOfSale.getProducts().isEmpty());
    }

    @Test
    public void endTransactionGaveZeroTotalPrice(){
        Product milk = new Product("100","Milk",1.99);
        pointOfSale.addProduct(milk);
        pointOfSale.endTransaction();
        Assert.assertEquals(pointOfSale.getTotalPrice(), 0.0, 0.005);
    }

}