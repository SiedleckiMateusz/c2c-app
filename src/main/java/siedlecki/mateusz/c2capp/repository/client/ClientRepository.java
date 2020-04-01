package siedlecki.mateusz.c2capp.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siedlecki.mateusz.c2capp.model.client.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

    List<Client> findAllByRealNameContainsOrWarehouseNameContainsOrAddressContains(String rName, String wName, String address);
}
