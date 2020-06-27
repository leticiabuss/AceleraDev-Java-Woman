package br.com.codenation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		
		if(items == null) {
			return 0.0;
		}
		
		Double soma = 0.0; 
		for(OrderItem item : items) {
				
			if(item == null) 
				continue;
			
			if(item.getProductId() == null)
				continue;
			
			if(item.getQuantity() == null)
				continue;
			
			Long idItem = item.getProductId();
			Long qtItem = item.getQuantity();
				
			Optional<Product> Product = productRepository.findById(idItem);
			Double vlItem = 0.0;
			
			if(Product.get().getIsSale() == null)
				continue;
			
			if(Product.get().getIsSale() == false) {
				soma += Product.get().getValue() * qtItem;
			}
			else {
				vlItem = (Product.get().getValue() * qtItem);
				soma += vlItem - (vlItem * 0.20);
			}
			
		}	
		
		return soma;
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		Set<Product> Products = new HashSet<Product>();
		
		ids.stream()
		.filter((id) -> (productRepository.findById(id).isPresent()))
		.forEach((id)-> {
				Products.add(productRepository.findById(id).get());
		});
		return Products;
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		Double soma = 0.0;
		for(List<OrderItem> ordem : orders) {
			
			soma += calculateOrderValue(ordem);
		}
		return soma;
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		Map<Boolean,List<Product>> mapProdutos = new HashMap<>();
		List<Product> listaTrue = new ArrayList<>();
		List<Product> listaFalse = new ArrayList<>();
		
		productIds.stream()
		.filter((product) -> (productRepository.findById(product).isPresent()))
		.filter((product) -> productRepository.findById(product).get().getIsSale())
		.forEach((product) -> {
			listaTrue.add(productRepository.findById(product).get());
		});
		
		productIds.stream()
		.filter((product) -> (productRepository.findById(product).isPresent()))
		.filter((product) -> !productRepository.findById(product).get().getIsSale())
		.forEach((product) -> {
			listaFalse.add(productRepository.findById(product).get());
		});
		
		mapProdutos.put(true, listaTrue);
		mapProdutos.put(false, listaFalse);
		return mapProdutos;
	
	}

}