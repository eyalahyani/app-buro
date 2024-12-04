package org.LahyaniEya.App_Buro.Controller;


import java.util.List;

import org.LahyaniEya.App_Buro.Model.Client;
import org.LahyaniEya.App_Buro.Model.PieceRechangeReparation;
import org.LahyaniEya.App_Buro.Model.Reparation;
import org.LahyaniEya.App_Buro.Service.PieceRechangeReparationSeviceImpl;
import org.LahyaniEya.App_Buro.Service.ReparationServiceImpl;
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
@RequiredArgsConstructor
@RequestMapping 
public class PieceRechangeReparationController {
	@Autowired @NonNull
	private PieceRechangeReparationSeviceImpl PieceRechangeReparationServImp;
	@Autowired @NonNull
	private ReparationServiceImpl reparationSerImpl;
	
	  @GetMapping("/PieceRechangeReparation")
	    public List<PieceRechangeReparation> getAllPieceRechangeReparation() {
	        return PieceRechangeReparationServImp.findAllPieceRechangeReparation();
	    }

	    @PostMapping("/addPieceRechangeReparation")
	    public PieceRechangeReparation addPieceRechangeReparation(@RequestBody PieceRechangeReparation PieceRechnageReparation) {
	        return PieceRechangeReparationServImp.addPieceRechangeReparation(PieceRechnageReparation);
	    }

	    @GetMapping("/PieceRechangeReparation/{id}")
	    public PieceRechangeReparation getPieceRechangeReparationById(@PathVariable Long id) {
	        return PieceRechangeReparationServImp.findPieceRechangeReparationById(id);
	    }

	    @PutMapping("/updatePieceRechangeReparation")
	    public PieceRechangeReparation updatePieceRechangeReparation(@RequestBody PieceRechangeReparation pieceRechangeReparation) {
	        return PieceRechangeReparationServImp.updatePieceRechangeReparation(pieceRechangeReparation);
	    }

	    @DeleteMapping("/PieceRechangeReparation/{id}")
	    public void deletePieceRechangeReparation(@PathVariable Long id) {
	    	PieceRechangeReparationServImp.deletePieceRechangeReparation(id);
	    }
	    
	    @GetMapping("/allPieceReparation/{reparationId}")
		public List<PieceRechangeReparation> findByReparation(@PathVariable Long reparationId) {
	    	Reparation r=reparationSerImpl.findReparationById(reparationId);
	    	return PieceRechangeReparationServImp.findByReparation(r);
	        }
	    @GetMapping("/calcule-montant-total/{reparationId}")
	    public double calculeMontantTotal(@PathVariable Long reparationId) {
	    	Reparation r=reparationSerImpl.findReparationById(reparationId);
	    	return PieceRechangeReparationServImp.calculeMontantTotal(r);
	        }

}
