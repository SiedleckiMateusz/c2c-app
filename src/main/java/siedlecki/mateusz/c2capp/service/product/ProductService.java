package siedlecki.mateusz.c2capp.service.product;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.product.Product;
import siedlecki.mateusz.c2capp.repository.product.ProductRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements SimpleService<Product,Long> {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(Product obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
