package siedlecki.mateusz.c2capp.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siedlecki.mateusz.c2capp.model.client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

}
