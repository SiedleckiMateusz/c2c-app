package siedlecki.mateusz.c2capp.service.delivery;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.delivery.ProductInDelivery;
import siedlecki.mateusz.c2capp.repository.delivery.ProductInDeliveryRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInDeliveryService implements SimpleService<ProductInDelivery,Long> {

    private final ProductInDeliveryRepository repository;

    public ProductInDeliveryService(ProductInDeliveryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductInDelivery> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductInDelivery> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public ProductInDelivery save(ProductInDelivery productInDelivery) {
        return repository.save(productInDelivery);
    }

    @Override
    public void delete(ProductInDelivery obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
