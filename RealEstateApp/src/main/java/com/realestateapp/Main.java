package com.realestateapp;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) {
//		Apartment apartment=new RandomApartmentGenerator().generate();
//		while(ApartmentRater.rateApartment(apartment)!=0){
//			apartment=new RandomApartmentGenerator().generate();
//		}
//		System.out.println(apartment+" " +ApartmentRater.rateApartment(apartment));
////		List<Apartment> apartments= (List<Apartment>){{10,20},{10,20}};
////		apartments.add(new RandomApartmentGenerator().generate());
////		apartments.add(new RandomApartmentGenerator().generate());
////		apartments.add(new RandomApartmentGenerator().generate());
////		System.out.println(apartments);
//		System.out.println((int)(Math.random()*10));
		
		RandomApartmentGenerator r1=new RandomApartmentGenerator();
		RandomApartmentGenerator r2=new RandomApartmentGenerator(50,new BigDecimal(6900));
		double minArea = 50;
		double maxArea = 50 * 4;
		BigDecimal minPricePerSquareMeter=new BigDecimal(6900);
		BigDecimal maxPricePerSquareMeter = minPricePerSquareMeter.multiply(new BigDecimal(4));
		BigDecimal maxPrice=new BigDecimal(6900).multiply(maxPricePerSquareMeter);
		
		System.out.println(r2.generate().getPrice());
		System.out.println(minPricePerSquareMeter);
		System.out.println(maxPricePerSquareMeter);
		System.out.println(maxPrice);
		System.out.println(r2.generate().getPrice().compareTo(minPricePerSquareMeter.multiply(new BigDecimal(4))));
		System.out.println(r2.generate().getPrice().compareTo(maxPrice));
	}
}
