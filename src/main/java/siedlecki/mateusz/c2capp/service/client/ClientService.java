package siedlecki.mateusz.c2capp.service.client;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.repository.client.ClientRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements SimpleService<Client,Long> {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long aLong) {
        return clientRepository.findById(aLong);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Client obj) {
        clientRepository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        clientRepository.deleteById(aLong);
    }
}
