package project.TadeM.Admin.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "admin")
public class Admin{ // 아직 미사용

	@Id
	private String adminEmail;

	private String adminPassword;
	private int adminPrice;

}
