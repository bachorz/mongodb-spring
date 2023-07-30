package com.bachorz.mongodbspring;

import com.bachorz.mongodbspring.category.Category;
import com.bachorz.mongodbspring.category.CategoryRepository;
import com.bachorz.mongodbspring.product.Product;
import com.bachorz.mongodbspring.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MongodbSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbSpringApplication.class, args);

	}


//	@Bean
	public CommandLineRunner commandLineRunner(
			ProductRepository productRepository,
			CategoryRepository categoryRepository
	) {
		return args -> {
			var category = Category.builder()
					.name("cat 1")
					.description("cat 1")
					.build();
			var category2 = Category.builder()
					.name("cat 2")
					.description("cat 2")
					.build();
			categoryRepository.insert(category);
			categoryRepository.insert(category2);
			var product = Product.builder()
					.name("Xiaomi")
					.description("sacadwqcwqcwqfqw")
					.build();
			productRepository.insert(product);
		};
	}

}
