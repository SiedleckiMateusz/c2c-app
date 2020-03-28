package siedlecki.mateusz.c2capp.service.product;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.product.Unit;
import siedlecki.mateusz.c2capp.repository.product.UnitRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService implements SimpleService<Unit,Long> {

    private final UnitRepository repository;

    public UnitService(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Unit> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Unit> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Unit save(Unit unit) {
        return repository.save(unit);
    }

    public List<Unit> saveAll(List<Unit> units){
        return repository.saveAll(units);
    }

    @Override
    public void delete(Unit obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
