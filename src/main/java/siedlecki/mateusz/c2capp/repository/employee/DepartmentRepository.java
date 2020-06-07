package siedlecki.mateusz.c2capp.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.employee.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
