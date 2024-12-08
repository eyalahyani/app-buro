package org.LahyaniEya.App_Buro.Controller;

import java.util.List;
import org.LahyaniEya.App_Buro.Model.TypePiece;
import org.LahyaniEya.App_Buro.Service.TypePieceRechangeServiceImpl;
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
public class TypePieceRechangeController {
	@Autowired @NonNull
	private TypePieceRechangeServiceImpl typePieceRechangeServImp;

	
	 @GetMapping("/TypePieceRechange")
	    public List<TypePiece> getAllTypePiece() {
	        return typePieceRechangeServImp.findAllTypePiece();
	    }

	 @PostMapping("/AddTypePieceRechange")
	    public TypePiece addTypePiece(@RequestBody TypePiece typePiece) {
	        TypePiece savedTypePiece = typePieceRechangeServImp.addTypePiece(typePiece);
	        return typePieceRechangeServImp.addTypePiece(savedTypePiece);
	    }

		@GetMapping("/TypePieceRechange/{id}")
		public TypePiece getTypePieceById(@PathVariable Long id) {
			return typePieceRechangeServImp.findTypePieceById(id);
		}
		
	    @PutMapping("/updateTypePieceRechange")
	    public TypePiece updateTypePiece(@RequestBody TypePiece typePiece) {
	        return typePieceRechangeServImp.updateTypePiece(typePiece);
	    }

	    @DeleteMapping("/TypePieceRechange/{id}")
	    public void deleteClient(@PathVariable Long id) {
	        typePieceRechangeServImp.deleteTypePiece(id);
	    }
	 
	 
	 
}
