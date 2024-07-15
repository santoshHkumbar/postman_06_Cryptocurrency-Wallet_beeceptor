package CryptocurrencyWallet;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CryptocurrencyWallet {
	
	@Test
	public void Registerauserandcreatehis_herwallet() {
		JSONObject json = new JSONObject();
		json.put("username", "user123");
		json.put("password", "securepassword");
		json.put("email", "user@example.com");
		given().body(json.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/register").then().statusCode(200).log().all();	
		
		
	}
	@Test
	public void Login_the_userandgenerate_session_token() {
		JSONObject json = new JSONObject();
		json.put("username", "user123");
		json.put("password", "securepassword");
	
		given().body(json.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/login").then().statusCode(200).log().all();	
		
		
	}
	@Test
	public void Retrieve_the_wallet_balance() {
		//given the bulid the 
		given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/balance").then().statusCode(200).log().all();
		
	}
	@Test
	public void List_all_the_transactions_done_bytheuser() {
		//given the bulid the 
		given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transactions").then().statusCode(200).log().all();
		
	}

	@Test
	public void Transfer5ETHtoarecipient() {
		JSONObject json = new JSONObject();
		json.put("recipient_address", "0x1234567890ABCDEF");
		json.put("amount", 5.0);
		json.put("currency", "ETH");
		given().body(json.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transactions").then().statusCode(200).log().all();	
		
		
	}
	@Test
	public void Calculatetransactionfeesandreturnestimatedcostt() {
		JSONObject json = new JSONObject();
		json.put("amount", 2.5);
		json.put("currency", "BTC");
		json.put("recipient_address", "0x1234567890ABCDEF");
		given().body(json.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transaction_fee").then().statusCode(200).log().all();	
		
		
	}
	@Test
	public void Getanobjectwithallavailablecurrencyexchangerates() {
		//given the bulid the 
		given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/exchange_rates").then().statusCode(200).log().all();
		
	}

}
