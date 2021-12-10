package iset.example.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "USER")
public class User implements Serializable , UserDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer userId;
private String username;
private String password;

@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
@JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "userId"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
        )
private Set<Role> roles = new HashSet<>();




public User(String username, String password, Set<Role> roles) {
	super();
	this.username = username;
	this.password = password;
	this.roles = roles;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getUserId() {
return userId;
}
public void setUserId(Integer userId) {
this.userId = userId;
}

public String getUsername() {
	return username;
	}

	@Override
	public boolean isAccountNonExpired() {
	return false;
	}
	
	@Override
	public boolean isAccountNonLocked() {
	return false;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
	return false;
	}
	
	@Override
	public boolean isEnabled() {
	return false;
	}
	
	public void setUsername(String username) {
	this.username = username;
	}
	
	public String getPassword() {
		return password;
		}
		public void setPassword(String password) {
		this.password = password;
		}
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		
		
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = this.getRoles();           
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		            
		            for (Role role : roles) {
		                authorities.add(new SimpleGrantedAuthority(role.getName()));
		            }
		            
		            return authorities;
	}
	
	
	}

