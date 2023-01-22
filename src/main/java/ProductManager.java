public class ProductManager {
    private ProductRepository ProductRepository;
    private ProductRepository repo;
    private int products;


    public ProductManager( ProductRepository  ProductRepository ) {
        this.ProductRepository = ProductRepository;


    }
    public void add (Product product) {
        repo.save(product);

    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: ProductRepository.findAll()) {
            Product[] tmp = new Product[0];
            if (matches(product, text)) {
                tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++)
                    tmp[i] = result[i];
            }
            tmp[tmp.length - 1] = product;
            result = tmp;
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}