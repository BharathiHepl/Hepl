package com.springjava.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springjava.welcome.Login;
import com.springjava.welcome.SignUp;
import com.springjava.model.Order;
import com.springjava.model.Product;
import com.springjava.model.Role;
import com.springjava.model.Stock;
import com.springjava.model.User;
import com.springjava.repository.OrderRepository;
import com.springjava.repository.ProdRepository;
import com.springjava.repository.RoleRepository;
import com.springjava.repository.StockRepository;
import com.springjava.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProdRepository prodRepo;
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody Login login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User login successfully!...", HttpStatus.OK);
    }
    
    
        @PostMapping("/signup")
        public ResponseEntity<?> registerUser(@RequestBody SignUp signUp){
            // checking for username exists in a database
            if(userRepository.existsByUserName(signUp.getUsername())){
                return new ResponseEntity<>("Username is already exist!", HttpStatus.BAD_REQUEST);
            }
            // checking for email exists in a database
            if(userRepository.existsByEmail(signUp.getEmail())){
                return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
            }
            // creating user object
            User user = new User();
            user.setName(signUp.getName());
            user.setUserName(signUp.getUsername());
            user.setEmail(signUp.getEmail());
            user.setPassword(passwordEncoder.encode(signUp.getPassword()));
            Role roles = roleRepository.findByName("ROLE_ADMIN").get();
            user.setRoles(Collections.singleton(roles));
            userRepository.save(user);
            return new ResponseEntity<>("User is registered successfully!", HttpStatus.OK);
        }
        
        @GetMapping("/getstock")
        public List<Stock> getAllStock(){
        	return stockRepository.findAll();
        }
        
        @PutMapping("/product")
    	public ResponseEntity<Product> updateProduct(@PathVariable Integer productid, @RequestBody Product prodDetails){
 
    		Product product = null;
			product.setBrand(prodDetails.getBrand());
    		product.setDescription(prodDetails.getDescription());
    		product.setStock(prodDetails.getStock());
    		product.setSalePrice(prodDetails.getSalePrice());
    		product.setMrp(prodDetails.getMrp());
    		product.setProductId(prodDetails.getProductId());
    		product.setCategoryId(prodDetails.getCategoryId());
    		
    		 
     		System.out.println("products are updated");
    		Product updatedProduct = prodRepo.save(product);
    		return ResponseEntity.ok(updatedProduct);
    	}
        @PostMapping("/orderdetails")
    	public Order createOrderdetails(@RequestBody Order order) {
        	System.out.println("Order details are created.");
    		return orderRepo.save(order);	
    	}
        
}

