package iset.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import iset.example.entities.Role;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
