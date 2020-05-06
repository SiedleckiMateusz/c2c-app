package siedlecki.mateusz.c2capp.service.client;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.controller.mapper.ClientMapper;
import siedlecki.mateusz.c2capp.controller.model.ShowClient;
import siedlecki.mateusz.c2capp.entity.client.ClientEntity;
import siedlecki.mateusz.c2capp.repository.client.ClientRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService implements SimpleService<ClientEntity, Long> {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<ClientEntity> findById(Long aLong) {
        return clientRepository.findById(aLong);
    }

    @Override
    public ClientEntity save(ClientEntity client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(ClientEntity obj) {
        clientRepository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        clientRepository.deleteById(aLong);
    }

    public List<ShowClient> findAllBySentence(String text) {
        List<ShowClient> all = showAll();

        final String sentence = text.toLowerCase();


        return all.stream().filter(client -> {
            if (client.getRealName() != null) {
                if (client.getRealName().toLowerCase().contains(sentence)) {
                    return true;
                }
            }

            if (client.getWarehouseName() != null) {
                if (client.getWarehouseName().toLowerCase().contains(sentence)) {
                    return true;
                }
            }

            if (client.getAddress() != null) {
                if (client.getAddress().toLowerCase().contains(sentence)) {
                    return true;
                }
            }

            if (client.getNip() != null) {
                if (client.getNip().toLowerCase().contains(sentence)) {
                    return true;
                }
            }

            if (client.getRoute() != null) {
                if (client.getRoute().getName().toLowerCase().contains(sentence)) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
    }

    public List<ShowClient> showAll(){
        return findAll().stream().map(clientMapper::toShow).collect(Collectors.toList());
    }

}
