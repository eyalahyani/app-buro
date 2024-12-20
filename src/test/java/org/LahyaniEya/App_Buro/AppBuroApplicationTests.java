package org.LahyaniEya.App_Buro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.LahyaniEya.App_Buro.Model.PieceRechangeReparation;
import org.LahyaniEya.App_Buro.Model.Reparation;
import org.LahyaniEya.App_Buro.Service.PieceRechangeReparationSeviceImpl;
import org.LahyaniEya.App_Buro.Service.ReparationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppBuroApplicationTests {

	 @InjectMocks
    private ReparationServiceImpl reparationService;

    @Mock
    private PieceRechangeReparationSeviceImpl pieceRechangeReparationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateMontantTotalHTX() {
        Reparation reparation = new Reparation();
        reparation.setTarifHMO(50.0);
        reparation.setTempsMO(2);

        PieceRechangeReparation piece1 = new PieceRechangeReparation();
        piece1.setPrixPieceRechangeReparationHTX(100.0);

        PieceRechangeReparation piece2 = new PieceRechangeReparation();
        piece2.setPrixPieceRechangeReparationHTX(200.0);

        List<PieceRechangeReparation> pieces = Arrays.asList(piece1, piece2);

        when(pieceRechangeReparationService.findByReparation(reparation)).thenReturn(pieces);

        double montantHTX = reparationService.calculateMontantTotalHTX(reparation);

        assertEquals(400.0, montantHTX, "Le montant HTX devrait être égal à 400.0");
    }

	@Test
	void testCalculateMontantTotalTVA() {
		// Préparer les données
		Reparation reparation = new Reparation();
		reparation.setTarifHMO(50.0);
		reparation.setTempsMO(2);
	
		PieceRechangeReparation piece1 = new PieceRechangeReparation();
		piece1.setPrixPieceRechangeReparationHTX(100.0);
	
		PieceRechangeReparation piece2 = new PieceRechangeReparation();
		piece2.setPrixPieceRechangeReparationHTX(200.0);
	
		List<PieceRechangeReparation> pieces = Arrays.asList(piece1, piece2);
	
		when(pieceRechangeReparationService.findByReparation(reparation)).thenReturn(pieces);
	
		double montantTVA = reparationService.calculateMontantTotalTVA(reparation);
	
		assertEquals(76.0, montantTVA, "Le montant TVA devrait être égal à 76.0");
	}
	

	@Test
	void testCalculateMontantTotalTTC() {
		Reparation reparation = new Reparation();
		reparation.setTarifHMO(50.0);
		reparation.setTempsMO(2);
	
		PieceRechangeReparation piece1 = new PieceRechangeReparation();
		piece1.setPrixPieceRechangeReparationHTX(100.0);
	
		PieceRechangeReparation piece2 = new PieceRechangeReparation();
		piece2.setPrixPieceRechangeReparationHTX(200.0);
	
		List<PieceRechangeReparation> pieces = Arrays.asList(piece1, piece2);
	
		when(pieceRechangeReparationService.findByReparation(reparation)).thenReturn(pieces);
	
		double montantTTC = reparationService.calculateMontantTotalTTC(reparation);
	
		assertEquals(476.0, montantTTC, "Le montant TTC devrait être égal à 476.0");
	}

	
}	
