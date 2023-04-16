package com.mohit.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	
	private int id;
	@NotEmpty
	@Size(min = 4,message = "Username must contains four characters")
	private String name;
	@Email(message = "email not valid")
	private String email;
	@NotEmpty
	@Size(min=3,max=10,message = "password must be min of 3 and max of 10 characters")
	private String password;
	@NotEmpty
	private String about;
	
}
