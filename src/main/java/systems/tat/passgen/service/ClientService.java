package systems.tat.passgen.service;

import systems.tat.passgen.entity.Client;
import systems.tat.passgen.exception.ClientNotFoundException;

import java.util.List;

public interface ClientService {


    Client findClientById(Long id) throws ClientNotFoundException;

    List<Client> findAllClients();

    Client saveClient(Client client);
}
