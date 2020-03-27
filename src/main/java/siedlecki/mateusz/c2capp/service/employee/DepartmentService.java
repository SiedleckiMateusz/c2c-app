package siedlecki.mateusz.c2capp.service.employee;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.employee.Department;
import siedlecki.mateusz.c2capp.repository.employee.DepartmentRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements SimpleService<Department,Long> {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Department> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Department save(Department department) {
        return repository.save(department);
    }

    public List<Department> saveAll(List<Department> objectsList) {
        return repository.saveAll(objectsList);
    }

    @Override
    public void delete(Department obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
