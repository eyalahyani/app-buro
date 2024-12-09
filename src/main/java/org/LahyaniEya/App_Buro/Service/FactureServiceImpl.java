package org.LahyaniEya.App_Buro.Service;

import java.util.List;
import org.LahyaniEya.App_Buro.Model.Facture;
import org.LahyaniEya.App_Buro.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@NoArgsConstructor
@Transactional(rollbackOn = Exception.class)
@Slf4j
public class FactureServiceImpl implements FactureService {
	@Autowired
	private FactureRepository factureRepo;
	@Autowired
	private ReparationServiceImpl reparationservImp;
	
	@Override
	public List<Facture> findAllFacture() {
        return factureRepo.findAll();
	}

	@Override
	public Facture addFacture(Facture f) {
		f.setMontantTotal(reparationservImp.calculateMontantTotalTTC(f.getReparation()));
		return  factureRepo.save(f);
	}

	@Override
	public Facture findByIdFacture(Long id) {
		return factureRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Facture not found with ID: " + id));
	}

	@Override
	public Facture updateFacture(Facture facture) {
		Facture f=this.findByIdFacture(facture.getId());
        if (f!=null) {
        f.setDate(facture.getDate());
        f.setMontantTotal(facture.getMontantTotal());
        f.setNumero(facture.getNumero());
        f.setReparation(facture.getReparation());
        return this.addFacture(f);
        }
        else {
           return this.addFacture(facture);
        }
      }

	@Override
	public void deleteFacture(Long id) {
		Facture f=this.findByIdFacture(id);
        if (f!=null) {
        	factureRepo.delete(f);
        }		
	}

	@Override
	public Facture findByNumero(String numero) {
		return factureRepo.findByNumero(numero);
	}

	
	
}

