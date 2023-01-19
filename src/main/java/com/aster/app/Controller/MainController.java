package com.aster.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aster.app.Entity.Cart;
import com.aster.app.Entity.Product;
import com.aster.app.Service.CartService;
import com.aster.app.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ecommerce")
public class MainController {
	@Autowired
	ProductService per;
	@Autowired
	CartService cer;
	
	@PostMapping("/createProduct")
	public ResponseEntity<?> newProduct(@Valid @RequestBody Product product) {
		return new ResponseEntity<Product>(per.createProduct(product), HttpStatus.CREATED); 
	}	
	@GetMapping("/getProduct/{product_id}")
	public ResponseEntity<?> getProduct(@Valid @PathVariable int product_id)
	{
		return new ResponseEntity<Product>(per.getProduct(product_id),HttpStatus.OK);
	}
	@GetMapping("/getProducts")
	public ResponseEntity<?> displayAllProduct()
	{
		return new ResponseEntity<List<Product>>(per.getAllProducts(),HttpStatus.OK);
	}
	
	@PostMapping("/createCart")
	public ResponseEntity<?> newCart(@Valid @RequestBody Cart cart) {
		return new ResponseEntity<Cart>(cer.createCart(cart), HttpStatus.CREATED); 
	}
	@PostMapping("/addProduct/{productId}/cart/{cartId}")
	public ResponseEntity<?> addNewProduct(@Valid @PathVariable int productId, @Valid @PathVariable int cartId) {
		return new ResponseEntity<Boolean>(cer.addProduct(productId, cartId), HttpStatus.CREATED); 
	}
	@GetMapping("/getCartDetails/{cartId}")
	public ResponseEntity<?> displayAllItems(@Valid @PathVariable int cartId)
	{
		return new ResponseEntity<List<Product>>(cer.getAllItems(cartId), HttpStatus.OK);
	}	
	@PostMapping("/update/increaseQuantity/{productId}/cart/{cartId}")
	public ResponseEntity<?> increase(@Valid @PathVariable int productId, @Valid @PathVariable int cartId)
	{
		return new ResponseEntity<Boolean>(cer.increaseQuantity(productId, cartId), HttpStatus.OK);
	}
	@PostMapping("/update/decreaseQuantity/{productId}/cart/{cartId}")
	public ResponseEntity<?> decrease(@Valid @PathVariable int productId, @Valid @PathVariable int cartId)
	{
		return new ResponseEntity<Boolean>(cer.decreaseQuantity(productId, cartId), HttpStatus.OK);
	}
	@DeleteMapping("/delete/{productId}/cart/{cartId}")
	public ResponseEntity<?> deleteProduct(@Valid @PathVariable int productId, @Valid @PathVariable int cartId)
	{
		return new ResponseEntity<Boolean>(cer.removeProduct(productId, cartId), HttpStatus.OK);
	}
}
