package com.adp.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.adp.constants.CurrencyInfo;

@Service
public class CoinDispenserService {

	private static int quarters, dimes, nickels, pennies;
	private int amountInPaise = 0;
	private final Logger LOGGER = Logger.getLogger(CoinDispenserService.class.getName());

	public String getCoins(int amount) {
		// convert $ to pennies

		amountInPaise = amount * 100;
		quarters = getquarters(amountInPaise);

		dimes = getDimes(amountInPaise);
		nickels = getNickels(amountInPaise);

		pennies = getPennies(amountInPaise);

		
		LOGGER.info("Coins Details :Quarters: " + quarters + "  Dime: " + dimes + "   Nickels: " + nickels
				+ "   Pennies: " + pennies);
		
		LOGGER.info("Coins Left  :Quarters: " + CurrencyInfo.quartersLeft + "  Dime: " + CurrencyInfo.dimesLeft
				+ "   Nickels: " + CurrencyInfo.nickelsLeft + "   Pennies: " + CurrencyInfo.penniesLeft);

		return "Quarters: " + quarters + "  Dime: " + dimes + "   Nickels: " + nickels + "   Pennies: " + pennies;

	}

	public String getMostNumberOfCoins(int amount) {
		// convert $ to pennies

		amountInPaise = amount * 100;
		pennies = getPennies(amountInPaise);
		nickels = getNickels(amountInPaise);
		dimes = getDimes(amountInPaise);
		quarters = getquarters(amountInPaise);

	
		LOGGER.info("Coins Details :Quarters: " + quarters + "  Dime: " + dimes + "   Nickels: " + nickels
				+ "   Pennies: " + pennies);
		
		LOGGER.info("Coins Left  :Quarters: " + CurrencyInfo.quartersLeft + "  Dime: " + CurrencyInfo.dimesLeft
				+ "   Nickels: " + CurrencyInfo.nickelsLeft + "   Pennies: " + CurrencyInfo.penniesLeft);


		return "Quarters: " + quarters + "  Dime: " + dimes + "   Nickels: " + nickels + "   Pennies: " + pennies;

	}

	private int getPennies(int amount) {
		if (CurrencyInfo.penniesLeft == 0 || amountInPaise == 0) {
			return 0;
		}
		int maxquartersRequired = amount;
		if (maxquartersRequired <= CurrencyInfo.penniesLeft) {
			amountInPaise = amount % (1 * maxquartersRequired);
			CurrencyInfo.penniesLeft = CurrencyInfo.penniesLeft - maxquartersRequired;

		} else {
			maxquartersRequired = maxquartersRequired - CurrencyInfo.penniesLeft;
			amountInPaise = amount % (1 * CurrencyInfo.penniesLeft);
			CurrencyInfo.penniesLeft = 0;

		}
		return maxquartersRequired;
	}

	private int getNickels(int amount) {
		if (CurrencyInfo.nickelsLeft == 0 || amountInPaise == 0) {
			return 0;
		}
		int maxquartersRequired = amount / 5;
		if (maxquartersRequired <= CurrencyInfo.nickelsLeft) {
			amountInPaise = amount % (5 * maxquartersRequired);
			CurrencyInfo.nickelsLeft = CurrencyInfo.nickelsLeft - maxquartersRequired;

		} else {
			maxquartersRequired = maxquartersRequired - CurrencyInfo.nickelsLeft;
			amountInPaise = amount % (5 * CurrencyInfo.nickelsLeft);
			CurrencyInfo.nickelsLeft = 0;

		}
		return maxquartersRequired;
	}

	private int getDimes(int amount) {
		if (CurrencyInfo.dimesLeft == 0 || amountInPaise == 0) {
			return 0;
		}
		int maxquartersRequired = amount / 10;
		if (maxquartersRequired <= CurrencyInfo.dimesLeft) {
			amountInPaise = amount % (10 * maxquartersRequired);
			CurrencyInfo.dimesLeft = CurrencyInfo.dimesLeft - maxquartersRequired;

		} else {
			maxquartersRequired = maxquartersRequired - CurrencyInfo.dimesLeft;
			amountInPaise = amount % (10 * CurrencyInfo.dimesLeft);
			CurrencyInfo.dimesLeft = 0;

		}
		return maxquartersRequired;
	}

	private int getquarters(int amount) {
		if (CurrencyInfo.quartersLeft == 0 || amountInPaise == 0) {
			return 0;
		}
		int maxquartersRequired = amount / 25;
		if (maxquartersRequired <= CurrencyInfo.quartersLeft) {
			amountInPaise = amount % (25 * maxquartersRequired);
			CurrencyInfo.quartersLeft = CurrencyInfo.quartersLeft - maxquartersRequired;

		} else {
			maxquartersRequired = maxquartersRequired - CurrencyInfo.quartersLeft;
			amountInPaise = amount % (25 * CurrencyInfo.quartersLeft);
			CurrencyInfo.quartersLeft = 0;

		}
		return maxquartersRequired;
	}

}
