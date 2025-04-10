package com.test.ids;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.ids.model.Product;
import com.test.ids.model.Status;
import com.test.ids.service.ProductService;
import com.test.ids.service.StatusService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class IdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdsApplication.class, args);
	}

	// InsertingDummy Data before starting the application
	@Bean
	@Transactional
	CommandLineRunner run(ProductService productService, StatusService statusService) {
		return args -> {
			// Dummy Product Status
			Status success = new Status(0, "SUCCESS");
			Status failed = new Status(1, "FAILED");
			statusService.addListStatus(List.of(success, failed));
			
			// Format Tanggal
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			// Dummy Product Data
			List<Product> products = List.of(
					new Product(null, "10001", "Test 1", 1000, "abc", success,
									sdf.parse("2022-07-10 11:14:52"), "abc", sdf.parse("2022-07-10 11:14:52")),
					new Product(null, "10002", "Test 2", 2000, "abc", success,
									sdf.parse("2022-07-11 13:14:52"), "abc", sdf.parse("2022-07-10 13:14:52")),
					new Product(null, "10001", "Test 1", 1000, "abc", success,
									sdf.parse("2022-08-10 12:14:52"), "abc", sdf.parse("2022-07-10 12:14:52")),
					new Product(null, "10002", "Test 2", 1000, "abc", failed,
									sdf.parse("2022-08-10 13:10:52"), "abc", sdf.parse("2022-07-10 13:10:52")),
					new Product(null, "10001", "Test 1", 1000, "abc", success,
									sdf.parse("2022-08-10 13:11:52"), "abc", sdf.parse("2022-07-10 13:11:52")),
					new Product(null, "10002", "Test 2", 2000, "abc", success,
									sdf.parse("2022-08-12 13:14:52"), "abc", sdf.parse("2022-07-10 13:14:52")),
					new Product(null, "10001", "Test 1", 1000, "abc", success,
									sdf.parse("2022-08-12 14:11:52"), "abc", sdf.parse("2022-07-10 14:11:52")),
					new Product(null, "10002", "Test 2", 1000, "abc", failed,
									sdf.parse("2022-09-13 11:14:52"), "abc", sdf.parse("2022-07-10 11:14:52")),
					new Product(null, "10001", "Test 1", 1000, "abc", success,
									sdf.parse("2022-09-13 13:14:52"), "abc", sdf.parse("2022-07-10 13:14:52")),
					new Product(null, "10002", "Test 2", 2000, "abc", success,
									sdf.parse("2022-09-14 09:11:52"), "abc", sdf.parse("2022-07-10 09:11:52")),
					new Product(null, "10001", "Test 1", 1000, "abc", success,
									sdf.parse("2022-09-14 10:14:52"), "abc", sdf.parse("2022-07-10 10:14:52")),
					new Product(null, "10002", "Test 2", 1000, "abc", failed,
									sdf.parse("2022-08-15 13:14:52"), "abc", sdf.parse("2022-07-10 13:14:52"))
			);
			productService.addListProduct(products);

		};
	}
}
