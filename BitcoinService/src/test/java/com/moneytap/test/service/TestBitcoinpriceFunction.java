package com.moneytap.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.moneytap.entity.BitcoinPriceResponse;
import com.moneytap.service.BitcoinpriceFunctions;
import com.moneytap.service.IBitcoinpriceFunctions;

public class TestBitcoinpriceFunction {

	private IBitcoinpriceFunctions bitcoinpriceFunctions;

	@Before
	public void setUp() {
		bitcoinpriceFunctions = new BitcoinpriceFunctions();
	}

	@Test
	public void testAvgBitcoinPrice() {
		List<BitcoinPriceResponse> list = getDummyBitcoinPrices();
		Double avgPrice = bitcoinpriceFunctions.getAvg(list);
		Assert.assertTrue(avgPrice == 7659.67232);

	}

	@Test
	public void testMedianBitcoinPrice() {
		List<BitcoinPriceResponse> list = getDummyBitcoinPrices();
		Double medianPrice = bitcoinpriceFunctions.getMedian(list);
		Assert.assertTrue(medianPrice > 7650);

	}

	private List<BitcoinPriceResponse> getDummyBitcoinPrices() {
		BitcoinPriceResponse bitcoinPriceResponse = new BitcoinPriceResponse();
		bitcoinPriceResponse.setPrice_close(7654.67232);
		bitcoinPriceResponse.setPrice_open(7652.6878);
		bitcoinPriceResponse.setPrice_low(7645.4554);
		BitcoinPriceResponse bitcoinPriceResponse1 = new BitcoinPriceResponse();
		bitcoinPriceResponse1.setPrice_close(7664.67232);
		bitcoinPriceResponse1.setPrice_open(7682.6878);
		bitcoinPriceResponse1.setPrice_low(7675.4554);
		List<BitcoinPriceResponse> bitcoinPriceResponses = new java.util.ArrayList<>();
		bitcoinPriceResponses.add(bitcoinPriceResponse1);
		bitcoinPriceResponses.add(bitcoinPriceResponse);
		return bitcoinPriceResponses;
	}
}
