package GDSC.Backend4th;

import GDSC.Backend4th.Repository.Member;
import GDSC.Backend4th.Repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class Backend4thApplication {

	public static void main(String[] args) {
		SpringApplication.run(Backend4thApplication.class, args);
	}

}
