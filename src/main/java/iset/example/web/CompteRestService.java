package iset.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iset.example.dao.CompteRepository;
import iset.example.dao.UserRepository;
import iset.example.entities.Compte;
import iset.example.entities.User;

@RestController
public class CompteRestService {
	@Autowired
	private CompteRepository compteRepository;
	
	@RequestMapping(value="/compte",method = RequestMethod.GET)
	@GetMapping
	public List<Compte> getComptes(){
		return compteRepository.findAll();
		}
	
	@RequestMapping(value="/compte/{id}",method = RequestMethod.GET)
    public Compte getCompte(@PathVariable Integer id) {
		return compteRepository.findById(id).get();
	}
	
	@PostMapping("/compte")
	public Compte AddCompte(@RequestBody Compte c){
    	return compteRepository.save(c);
	}
	
	@RequestMapping(value="/compte/{idC}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCompte(@PathVariable Integer idC) {
			compteRepository.deleteById(idC);
	}
	
	
	@RequestMapping(value="/compte/{idC}",method = RequestMethod.PUT)
	public Compte EditCompte(@PathVariable Integer idC, @RequestBody Compte compte){
		return compteRepository.save(compte);
    }

	
}
