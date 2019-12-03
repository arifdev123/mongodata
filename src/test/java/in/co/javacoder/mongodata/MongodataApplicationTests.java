package in.co.javacoder.mongodata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.co.javacoder.mongodata.model.Product;
import in.co.javacoder.mongodata.repository.ProductRepository;

@SpringBootTest
class MongodataApplicationTests {
	
	@Autowired
	ProductRepository productRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testSave() {
		
		List<Product> products = new ArrayList<Product>();
		
		
		Product macbook = new Product();
		macbook.setName("macbook");
		macbook.setPrice(2000f);
		products.add(macbook);
		
		
		Product iphone = new Product();
		iphone.setName("iphone");
		iphone.setPrice(1000f);
		products.add(iphone);
		
		Product IWatch = new Product();
		IWatch.setName("IWatch");
		IWatch.setPrice(1200f);
		products.add(IWatch);
		
		List<Product> savedProducts = productRepo.saveAll(products);
		
		savedProducts.forEach(p -> System.out.println(p.getPrice()));
		
		//Product savedProduct = productRepo.save(products);
		
		assertNotNull(savedProducts);
		
	}
	
	@Test
	public void testFindAll() {
		List<Product> products = productRepo.findAll();
		assertEquals(1, products.size());
	}
	
	@Test
	public void testDelete() {
		productRepo.deleteById("5dab166bbae3b31cf6c85b48");
	}
	
	@Test
	public void testFindByName() {
		List<Product> products = productRepo.findByName("iphone");
		
		products.forEach(p -> {
			System.out.print(p.getId() + "\t");
			System.out.print(p.getName() + "\t");
			System.out.println(p.getPrice());
		
		
		});
	}

}
