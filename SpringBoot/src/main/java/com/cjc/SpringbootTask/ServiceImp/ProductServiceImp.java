package com.cjc.SpringbootTask.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cjc.SpringbootTask.ServiceI.CategoryServiceI;
import com.cjc.SpringbootTask.ServiceI.ProductServiceI;
import com.cjc.SpringbootTask.model.Category;
import com.cjc.SpringbootTask.model.Product;
import com.cjc.SpringbootTask.repository.ProductRepository;
@Service
public class ProductServiceImp implements ProductServiceI{
	@Autowired
	private ProductRepository pr;
	
	@Autowired
	private CategoryServiceI cs;

	@Override
	public Page<Product> getAllProducts(PageRequest of) {
		return pr.findAll(of);
	}

	@Override
	public Product getProductById(Long id) {
		return pr.findById(id).orElseThrow(()-> new RuntimeException("product not found"));
		
	}

	@Override
	public Product createProduct(Product product) {
		Category category = cs.getCategoryById(product.getCategory().getId());
		product.setCategory(category);
		return pr.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product productDetails) {
		Product product=getProductById(id);
		product.setName(productDetails.getName());
	    product.setPrice(productDetails.getPrice());
		product.setCategory(productDetails.getCategory());
		return pr.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
    pr.deleteById(id);
		
	}

}
