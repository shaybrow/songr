package com.shaybrow.songr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.util.AssertionErrors.assertEquals;


//@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testSettersAndGetters(){
		Album test = new Album("", "", 0, 0, "");
		String expectOut = "";
		String trueOut = test.getTitle();
		int expect = 10;
		test.setSongCount(10);
		assertEquals(expect, test.getSongCount());
		test.setArtist("Bonobo");
		trueOut = test.getArtist();
		expectOut = "Bonobo";
		assertEquals(expectOut, trueOut);
		test.setImageUrl("asdf.jpg");
		trueOut = test.getImageUrl();
		expectOut = "asdf.jpg";
		assertEquals(expectOut, trueOut);
		expect = 25000;
		test.setLength(25000);
		assertEquals(expect, test.getLength());


	}

}
