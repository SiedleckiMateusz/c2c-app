package siedlecki.mateusz.c2capp.service.employee;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.employee.WorkPosition;
import siedlecki.mateusz.c2capp.repository.employee.WorkPositionRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class WorkPositionService implements SimpleService<WorkPosition,Long> {

    private final WorkPositionRepository repository;

    public WorkPositionService(WorkPositionRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<WorkPosition> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<WorkPosition> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public WorkPosition save(WorkPosition workPosition) {
        return repository.save(workPosition);
    }

    public List<WorkPosition> saveAll(List<WorkPosition> objectsList) {
        return repository.saveAll(objectsList);
    }

    @Override
    public void delete(WorkPosition obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
