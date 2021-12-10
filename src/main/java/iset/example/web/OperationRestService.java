package iset.example.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iset.example.dao.CompteRepository;
import iset.example.dao.OperationRepository;
import iset.example.dao.UserRepository;
import iset.example.entities.Compte;
import iset.example.entities.Operation;
import iset.example.entities.User;

@RestController
public class OperationRestService {
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	@RequestMapping(value="/operation",method = RequestMethod.GET)
	@GetMapping
	public List<Operation> getOperations(){
		return operationRepository.findAll();
		}
	
	@RequestMapping(value="/operation/{id}",method = RequestMethod.GET)
    public Operation getOperation(@PathVariable Long id) {
		return operationRepository.findById(id).get();
	}
	
	@PostMapping("/operation")
	public Operation AddOperation(@RequestBody Operation c){
    	return operationRepository.save(c);
	}
	
	@RequestMapping(value="/operation/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteOperation(@PathVariable Long id) {
		operationRepository.deleteById(id);
	}
	
	
	@RequestMapping(value="/operation/{id}",method = RequestMethod.PUT)
	public Operation Editoperation(@PathVariable Long id, @RequestBody Operation operation){
		return operationRepository.save(operation);
    }
	
	
	@RequestMapping(value="/op/{id}",method = RequestMethod.GET)
	@GetMapping
	public List<Operation> getOp(@PathVariable Integer id){
		return operationRepository.findBycode(id);
		}
	
	@RequestMapping(value="/retrait/{id}",method = RequestMethod.GET)
	@GetMapping
	public void retrait(@PathVariable Integer id,@RequestParam double m) throws ResourceNotFoundException{
		
		double r;
		Compte cp=compteRepository.findById(id).get();
		//Operation op= operationRepository.findById(id).get();
		if(cp==null) throw new RuntimeException("Compte Introuvable");
		else {
			
			if(cp.getSolde()>m) {
			r=cp.getSolde()-m;
			cp.setSolde(r);
			compteRepository.save(cp);
			Operation op=new Operation();
			op.setCompte(cp);
			Date date=new Date();
			op.setDateOperation(date);
			op.setMontant(m);
			op.setType(2);
			operationRepository.save(op);
			System.out.println("retrait avec succes");
			} 
			else throw new RuntimeException("le solde est inferieur au montant introduit !!");
			}
	}
	
	

	@RequestMapping(value="/versement/{id}",method = RequestMethod.GET)
	@GetMapping
	public void Versement(@PathVariable Integer id,@RequestParam double m) throws ResourceNotFoundException{
		
		double r;
		Compte cp=compteRepository.findById(id).get();
		//Operation op= operationRepository.findById(id).get();
		if(cp==null) throw new RuntimeException("Compte Introuvable !!");
		else {
			
			r=cp.getSolde()+m;
			cp.setSolde(r);
			compteRepository.save(cp);
			Operation op=new Operation();
			op.setCompte(cp);
			Date date=new Date();
			op.setDateOperation(date);
			op.setMontant(m);
			op.setType(1);
			operationRepository.save(op);
			System.out.println("versement avec succes");
			} 
	}
	
	
	

	@RequestMapping(value="/virement/{id}/{idr}",method = RequestMethod.GET)
	@GetMapping
	public void Virement(@PathVariable Integer id,@PathVariable Integer idr,@RequestParam double m) throws ResourceNotFoundException{

		Compte cp=compteRepository.findById(id).get();
		Compte cpr=compteRepository.findById(idr).get();
		if(cp==null) throw new RuntimeException("Compte Introuvable !!");
		else {
			
			Versement(idr, m);
			retrait(id, m);
			System.out.println("virement avec succes");
			} 
	}
	
	
	
	
}
