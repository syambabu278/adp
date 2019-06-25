package com.adp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adp.constants.CurrencyInfo;
import com.adp.exception.CurrencyDispenserException;

@Service
public class CoinDispenserUtil {

	private int billAmount = 0;
	private List<Integer> billsList = Arrays.asList(1, 2, 5, 10, 20, 50, 100);

	public boolean validateBill(String bill) throws CurrencyDispenserException {

		return valideNumber(bill) && valideBillAmount(billAmount) && checkBalance(billAmount);

	}

	public boolean valideNumber(String bill) throws CurrencyDispenserException {

		try {
			billAmount = Integer.parseInt(bill);
		} catch (NumberFormatException e) {
			throw new CurrencyDispenserException("Invalid Number:" + bill);
		}

		return true;

	}

	private boolean valideBillAmount(int billAmount) throws CurrencyDispenserException {
		if (billsList.contains(billAmount)) {
			return true;
		} else {
			throw new CurrencyDispenserException(
					"Invalid Bill Amount:" + billAmount + ". Bill amount should be following:" + billsList);
		}

	}

	private boolean checkBalance(int billAmount) throws CurrencyDispenserException {
		int amountAvaliable = getAvaliableBalance();
		if (billAmount <= amountAvaliable) {
			return true;
		} else {
			throw new CurrencyDispenserException(
					"Insufficient Balance." + "Maximum available coins is in $ :" + amountAvaliable);
		}

	}

	private int getAvaliableBalance() {
		return (CurrencyInfo.quartersLeft * 25 + CurrencyInfo.dimesLeft * 10 + CurrencyInfo.nickelsLeft * 5
				+ CurrencyInfo.penniesLeft * 1) / 100;

	}

	public void resetCoinsData(int billAmount) {
		CurrencyInfo.resetCoinsData(billAmount);

	}

}
