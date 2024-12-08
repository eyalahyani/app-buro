package org.LahyaniEya.App_Buro.Controller;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.Facture;
import org.LahyaniEya.App_Buro.Service.FactureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping 
public class FactureController {
	@Autowired @NonNull
	private FactureServiceImpl factureServImpl;
	
	@PostMapping("/addFacture")
	public Facture addFacture(@RequestBody Facture f) {
		return factureServImpl.addFacture(f);
	}
	
	  @GetMapping("/Facture")
	    public List<Facture> getAllFactures() {
	        return factureServImpl.findAllFacture();
	    }
	  @GetMapping("/Facture/{id}")
	    public Facture getFactureById(@PathVariable Long id) {
	        return factureServImpl.findByIdFacture(id);
	    }
	
	  @GetMapping("/Facture/search")
	    public Facture getFactureById(@RequestParam String numero) {
	        return factureServImpl.findByNumero(numero);
	    }
	  
	  @PutMapping("/updateFacture")
	    public Facture updateFacture(@RequestBody Facture f) {
	        return factureServImpl.updateFacture(f);
	    }
	  
	  @DeleteMapping("/Facture/{id}")
	    public void deleteFacture(@PathVariable Long id) {
	         factureServImpl.deleteFacture(id);
	    }
}
