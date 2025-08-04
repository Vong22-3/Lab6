package sqa.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestwithLEDT{
	
	@ParameterizedTest
	@MethodSource("TestcaseWithLEDT")
	void TestLEDTcase(boolean Offline, boolean Live, boolean Discount , TVPlan.TVPackage Main,int ExpectResult) {
		TVPlan Optional = new TVPlan(Offline, Live, Discount);
		double Result = Optional.pricePerMonth(Main); 
		assertEquals(ExpectResult, Result );
	}
	
	static Stream<Arguments> TestcaseWithLEDT() {
		return Stream.of(
				/// Standard Package
				Arguments.arguments(false, false, false, TVPlan.TVPackage.STANDARD, 150),
				Arguments.arguments(true,  false, false, TVPlan.TVPackage.STANDARD, 250),
				Arguments.arguments(false, true,  false, TVPlan.TVPackage.STANDARD, 250),
				Arguments.arguments(false, false, true,  TVPlan.TVPackage.STANDARD, 100),
				Arguments.arguments(true,  true,  false, TVPlan.TVPackage.STANDARD, 350),
				Arguments.arguments(true,  false, true,  TVPlan.TVPackage.STANDARD, 200),
				Arguments.arguments(false, true,  true,  TVPlan.TVPackage.STANDARD, 200),
				Arguments.arguments(true,  true,  true,  TVPlan.TVPackage.STANDARD, 300),
				/// Premium Package
				Arguments.arguments(false, false, false, TVPlan.TVPackage.PREMIUM, 350),
				Arguments.arguments(true,  false, false, TVPlan.TVPackage.PREMIUM, 450),
				Arguments.arguments(false, true,  false, TVPlan.TVPackage.PREMIUM, 450),
				Arguments.arguments(false, false, true,  TVPlan.TVPackage.PREMIUM, 300),
				Arguments.arguments(true,  true,  false, TVPlan.TVPackage.PREMIUM, 550),
				Arguments.arguments(true,  false, true,  TVPlan.TVPackage.PREMIUM, 400),
				Arguments.arguments(false, true,  true,  TVPlan.TVPackage.PREMIUM, 400),
				Arguments.arguments(true,  true,  true,  TVPlan.TVPackage.PREMIUM, 500),
				/// Family Package
				Arguments.arguments(false, false, false, TVPlan.TVPackage.FAMILY, 450),
				Arguments.arguments(true,  false, false, TVPlan.TVPackage.FAMILY, 450),
				Arguments.arguments(false, true,  false, TVPlan.TVPackage.FAMILY, 550),
				Arguments.arguments(false, false, true,  TVPlan.TVPackage.FAMILY, 400),
				Arguments.arguments(true,  true,  false, TVPlan.TVPackage.FAMILY, 550),
				Arguments.arguments(true,  false, true,  TVPlan.TVPackage.FAMILY, 400),
				Arguments.arguments(false, true,  true,  TVPlan.TVPackage.FAMILY, 500),
				Arguments.arguments(true,  true,  true,  TVPlan.TVPackage.FAMILY, 500)
				);
		
	}
}