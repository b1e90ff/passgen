package systems.tat.passgen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import systems.tat.passgen.entity.Client;
import systems.tat.passgen.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/@all")
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }

    /*
     ToDo: Fix -> If clientId is not a Long it closed the connection with a 400 and no message. (Maybe add a message)
     */
    @PostMapping
    public Client saveClient(@Valid @RequestBody Client client) {
        return clientService.saveClient(client);
    }
}
