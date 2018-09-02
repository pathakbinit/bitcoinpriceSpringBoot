package com.moneytap.test.helper;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.moneytap.entity.BitcoinPriceResponse;
import com.moneytap.helper.BitcoinpriceHelper;

public class TestBitcoinpriceHelper {

	private BitcoinpriceHelper bitcoinpriceHelper;

	@Before
	public void setup() {
		bitcoinpriceHelper = new BitcoinpriceHelper();
	}

	@Test
	public void testGetBitcoinPrice() throws IOException {

		List<BitcoinPriceResponse> bitcoinPriceResponses = bitcoinpriceHelper.getBitcoinPriceInTimeInterval("500");
		Assert.assertTrue(bitcoinPriceResponses.size() > 2);
	}

	@Test(expected = NumberFormatException.class)
	public void testGetBitcoinPriceForNonNumericData() throws IOException {
		List<BitcoinPriceResponse> bitcoinPriceResponses = bitcoinpriceHelper.getBitcoinPriceInTimeInterval("sd");
		Assert.assertTrue(bitcoinPriceResponses.isEmpty());
	}
}
