package systems.tat.passgen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systems.tat.passgen.entity.Client;
import systems.tat.passgen.exception.ClientNotFoundException;
import systems.tat.passgen.repository.ClientRepository;
import systems.tat.passgen.service.ClientService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findClientById(Long clientId) throws ClientNotFoundException {
        return clientRepository.findByClientId(clientId).orElseThrow(() -> new ClientNotFoundException("Client with id " + clientId + " not found"));
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        // ToDo if Login exits use the logged information
        Client oldClient = clientRepository.findByClientId(client.getClientId()).orElse(null);

        if (oldClient == null) {
            client.setCreationDate(System.currentTimeMillis());
        }

        return clientRepository.save(client);
    }
}
