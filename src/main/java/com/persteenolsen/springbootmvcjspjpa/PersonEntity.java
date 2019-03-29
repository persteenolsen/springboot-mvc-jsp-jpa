
package com.persteenolsen.springbootmvcjspjpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.persteenolsen.springbootmvcjspjpa.ValidEmail;

 
@Entity
@Table(name = "SpringBootMvcJspJpaPersons")
public class PersonEntity {
 
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
 
    @NotNull
    @Size(min=2, max=30, message="Name must be between 2 and 30 letters")
    @Column(name = "name")
    String name;

    @NotNull
    @ValidEmail(min = 7, max = 30, message = "Please enter a valid email format!")
    @Column(name = "email")
	private String email;
 
    @NotNull
    @Min(value=18, message="Age need to be min 18")
    @Max(value=125, message="Age need to be max 125")
    @Column(name = "age")
    Integer age;
 
    public Long getId() {
        return Id;
    }
 
    public void setId(Long id) {
        Id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 
    public Integer getAge() {
        return age;
    }
 
    public void setAge(Integer age) {
        this.age = age;
    }
 
}