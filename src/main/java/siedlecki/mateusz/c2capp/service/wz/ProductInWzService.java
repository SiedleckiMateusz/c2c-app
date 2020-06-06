package siedlecki.mateusz.c2capp.service.wz;

import siedlecki.mateusz.c2capp.entity.wz.ProductInWz;
import siedlecki.mateusz.c2capp.repository.wz.ProductInWzRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

public class ProductInWzService implements SimpleService<ProductInWz,Long> {

    private final ProductInWzRepository repository;

    public ProductInWzService(ProductInWzRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductInWz> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductInWz> findById(Long aLong) {
        return findById(aLong);
    }

    @Override
    public ProductInWz save(ProductInWz productInWz) {
        return repository.save(productInWz);
    }

    @Override
    public void delete(ProductInWz obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
