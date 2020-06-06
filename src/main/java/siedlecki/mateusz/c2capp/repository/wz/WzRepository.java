package siedlecki.mateusz.c2capp.repository.wz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siedlecki.mateusz.c2capp.entity.wz.Wz;

@Repository
public interface WzRepository extends JpaRepository<Wz,Long> {
}
