package com.aster.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aster.app.Entity.Product;
import com.aster.app.Repository.ProductRepo;

@Service
public class ProductService 
{
	@Autowired
	ProductRepo rep;
	
	public Product createProduct(Product product) {
		return rep.save(product);
	}
	public Product getProduct(int id)
	{
		return rep.findById(id).get();
	}
	public List<Product> getAllProducts()
	{
		return (List<Product>) rep.findAll();
	}
}
