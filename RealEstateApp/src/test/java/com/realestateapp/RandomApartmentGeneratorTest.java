package com.realestateapp;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.RepeatedTest;

class RandomApartmentGeneratorTest {

	@RepeatedTest(10)
//	@CsvSource({"50,6900","30,3000"})
	void generateTest() {
		double area=30+(int)(Math.random()*10);
		BigDecimal price=new BigDecimal(3000+(int)(Math.random()*1000));
		
		RandomApartmentGenerator rg=new RandomApartmentGenerator(area,price);
		BigDecimal maxPricePerSquareMeter = price.multiply(new BigDecimal(4));
		BigDecimal maxPrice=price.multiply(maxPricePerSquareMeter);
		BigDecimal minPrice=price.multiply(new BigDecimal(4));
		assertAll(()->assertTrue(rg.generate().getPrice().compareTo(minPrice)>=0),
				()->assertTrue(rg.generate().getPrice().compareTo(maxPrice)<=0));
	}
}
