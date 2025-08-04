package sqa.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestwithEEDT{
	
	static boolean[] op1 = {false, false, false};
	static boolean[] op2 = {true,  false, false};
	static boolean[] op3 = {false, true,  false};
	static boolean[] op4 = {false, false, true};
	static boolean[] op5 = {true,  true,  false};
	static boolean[] op6 = {true,  false, true};
	static boolean[] op7 = {false, true,  true};
	static boolean[] op8 = {true,  true,  true};
	
	static TVPlan.TVPackage STD = TVPlan.TVPackage.STANDARD;
	static TVPlan.TVPackage PRE = TVPlan.TVPackage.PREMIUM;
	static TVPlan.TVPackage FML = TVPlan.TVPackage.FAMILY;
	
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
				Arguments.arguments(op1[0], op1[1], op1[2], STD, 150),
				Arguments.arguments(op2[0], op2[1], op2[2], STD, 250),
				Arguments.arguments(op3[0], op3[1], op3[2], STD, 250),
				Arguments.arguments(op4[0], op4[1], op4[2], STD, 100),
				Arguments.arguments(op5[0], op5[1], op5[2], STD, 350),
				Arguments.arguments(op6[0], op6[1], op6[2], STD, 200),
				Arguments.arguments(op7[0], op7[1], op7[2], STD, 200),
				Arguments.arguments(op8[0], op8[1], op8[2], STD, 300),
				/// Premium Package
				Arguments.arguments(op1[0], op1[1], op1[2], PRE, 350),
				Arguments.arguments(op2[0], op2[1], op2[2], PRE, 450),
				Arguments.arguments(op3[0], op3[1], op3[2], PRE, 450),
				Arguments.arguments(op4[0], op4[1], op4[2], PRE, 300),
				Arguments.arguments(op5[0], op5[1], op5[2], PRE, 550),
				Arguments.arguments(op6[0], op6[1], op6[2], PRE, 400),
				Arguments.arguments(op7[0], op7[1], op7[2], PRE, 400),
				Arguments.arguments(op8[0], op8[1], op8[2], PRE, 500),
				/// Family Package
				Arguments.arguments(op1[0], op1[1], op1[2], FML, 450),
				Arguments.arguments(op2[0], op2[1], op2[2], FML, 450),
				Arguments.arguments(op3[0], op3[1], op3[2], FML, 550),
				Arguments.arguments(op4[0], op4[1], op4[2], FML, 400),
				Arguments.arguments(op5[0], op5[1], op5[2], FML, 550),
				Arguments.arguments(op6[0], op6[1], op6[2], FML, 400),
				Arguments.arguments(op7[0], op7[1], op7[2], FML, 500),
				Arguments.arguments(op8[0], op8[1], op8[2], FML, 500)
				);
		
	}
}