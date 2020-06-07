package siedlecki.mateusz.c2capp.service.wz;

import siedlecki.mateusz.c2capp.entity.wz.ProductInWzEntity;
import siedlecki.mateusz.c2capp.repository.wz.ProductInWzRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

public class ProductInWzService implements SimpleService<ProductInWzEntity,Long> {

    private final ProductInWzRepository repository;

    public ProductInWzService(ProductInWzRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductInWzEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductInWzEntity> findById(Long aLong) {
        return findById(aLong);
    }

    @Override
    public ProductInWzEntity save(ProductInWzEntity productInWz) {
        return repository.save(productInWz);
    }

    @Override
    public void delete(ProductInWzEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
