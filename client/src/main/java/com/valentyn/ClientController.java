package com.valentyn;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    private final RestTemplate restTemplate;

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

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        // Выполняем GET-запрос к микросервису с книгами
        String booksUrl = "http://localhost:9091/books";
        return restTemplate.getForObject(booksUrl, List.class);
    }

}