package com.aster.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product 
{
	@Id
	@GeneratedValue
	@Min(value=1, message= "{sku.invalid}")
	private int sku;
	private String name;
	private String description;
	private String ImageUrl;
	private double price;
	@Min(value=1, message= "{quantity.invalid}")
	private int quantity;
	
}
