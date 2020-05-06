package siedlecki.mateusz.c2capp.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siedlecki.mateusz.c2capp.entity.client.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long>{

}
