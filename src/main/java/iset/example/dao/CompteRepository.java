package iset.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import iset.example.entities.Compte;
import iset.example.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Integer> {

}
