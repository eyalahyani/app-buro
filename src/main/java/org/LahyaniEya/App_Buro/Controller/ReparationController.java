package org.LahyaniEya.App_Buro.Controller;

import java.util.List;
import java.util.Optional;

import org.LahyaniEya.App_Buro.Model.Client;
import org.LahyaniEya.App_Buro.Model.DemandeReparation;
import org.LahyaniEya.App_Buro.Model.Reparation;
import org.LahyaniEya.App_Buro.Service.DemandeReparationServiceImpl;
import org.LahyaniEya.App_Buro.Service.ReparationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class ReparationController {

    @NonNull @Autowired
    private ReparationServiceImpl reparationservImp;



    @GetMapping("/Reparation")
    public List<Reparation> getAllReparation() {
        return reparationservImp.findAllReparation();
    }

    @PostMapping("/AddReparation")
    public Reparation addReparation(@RequestBody Reparation reparation) {
        return reparationservImp.addReparation(reparation);
    }
    
    @GetMapping("/Reparation/{id}")
    public Reparation getReparationById(@PathVariable Long id) {
        return reparationservImp.findReparationById(id);
    }
    
    @PutMapping("/UpdateReparation")
    public Reparation updateReparation(@RequestBody Reparation reparation) {
        return reparationservImp.updateRepration(reparation);
    }

    @DeleteMapping("/DeleteReparation/{id}")
    public void deleteReparationById(@PathVariable Long id) {
        Reparation reparation = reparationservImp.findReparationById(id);
        reparationservImp.deleteReparation(reparation);
    }

    
    
}
    
