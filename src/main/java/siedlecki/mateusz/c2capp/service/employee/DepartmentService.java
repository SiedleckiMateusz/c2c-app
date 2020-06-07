package siedlecki.mateusz.c2capp.service.employee;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.employee.DepartmentEntity;
import siedlecki.mateusz.c2capp.repository.employee.DepartmentRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements SimpleService<DepartmentEntity,Long> {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<DepartmentEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DepartmentEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public DepartmentEntity save(DepartmentEntity department) {
        return repository.save(department);
    }

    public List<DepartmentEntity> saveAll(List<DepartmentEntity> objectsList) {
        return repository.saveAll(objectsList);
    }

    @Override
    public void delete(DepartmentEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
