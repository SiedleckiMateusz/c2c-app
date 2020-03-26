package siedlecki.mateusz.c2capp.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.model.client.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
