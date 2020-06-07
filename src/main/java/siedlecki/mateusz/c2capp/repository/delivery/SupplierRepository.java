package siedlecki.mateusz.c2capp.repository.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.delivery.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity,Long> {
}
