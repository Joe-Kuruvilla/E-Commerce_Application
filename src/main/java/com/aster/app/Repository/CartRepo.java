package com.aster.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aster.app.Entity.Cart;
import com.aster.app.Entity.Product;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	@Query("Select products from Cart where id=?1")
	public List<Product> findAllProducts(int id);
}
