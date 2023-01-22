package java143;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class collectorClass {

	public static void main(String[] args) {
		List<product1> productsList = new ArrayList<product1>();
		productsList.add(new product1(1, "HP Laptop", 25000f));
		productsList.add(new product1(2, "Dell Laptop", 30000f));
		productsList.add(new product1(3, "Lenevo Laptop", 28000f));
		productsList.add(new product1(4, "Sony Laptop", 28000f));
		productsList.add(new product1(5, "Apple Laptop", 90000f));
		System.out.println();

		// printing the price of the product
		List<String> productPriceList = productsList.stream().filter(p -> p.getPrice() >= 30000).map(p -> p.name)
				.collect(Collectors.toList());
		System.out.println("List of the price : " + productPriceList);
		System.out.println();

		// printing the sumprice of the product

		Double sumPrices = productsList.stream().collect(Collectors.summingDouble(x -> x.price));
		System.out.println("sum of prices : " + sumPrices);
		System.out.println();

		// sum of the id of the data
		Integer sumId = productsList.stream().collect(Collectors.summingInt(x -> x.id));
		System.out.println("sum of id of the product : " + sumId);
		System.out.println();

		// product average price
		Double average = productsList.stream().collect(Collectors.averagingDouble(p -> p.price));
		System.out.println("Average of the salary : " + average);
		System.out.println();

		// counting the product
		Long noOfProduct = productsList.stream().collect(Collectors.counting());
		System.out.println("Total product : " + noOfProduct);
		System.out.println();

		// filtering Operation

		List<Float> ProductPriceList = productsList.stream().filter(p -> p.price > 30000).map(p -> p.price)
				.collect(Collectors.toList());
		System.out.println("Filtered product : " + ProductPriceList);
		System.out.println();

		// Filtering and iterating collection
		productsList.stream().filter(product -> product.price > 3000)
				.forEach(Product -> System.out.println(Product.name));
		System.out.println();

		// count number of products based on the filter
		long count = productsList.stream().filter(product -> product.price > 25000).count();
		System.out.println("count the product : " + count);
		System.out.println();

		// convert list into set
		Set<Float> productPriceList1 = productsList.stream().filter(product -> product.price > 28000)
				.map(product -> product.price).collect(Collectors.toSet());
		System.out.println(productPriceList1);
		System.out.println();

		// converting list into map
		Map<Integer, String> productPriceMap = productsList.stream().collect(Collectors.toMap(p -> p.id, p -> p.name));
		System.out.println(productPriceMap);
		System.out.println();

		// using method reference collect
		List<Float> ProductList = productsList.stream().filter(product -> product.price > 25000).map(product1::getPrice)
				.collect(Collectors.toList());
		System.out.println(ProductList);
		
		List<Integer> ProductIDList = productsList.stream().filter(product -> product.id<=5).map(product1::getId)
				.collect(Collectors.toList());
		System.out.println(ProductIDList);
	}

}
