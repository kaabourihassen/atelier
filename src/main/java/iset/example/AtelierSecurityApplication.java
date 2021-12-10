package iset.example;

import iset.example.dao.RoleRepository;
import iset.example.dao.UserRepository;
import iset.example.entities.Role;
import iset.example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AtelierSecurityApplication/* implements CommandLineRunner */{
	@Autowired
	UserRepository userRopository;
	@Autowired
	RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(AtelierSecurityApplication.class, args);
	}

//	@Override
//	public void run(String... args)throws Exception{
//		Set<Role> roles1 = new HashSet<Role>();
//		Set<Role> roles2 = new HashSet<Role>();
//		Role admin = new Role (1,"ADMIN");
//		Role user =new Role(2,"USER");
//		roleRepository.save(admin);
//		roleRepository.save(user);
//		roles1.add(user);
//		User user1 =new User("user","user",roles1);
//		roles2.add(admin);
//		User user2 = new User("admin","admin",roles2);
//		userRopository.save(user1);
//		userRopository.save(user2);
//	}
}
