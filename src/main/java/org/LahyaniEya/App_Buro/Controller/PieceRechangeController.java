package org.LahyaniEya.App_Buro.Controller;

import java.util.List;
import org.LahyaniEya.App_Buro.Model.PieceRechange;
import org.LahyaniEya.App_Buro.Service.PieceRechangeServiceImpl;
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
@RequiredArgsConstructor
@RequestMapping 
public class PieceRechangeController {
	@Autowired @NonNull
	private PieceRechangeServiceImpl PieceRechangeSerImp;
	
	
	  @GetMapping("/PieceRechange")
	    public List<PieceRechange> getAllPiecesRechanges() {
	        return PieceRechangeSerImp.findAll();
	    }

	    @PostMapping("/AddPieceRechange")
	    public PieceRechange addPieceRechange(@RequestBody PieceRechange pieceRechange) {
	        return PieceRechangeSerImp.addPieceRechange(pieceRechange);
	    }

	    @GetMapping("/PieceRechange/{id}")
	    public PieceRechange getPieceRechangeById(@PathVariable Long id) {
	        return PieceRechangeSerImp.findById(id);
	    }

	    @PutMapping("/updatePieceRechange")
	    public PieceRechange updatePieceRechange(@RequestBody PieceRechange pieceRechange) {
	        return PieceRechangeSerImp.updatePieceRechange(pieceRechange);
	    }

	    @DeleteMapping("/PieceRechange/{id}")
	    public void deletePieceRechange(@PathVariable Long id) {
	         PieceRechangeSerImp.deletePieceRechange(id);
	    }

	    
}
