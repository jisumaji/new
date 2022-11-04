package com.realestateapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

class ApartmentRaterTest {

	@ParameterizedTest(name = "Area{0}, Price{1}, Rate{2}")
	@CsvFileSource(resources = "/aps.csv", numLinesToSkip = 1)
	void rateApartmentTest(double area, BigDecimal price, int rate) {
		Apartment apartment = new Apartment(area, price);
		assertEquals(rate, ApartmentRater.rateApartment(apartment));
	}

	static Stream<Arguments> data() {
		List<Apartment> apartments = new ArrayList<>();
		double avg = 0;
		for (int i = 0; i < 3; i++) {
			Apartment apartment = new RandomApartmentGenerator().generate();
			apartments.add(apartment);
			avg = ApartmentRater.calculateAverageRating(apartments);
		}
		List<Apartment> apartments1 = new ArrayList<>();
		double avg1 = 0;
		for (int i = 0; i < 3; i++) {
			Apartment apartment = new RandomApartmentGenerator().generate();
			apartments1.add(apartment);
			avg1 = ApartmentRater.calculateAverageRating(apartments1);
		}
		List<Apartment> apartments2 = new ArrayList<>();
		double avg2 = 0;
		for (int i = 0; i < 3; i++) {
			Apartment apartment = new RandomApartmentGenerator().generate();
			apartments2.add(apartment);
			avg2 = ApartmentRater.calculateAverageRating(apartments2);
		}
		return Stream.of(Arguments.of(apartments, avg), Arguments.of(apartments1, avg1),
				Arguments.of(apartments2, avg2),Arguments.of(new ArrayList<Apartment>(),0));
	}

	@ParameterizedTest
	@MethodSource("data")
	void calculateAverageRatingTest(List<Apartment> apartments,double average) {
		Executable executable=()->ApartmentRater.calculateAverageRating(apartments);
		if(apartments.isEmpty())
			assertThrows(RuntimeException.class,executable);
		else
		assertEquals(average, ApartmentRater.calculateAverageRating(apartments));
	}
}
