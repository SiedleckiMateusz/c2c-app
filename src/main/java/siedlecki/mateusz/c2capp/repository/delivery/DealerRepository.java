package siedlecki.mateusz.c2capp.repository.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.model.delivery.Dealer;

public interface DealerRepository extends JpaRepository<Dealer,Long> {
}
