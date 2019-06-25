package com.adp.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.AbstractTest;

public class CoinDispenserServiceTest extends AbstractTest {

	@Autowired
	CoinDispenserService coinDispenserService;

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	

	@Test
	public void getLeastCoinsData() throws Exception {
		
		coinDispenserService.getCoins(10);
	}
	
	@Test
	public void getMostCoinsData() throws Exception {
		
		coinDispenserService.getMostNumberOfCoins(10);
	}

}
