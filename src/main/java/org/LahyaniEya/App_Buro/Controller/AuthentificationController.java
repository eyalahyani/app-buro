package org.LahyaniEya.App_Buro.Controller;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.Authentification;
import org.LahyaniEya.App_Buro.Service.AuthentificationServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("") 
public class AuthentificationController {
	@Autowired @NonNull
	private AuthentificationServImpl authentificationServImpl;
	
	@GetMapping("/allEmploye")
	public List<Authentification> findAllEmploye(){
		return authentificationServImpl.findAllAuthentification();
	}
	
	@PostMapping("/addEmploye")
	public Authentification addAuthentification(@RequestBody Authentification authentification) {
		return authentificationServImpl.addAuthentification(authentification);
	}
	
	@GetMapping("/{id}")
	public Authentification findEmployeById(@PathVariable Long id){
		return authentificationServImpl.findById(id);
	}
	
	@GetMapping("")
	public int findRoleByAuthen(@RequestBody Authentification authentification) {
		return authentificationServImpl.findAuthentificationByRole(authentification);
	}
	
	@PutMapping("/updateAuthentification")
	public Authentification updateAuthentification(@RequestBody Authentification authentification) {
		return authentificationServImpl.updateAuthentification(authentification);
	}
	@DeleteMapping("/deleteAuthentifiaction/{id}")
	public void deleteAuthentification(@PathVariable Long id) {
		 authentificationServImpl.deleteAuthentification(id);
	}
@PostMapping("/login")
public ResponseEntity<String> authenticateUser(@RequestBody Authentification authRequest) {
    try {
        Authentification auth = authentificationServImpl.findByEmailAndMdp(authRequest.getEmail(), authRequest.getMdp());
        if (auth != null) {
            String roleMessage = auth.getRole() == 1 ? "Role 1: Technician" : "Role 0: Client";
            return ResponseEntity.ok(roleMessage);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
}

}
