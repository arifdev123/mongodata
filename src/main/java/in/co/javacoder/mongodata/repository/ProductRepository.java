package in.co.javacoder.mongodata.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.co.javacoder.mongodata.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findByName(String name);
}
