package siedlecki.mateusz.c2capp.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.product.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity,Long> {
}
