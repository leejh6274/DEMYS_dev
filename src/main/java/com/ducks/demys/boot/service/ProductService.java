package com.ducks.demys.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducks.demys.boot.repository.ProductRepository;
import com.ducks.demys.boot.repository.Product_AttachRepository;
import com.ducks.demys.boot.vo.Product;

@Service
public class ProductService {
   
   private ProductRepository productRepository;
   private Product_AttachRepository product_AttachRepository;
   
   public ProductService(ProductRepository productRepository, Product_AttachRepository product_AttachRepository) {
	  this.product_AttachRepository=product_AttachRepository;
      this.productRepository= productRepository;
   }
   
   public List<Product> getProductListByPJ_NUM(int PJ_NUM, int PRODUCT_STEP){
      return productRepository.getProductListByPJ_NUM(PJ_NUM, PRODUCT_STEP);
   }

   public List<Product> getSearchProductList(int PJ_NUM, int PRODUCT_STEP, String searchKeywordTypeCode, String searchKeyword) {
      
      List<Product> product = productRepository.getSearchProductList(PJ_NUM, PRODUCT_STEP, searchKeywordTypeCode, searchKeyword);

      return product;
   }
   
   public List<Product> getProductListByOnlyPJ_NUM(int PJ_NUM) {
      return productRepository.getProductListByOnlyPJ_NUM(PJ_NUM);
   }

   public Product getProductByProduct_NUM(int PRODUCT_NUM){
      return productRepository.getProductByPRODUCT_NUM(PRODUCT_NUM);
   }
   
   public void registProduct(Product Product) {
      Product.setPRODUCT_NUM(productRepository.selectProductSequenceNextValue());
      productRepository.registProduct(Product);
      
      if(Product.getProduct_attach() != null) {
    	  Product.getProduct_attach().setPRODUCT_NUM(Product.getPRODUCT_NUM());
    	  product_AttachRepository.registProduct_Attach(Product.getProduct_attach());
      }
   }
   
   public void modifyProduct(Product Product) {
      productRepository.modifyProduct(Product);
   }
   
   public void changeStatusProduct(Product Product) {
      productRepository.changeStatusProduct(Product);
   }
   
   public void removeProduct(int PRODUCT_NUM) {
      productRepository.removeProduct(PRODUCT_NUM);
   }
}