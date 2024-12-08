package org.LahyaniEya.App_Buro.Controller;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.DemandeReparation;
import org.LahyaniEya.App_Buro.Service.ClientServiceImpl;
import org.LahyaniEya.App_Buro.Service.DemandeReparationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class DemandeReparationController {
	@NonNull @Autowired
	private DemandeReparationServiceImpl demandeReparationServ;
	

	@NonNull @Autowired
	private  ClientServiceImpl clientserv;
	
    @GetMapping("/demand-reparation")
    public List<DemandeReparation> getAllDemandeReparation() {
        return demandeReparationServ.findAllDemandeReparation();
    }

    @PostMapping("/AddDReparation")
    public DemandeReparation addDemandeReparation(@RequestBody DemandeReparation demandeReparation) {
        return demandeReparationServ.addDemandeRepration(demandeReparation);
    }

    @GetMapping("/demand-reparation/{id}")
    public DemandeReparation getDemandeReparationById(@PathVariable Long id) {
        return demandeReparationServ.findDemandeReparationById(id);
    }

    
    @GetMapping("/demand-reparation/etat")
    public List<DemandeReparation> getDemandeReparationByEtat(@RequestParam String etat) {
        return demandeReparationServ.findDemandeReparationByEtat(etat);
    }

    @PutMapping("/demand-reparation")
    public DemandeReparation updateDemandeReparation(@RequestBody DemandeReparation demandeReparation ) {
        return demandeReparationServ.updateDemandeRepration(demandeReparation);
    }
    
    @DeleteMapping("/demand-reparation/{id}")
    public void deleteDemandeReparation(@PathVariable Long id) {
        DemandeReparation demandeReparation = demandeReparationServ.findDemandeReparationById(id);
        demandeReparationServ.deleteDemandeReparation(demandeReparation);
    }
	   

}
