package siedlecki.mateusz.c2capp.service.product;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.product.ProductFlag;
import siedlecki.mateusz.c2capp.repository.product.ProductFlagRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductFlagService implements SimpleService<ProductFlag,Long> {

    private final ProductFlagRepository repository;

    public ProductFlagService(ProductFlagRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductFlag> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductFlag> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public ProductFlag save(ProductFlag productFlag) {
        return repository.save(productFlag);
    }

    public List<ProductFlag> saveAll(List<ProductFlag> flags){
        return repository.saveAll(flags);
    }

    @Override
    public void delete(ProductFlag obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
