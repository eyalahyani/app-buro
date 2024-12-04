package org.LahyaniEya.App_Buro.Controller;

import org.LahyaniEya.App_Buro.Model.Client;
import org.LahyaniEya.App_Buro.Service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client") 
public class ClientController {
    @NonNull
    @Autowired
    private ClientServiceImpl clientServImp;

    @GetMapping
    public List<Client> getAllClients() {
        return clientServImp.findAll();
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientServImp.addClient(client);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientServImp.getClientById(id);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client client) {
        return clientServImp.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientServImp.deleteClient(id);
    }

    @GetMapping("/search")
    public List<Client> findClientsByName(@RequestParam String name) {
        return clientServImp.findAllName(name);
    }
}
