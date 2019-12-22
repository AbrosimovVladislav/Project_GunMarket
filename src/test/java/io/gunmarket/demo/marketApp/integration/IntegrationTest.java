package io.gunmarket.demo.marketApp.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

	private TestRestTemplate restTemplate = new TestRestTemplate();
	private HttpHeaders headers = new HttpHeaders();

	private static final String BASE_PATH = "http://localhost:12345/";
	private static final String PRODUCT_PATH = "products";

	/*Test Data*/
	@Value("classpath:allProducts.json")
	private Resource allProductsJson;
	private static final String EMPTY_PARAM_LINE = "";

	@Value("classpath:productsByAddress.json")
	private Resource productsByAddressJson;
	private static final String PRODUCTS_BY_ADDRESS = "?productInShop.shop.address.name=address1";

	@Test
	public void testProductByFilter(){

		Map<String, Resource> filterRestLineAndExpectedJson = new HashMap<>(){{
			put(EMPTY_PARAM_LINE,allProductsJson);
			put(PRODUCTS_BY_ADDRESS,productsByAddressJson);
		}};

		testDataMap(filterRestLineAndExpectedJson);
	}

	private void testDataMap(Map<String , Resource> testMap){
		testMap.forEach(this::compareFiltratedRespWithFile);
	}

	private void compareFiltratedRespWithFile(String filterParams, Resource jsonComparisonFile){
		ResponseEntity<String> response = getProductResponseByFilterParams(filterParams);

		String actual = response.getBody();
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(jsonComparisonFile.getFile().toPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals(actual, expected);
	}

	private ResponseEntity<String> getProductResponseByFilterParams(String paramLine) {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		return restTemplate.exchange(createProductURL(paramLine), HttpMethod.GET, entity, String.class);
	}

	private String createProductURL(String paramLine) {
		return BASE_PATH + PRODUCT_PATH + paramLine;
	}

	private String createURL(String entityPath, String paramLine) {
		return BASE_PATH + entityPath + paramLine;
	}

	private String createURL(String basePath, String entityPath, String paramLine) {
		return basePath + entityPath + paramLine;
	}

}
