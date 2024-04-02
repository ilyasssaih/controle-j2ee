package ma.enset.studentsapp;

import ma.enset.studentsapp.entities.Product;
import ma.enset.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null, "computer", 3000, 1));
		productRepository.save(new Product(null, "printer", 2000, 2));
		productRepository.save(new Product(null, "mouse", 777, 3));
		List<Product> products = productRepository.findAll();
		products.forEach(p -> {
			System.out.println(p.toString());
		});

		Product product;
		product = productRepository.findById(Long.valueOf(2)).get();
		System.out.println("***********");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQuantity());
		List<Product> productList = productRepository.findByNameContains("c");
		productList.forEach(p -> {
			System.out.println(p);
			System.out.println("-------------------------------------------");

		});
		List<Product> productList2 = productRepository.search("%c%");
		productList2.forEach(p -> {
			System.out.println(p);
		});
		List<Product> productList3 = productRepository.findByPriceGreaterThan(2000);
		productList3.forEach(p -> {
			System.out.println(p);
		});
		List<Product> productList4 = productRepository.searchByPrice(2000);
		productList4.forEach(p -> {
			System.out.println(p);
		});
	}

		public static void main (String[] args){
			SpringApplication.run(StudentsAppApplication.class, args);
		}

	}
