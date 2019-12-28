package com.adp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adp.exception.CurrencyDispenserException;
import com.adp.service.CoinDispenserService;
import com.adp.service.CoinDispenserUtil;

@RestController
public class CoinDispenserController {
	@Autowired
	private CoinDispenserService coinDispenserService;

	@Autowired
	private CoinDispenserUtil coinDispenserUtil;

	@RequestMapping("/coins")
	@ResponseBody
	public String getCoins(@RequestParam(value = "amount") String amount,
			@RequestParam(value = "amountType", defaultValue = "least") String amountType) {

		try {
			boolean isValid = coinDispenserUtil.validateBill(amount);
			int billAmount = Integer.parseInt(amount);
			if (amountType.equalsIgnoreCase("least")) {
				return coinDispenserService.getCoins(billAmount);
			} else {
				return coinDispenserService.getMostNumberOfCoins(billAmount);
			}
		} catch (CurrencyDispenserException e) {
			return e.getErrorMessage();
		}

	}
	
	/**
	 * This will reset amount
	 * @param coins
	 * @return
	 */

	@RequestMapping(value ="/coinslimit",method = RequestMethod.POST)
	@ResponseBody
	public String setMaxCoins(@RequestParam(value = "coins") String coins) {

		try {
			boolean isValid = coinDispenserUtil.valideNumber(coins);
			int billAmount = Integer.parseInt(coins);
			coinDispenserUtil.resetCoinsData(billAmount);
			return "Updated successfully";
		} catch (CurrencyDispenserException e) {
			return e.getErrorMessage();
		}

	}

}
