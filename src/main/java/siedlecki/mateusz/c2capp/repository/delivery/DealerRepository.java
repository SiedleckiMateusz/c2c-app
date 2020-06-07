package siedlecki.mateusz.c2capp.repository.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.delivery.DealerEntity;

public interface DealerRepository extends JpaRepository<DealerEntity,Long> {
}
