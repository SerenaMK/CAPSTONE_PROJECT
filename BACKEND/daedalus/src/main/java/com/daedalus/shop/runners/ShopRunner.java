package com.daedalus.shop.runners;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.daedalus.auth.entity.ERole;
import com.daedalus.auth.entity.Role;
import com.daedalus.auth.entity.User;
import com.daedalus.auth.repository.RoleRepository;
import com.daedalus.auth.runner.AuthRunner;
import com.daedalus.shop.models.Account;
import com.daedalus.shop.models.Cart;
import com.daedalus.shop.models.Category;
import com.daedalus.shop.models.Favorites;
import com.daedalus.shop.models.Order;
import com.daedalus.shop.models.OrderHistory;
import com.daedalus.shop.models.Product;
import com.daedalus.shop.services.AccountService;
import com.daedalus.shop.services.CartService;
import com.daedalus.shop.services.CategoryService;
import com.daedalus.shop.services.FavoritesService;
import com.daedalus.shop.services.OrderHistoryService;
import com.daedalus.shop.services.OrderService;
import com.daedalus.shop.services.ProductService;
import com.daedalus.shop.services.UserService;

@Component
public class ShopRunner implements ApplicationRunner {
	
	@Autowired ProductService productService;
	@Autowired AccountService accountService;
	@Autowired CartService cartService;
	@Autowired FavoritesService favoritesService;
	@Autowired OrderHistoryService ohService;
	@Autowired OrderService orderService;
	@Autowired UserService userService;
	@Autowired CategoryService categoryService;
	@Autowired RoleRepository roleRepo;
	@Autowired PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ShopRunner...");
		
		////////////// USERS + PRODUCTS //////////////
		
//		Optional<Role> ad = roleRepo.findByRoleName(ERole.ROLE_ADMIN);
//		Optional<Role> mo = roleRepo.findByRoleName(ERole.ROLE_MODERATOR);
//		Optional<Role> us = roleRepo.findByRoleName(ERole.ROLE_USER);
//		Set<Role> adminRole;
//		Set<Role> moderatorRole;
//		Set<Role> userRole;
//		adminRole = new HashSet<Role>();
//		adminRole.add(ad.get());
//		adminRole.add(mo.get());
//		adminRole.add(us.get());
//		moderatorRole = new HashSet<Role>();
//		moderatorRole.add(mo.get());
//		moderatorRole.add(us.get());
//		userRole = new HashSet<Role>();
//		userRole.add(us.get());
//		User u1 = new User("Mario", "Rossi", "mariorossi", "m.rossi@example.com", passwordEncoder.encode("mario"), adminRole);
//		User u2 = new User("Luigi", "Verdi", "luigiverdi", "l.verdi@example.com", passwordEncoder.encode("luigi"), moderatorRole);
//		User u3 = new User("Anna", "Bianchi", "annabianchi", "a.bianchi@example.com", passwordEncoder.encode("anna"), userRole);
//		userService.createUser(u1);
//		userService.createUser(u2);
//		userService.createUser(u3);
		
//		Category c1 = new Category("Cooking");
//		Category c2 = new Category("Cleaning");
//		Category c3 = new Category("Washing");
//		Category c4 = new Category("Cheap");
//		Category c5 = new Category("Portable");
//		Category c6 = new Category("Faucet compatible");
//		Category c7 = new Category("Dishwashing");
//		categoryService.createCategory(c1);
//		categoryService.createCategory(c2);
//		categoryService.createCategory(c3);
//		categoryService.createCategory(c4);
//		categoryService.createCategory(c5);
//		categoryService.createCategory(c6);
//		categoryService.createCategory(c7);
		Category c1 = categoryService.getCategoryByName("Cooking");
		Category c2 = categoryService.getCategoryByName("Cleaning");
		Category c3 = categoryService.getCategoryByName("Washing");
		Category c4 = categoryService.getCategoryByName("Cheap");
		Category c5 = categoryService.getCategoryByName("Portable");
		Category c6 = categoryService.getCategoryByName("Faucet compatible");
		Category c7= categoryService.getCategoryByName("Dishwashing");
		
//		Product p1 = new Product("Candy Dishwasher", "Dishwasher", "Candy", "https://d15v10x8t3bz3x.cloudfront.net/Immagini/2021/1/16104493/640-1_32002245_12_01_f_cdcp%206-M.jpg", 270, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		p1.addCategory(c3);
//		p1.addCategory(c4);
//		p1.addCategory(c5);
//		p1.addCategory(c6);
//		p1.addCategory(c7);
//		Product p2 = new Product("Bosch Dishwasher", "Dishwasher", "Bosch", "https://media.adeo.com/marketplace/MKP/82561454/ee2a8dcd9d915ac6fe04317b666b584a.jpeg", 250, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", false);
//		p2.addCategory(c3);
//		p2.addCategory(c4);
//		p2.addCategory(c6);
//		p2.addCategory(c7);
//		Product p3 = new Product("Bosch Washing Machine", "Washing Machine", "Bosch", "https://images.eprice.it/nobrand/0/hres/755/210214755/DAM210214755-1-1f330484-3b1b-45d0-b879-0f1b7942412b.jpg", 300, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		p3.addCategory(c3);
//		Product p4 = new Product("Candy Dryer", "Dryer", "Candy", "https://www.tuttopiubasso.com/wp-content/uploads/2022/10/Sfondo-copia-2-9.jpg", 350, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", false);
//		p4.addCategory(c3);
		
//		Product p5 = new Product("Instant Pot Pro Crisp", "Cooker", "Instant Pot", "https://m.media-amazon.com/images/I/71yqU7aFivL._AC_SX679_.jpg", 290, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		Product p6 = new Product("Instant Pot Duo", "Cooker", "Instant Pot", "https://m.media-amazon.com/images/I/81MXavhztlL._AC_SX679_.jpg", 100, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		Product p7 = new Product("Crockpot 7", "Cooker", "Crock-Pot", "https://m.media-amazon.com/images/I/71QiJA0+zQL._AC_SX679_.jpg", 60, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		Product p8 = new Product("Hamilton Beach 33861", "Cooker", "Hamilton Beach", "https://m.media-amazon.com/images/I/81XQGUCdMaL._AC_SX679_.jpg", 80, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", false);
//		Product p9 = new Product("Russell Hobbs Multicooker", "Cooker", "Russell Hobbs", "https://m.media-amazon.com/images/I/712sAQ7iFoS._AC_SX679_.jpg", 100, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		Product p10 = new Product("Magnetic Digital Timer", "Timer", "Houdian", "https://m.media-amazon.com/images/I/413wSPVV6JL.__AC_SX300_SY300_QL70_ML2_.jpg", 8, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		p10.addCategory(c4);
//		Product p11 = new Product("Nobenx Kitchen Timer Egg", "Timer", "Nobenx", "https://m.media-amazon.com/images/I/51eNXGtz0fL._AC_SL1500_.jpg", 15, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		Product p12 = new Product("SOLUSTRE Hand Mixer Timer Egg", "Timer", "SOLUSTRE", "https://m.media-amazon.com/images/I/51+X6b1YSJL._AC_SL1500_.jpg", 20, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", false);
//		Product p13 = new Product("Pilipane Kitchen Timer", "Timer", "Pilipane", "https://m.media-amazon.com/images/I/515viZJ7DCS._AC_SL1500_.jpg", 15, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		Product p14 = new Product("KD Home Kitchen Timer", "Timer", "KD Home", "https://m.media-amazon.com/images/I/61BV1UeublL._AC_SL1500_.jpg", 10, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		Product p15 = new Product("UD Apple Kitchen Timer", "Timer", "U/D", "https://m.media-amazon.com/images/I/61cchsEiByL._AC_SL1500_.jpg", 13, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
//		Product p16 = new Product("Exbrith Bear Kitchen Timer", "Timer", "Exbrith", "https://m.media-amazon.com/images/I/51iBhCzLDwL._AC_SL1500_.jpg", 10, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
		
//		Product p17 = new Product("", null, null, null, 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
		
//		productService.createProduct(p1);
//		productService.createProduct(p2);
//		productService.createProduct(p3);
//		productService.createProduct(p4);
		
//		productService.createProduct(p5);
//		productService.createProduct(p6);
//		productService.createProduct(p7);
//		productService.createProduct(p8);
//		productService.createProduct(p9);
//		productService.createProduct(p10);
//		productService.createProduct(p11);
//		productService.createProduct(p12);
//		productService.createProduct(p13);
//		productService.createProduct(p14);
//		productService.createProduct(p15);
//		productService.createProduct(p16);
		
		
		
		////////////////////////// TEST ////////////////////////////
		
		System.out.println("----------------------------");
		
		Product p1 = productService.getProductById(1l);
		Product p2 = productService.getProductById(2l);
//		Product p3 = productService.getProductById(3l);
//		Product p4 = productService.getProductById(4l);
//		p1.removeCategory(c7);
//		p2.removeCategory(c7);
//		p1.addCategory(c7);
//		p2.addCategory(c7);
		
//		productService.updateProduct(p1);
//		productService.updateProduct(p2);
		
		// PRINT LIST OF PRODUCTS
//		List<Product> l = c1.getProducts();
//		l.forEach(p -> System.out.println(p));
		
		// TURN CART INTO ORDER
//		Order o1 = new Order(oh1, c1);
//		orderService.createOrder(o1);
		
		// GET PRODUCT BY CATEGORY
		List<Product> l = productService.getProductsByCategoryName("Washing");
		l.forEach(p -> System.out.println(p));
		
		System.out.println("----------------------------");
		
		//////////////////////////////////////////////////////////////
		
	}

}
