package siedlecki.mateusz.c2capp.service.product;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.wz.UnitEntity;
import siedlecki.mateusz.c2capp.repository.product.UnitRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService implements SimpleService<UnitEntity,Long> {

    private final UnitRepository repository;

    public UnitService(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UnitEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UnitEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public UnitEntity save(UnitEntity unit) {
        return repository.save(unit);
    }

    public List<UnitEntity> saveAll(List<UnitEntity> units){
        return repository.saveAll(units);
    }

    @Override
    public void delete(UnitEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
