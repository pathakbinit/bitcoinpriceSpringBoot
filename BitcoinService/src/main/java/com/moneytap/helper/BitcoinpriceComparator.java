package com.moneytap.helper;

import java.util.Comparator;

import com.moneytap.entity.BitcoinPriceResponse;

public class BitcoinpriceComparator implements Comparator<BitcoinPriceResponse> {

	@Override
	public int compare(BitcoinPriceResponse o1, BitcoinPriceResponse o2) {
		return (int) (o2.getPrice_close() - o1.getPrice_close());
	}

}
