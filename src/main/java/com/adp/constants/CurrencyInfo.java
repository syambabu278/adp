package com.adp.constants;

public class CurrencyInfo {

	public static int penniesLeft = 100, nickelsLeft = 100, dimesLeft = 100, quartersLeft = 100;

	public static void resetCoinsData(int number) {

		penniesLeft = number;
		nickelsLeft = number;
		dimesLeft = number;
		quartersLeft = number;

	}

	public void updatePenniesLeft(int used) {
		penniesLeft = penniesLeft - used;
	}

	public void updateNickelsLeft(int used) {
		nickelsLeft = nickelsLeft - used;
	}

	public void updateDimesLeft(int used) {
		dimesLeft = dimesLeft - used;
	}

	public void updateQuartersLeft(int used) {
		quartersLeft = quartersLeft - used;
	}
}
