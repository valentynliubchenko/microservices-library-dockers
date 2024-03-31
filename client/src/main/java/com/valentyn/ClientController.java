package com.valentyn;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        Optional<ClientDTO> clientOptional = clientService.getClientById(id);
        return clientOptional.orElse(null);
    }

    @PostMapping
    public ClientDTO addClient(@RequestBody ClientDTO client) {
        return clientService.addClient(client);
    }
}