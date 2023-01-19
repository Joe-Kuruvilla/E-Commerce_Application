package com.aster.app.Entity;

import java.util.ArrayList;
import java.util.List;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart 
{
	@Id
	@GeneratedValue
	private int id;
//	@OneToMany(cascade=CascadeType.ALL)
	@OneToMany
	private List<Product> products=new ArrayList<>();
}
