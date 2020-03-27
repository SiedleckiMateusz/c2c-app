package siedlecki.mateusz.c2capp.service.product;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.product.ProductGroup;
import siedlecki.mateusz.c2capp.repository.product.ProductGroupRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductGroupService implements SimpleService<ProductGroup,Long> {

    private final ProductGroupRepository repository;

    public ProductGroupService(ProductGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductGroup> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductGroup> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public ProductGroup save(ProductGroup productGroup) {
        return repository.save(productGroup);
    }

    @Override
    public void delete(ProductGroup obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
