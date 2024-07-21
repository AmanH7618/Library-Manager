package com.library.Library;

import com.library.Library.Security.AdminSecurity.SecurityConfigAdmin;
import com.library.Library.Security.PersonSecurity.SecurityConfigPerson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SecurityConfigAdmin.class, SecurityConfigPerson.class})
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
