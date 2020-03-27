package siedlecki.mateusz.c2capp.service.delivery;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.delivery.Supplier;
import siedlecki.mateusz.c2capp.repository.delivery.SupplierRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService implements SimpleService<Supplier,Long> {

    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Supplier> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Supplier> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public void delete(Supplier obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
