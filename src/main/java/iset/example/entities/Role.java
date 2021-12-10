package iset.example.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import iset.example.entities.*;;

@Entity
public class Role {
	   @Id
       @Column(name = "role_id")
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Integer id;
       private String name;
       
       
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "roles")
	@JsonIgnore
    private Set<User> users=new HashSet<>();


	public Role(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Role(Integer id, String name, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
	
}

