package siedlecki.mateusz.c2capp.service.employee;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.employee.WorkPositionEntity;
import siedlecki.mateusz.c2capp.repository.employee.WorkPositionRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class WorkPositionService implements SimpleService<WorkPositionEntity,Long> {

    private final WorkPositionRepository repository;

    public WorkPositionService(WorkPositionRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<WorkPositionEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<WorkPositionEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public WorkPositionEntity save(WorkPositionEntity workPosition) {
        return repository.save(workPosition);
    }

    public List<WorkPositionEntity> saveAll(List<WorkPositionEntity> objectsList) {
        return repository.saveAll(objectsList);
    }

    @Override
    public void delete(WorkPositionEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
