package io.boksLibrary.user.employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import io.boksLibrary.user.User;

@Entity
@Polymorphism(type = PolymorphismType.EXPLICIT)

public class Employee extends User{
	private String type;

	public Employee() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
