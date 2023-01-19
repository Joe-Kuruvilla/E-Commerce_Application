package com.aster.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aster.app.Entity.Cart;
import com.aster.app.Entity.Product;
import com.aster.app.Repository.CartRepo;
import com.aster.app.Repository.ProductRepo;

@Service
public class CartService {
	@Autowired
	CartRepo rep;
	@Autowired 
	ProductRepo per;
	
	public Cart createCart(Cart cart) {
		return rep.save(cart);
	}
	
	public boolean addProduct(int product_id, int cart_id)
	{
		Product pp=per.findById(product_id).get();
		Cart cc=rep.findById(cart_id).get();
		cc.getProducts().add(pp);
		rep.save(cc);
		return true;
	}
	public List<Product> getAllItems(int cart_id)
	{
		return rep.findAllProducts(cart_id);
	}
	public boolean removeProduct(int product_id, int cart_id)
	{
		Product pp=per.findById(product_id).get();
		Cart cc=rep.findById(cart_id).get();
		cc.getProducts().remove(pp);
		rep.save(cc);
		return true;
	}
	public boolean increaseQuantity(int product_id, int cart_id)
	{
		Product pp=per.findById(product_id).get();
		Cart cc=rep.findById(cart_id).get();
		cc.getProducts().remove(pp);
		
		pp.setQuantity(pp.getQuantity()+1);
		per.save(pp);
		
		cc.getProducts().add(pp);
		rep.save(cc);
		return true;
	}
	public boolean decreaseQuantity(int product_id, int cart_id)
	{
		Product pp=per.findById(product_id).get();
		Cart cc=rep.findById(cart_id).get();
		cc.getProducts().remove(pp);
		
		pp.setQuantity(pp.getQuantity()-1);
		per.save(pp);
		
		cc.getProducts().add(pp);
		rep.save(cc);
		return true;
	}
}
