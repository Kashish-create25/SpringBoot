package com.cjc.SpringbootTask.ServiceI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cjc.SpringbootTask.model.Product;
 
public interface ProductServiceI {

	Page<Product> getAllProducts(PageRequest of);

	Product getProductById(Long id);

	Product createProduct(Product product);

	Product updateProduct(Long id, Product productDetails);

	void deleteProduct(Long id);

}
