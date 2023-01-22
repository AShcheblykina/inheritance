
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class ProductRepositoryTest {

    Product products1 = new Product(11,"dark", 285);
    Product products2 = new Product(25, "white", 540);
    Product products3 = new Product(12, "red", 511);

    @Test
    public void addedProduct() {
        ProductRepository repo = new ProductRepository();
        repo.add(products1);
        repo.add(products2);
        repo.add(products3);

        Product[] expected = {products1,products2,products3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void addedOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.add(products1);

        Product[] expected = {products1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);

    }
    @Test
    public void addedTwoProduct() {
        ProductRepository repo = new ProductRepository();
        repo.add(products1);
        repo.add(products2);

        Product[] expected = {products1,products2};
        Product[] actual = repo.findAll();
    }
    @Test
    public void saveOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.add(products3);

        Product[] expected = {products1,products2};
        Product[] actual = repo.findAll();


    }
    @Test
    public void deleteProduct() {
        ProductRepository repo = new ProductRepository();
        repo.add(products1);
        repo.add(products2);
        repo.add(products3);
        repo.removeById(products3.getId());

        Product[] expected = {products1,products2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }



}
