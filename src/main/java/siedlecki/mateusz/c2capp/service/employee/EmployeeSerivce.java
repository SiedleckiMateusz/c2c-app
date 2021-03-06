package siedlecki.mateusz.c2capp.service.employee;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.employee.EmployeeEntity;
import siedlecki.mateusz.c2capp.repository.employee.EmployeeRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSerivce implements SimpleService<EmployeeEntity,Long> {

    private final EmployeeRepository repository;

    public EmployeeSerivce(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        return repository.save(employee);
    }

    @Override
    public void delete(EmployeeEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
