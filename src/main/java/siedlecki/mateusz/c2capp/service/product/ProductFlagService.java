package siedlecki.mateusz.c2capp.service.product;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.product.ProductFlagEntity;
import siedlecki.mateusz.c2capp.repository.product.ProductFlagRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductFlagService implements SimpleService<ProductFlagEntity,Long> {

    private final ProductFlagRepository repository;

    public ProductFlagService(ProductFlagRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductFlagEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductFlagEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public ProductFlagEntity save(ProductFlagEntity productFlag) {
        return repository.save(productFlag);
    }

    public List<ProductFlagEntity> saveAll(List<ProductFlagEntity> flags){
        return repository.saveAll(flags);
    }

    @Override
    public void delete(ProductFlagEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
