package siedlecki.mateusz.c2capp.service.delivery;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.delivery.SupplierEntity;
import siedlecki.mateusz.c2capp.repository.delivery.SupplierRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService implements SimpleService<SupplierEntity,Long> {

    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SupplierEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SupplierEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public SupplierEntity save(SupplierEntity supplier) {
        return repository.save(supplier);
    }

    public List<SupplierEntity> saveAll(List<SupplierEntity> suppliers){
        return repository.saveAll(suppliers);
    }

    @Override
    public void delete(SupplierEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
