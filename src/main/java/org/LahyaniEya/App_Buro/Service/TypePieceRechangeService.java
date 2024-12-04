package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.TypePiece;

public interface TypePieceRechangeService {
	public List<TypePiece> findAllTypePiece();
	public TypePiece findTypePieceById(Long id);
	public 	TypePiece addTypePiece(TypePiece tP);
	public TypePiece updateTypePiece(TypePiece tP);
	public void deleteTypePiece(Long id);

}
