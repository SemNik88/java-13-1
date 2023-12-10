import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.NotFoundException;
import org.example.Product;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingElement() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);

        shopRepository.add(product1);
        shopRepository.add(product2);

        shopRepository.removeById(1);

        Product[] expected = { product2 };
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundExceptionForNonExistingElement() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);

        shopRepository.add(product1);
        shopRepository.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> shopRepository.removeById(3));
    }
}

