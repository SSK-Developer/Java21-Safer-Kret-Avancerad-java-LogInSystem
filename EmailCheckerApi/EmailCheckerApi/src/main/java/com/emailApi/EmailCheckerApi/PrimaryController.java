package com.emailApi.EmailCheckerApi;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

	@FXML
	Text emailText;
	@FXML
	TextField emailInput;
	
	private ApiConntector ac = new ApiConntector();
	
    @FXML
    private void getWeatherData() throws IOException, UnirestException, ParseException {
    	
    	//hämta api
    	HttpResponse<JsonNode> response = null;
		response = Unirest
				.get("https://email-verifier-completely-free.p.rapidapi.com/email-verification/saferkret@hotmail.com")
				.header("X-RapidAPI-Key", "29769a47d4msh6d483c9ef8feeaap11d38bjsnce91b4921f8e")
				.header("X-RapidAPI-Host", "email-verifier-completely-free.p.rapidapi.com").asJson();
		
		//printa ut all data i api
		System.out.println(response.getBody());
		
		JSONParser parser = new JSONParser();
		
		//hämta "response" objektet i jsontexten
		JSONObject entry = (JSONObject) parser.parse(response.getBody().toString());
		System.out.println(entry.get("response"));
		
		//hämta alla objekt i "response" objektet
		JSONObject JO = (JSONObject) parser.parse(entry.get("response").toString());
		System.out.println(JO.get("query"));
		System.out.println(JO.get("format"));
		System.out.println(JO.get("server_status"));
		System.out.println(JO.get("email_status"));
		System.out.println(JO.get("professional"));


		emailText.setText
				(
						JO.get("query") + "\n"	
						+JO.get("format") + "\n"	
						+JO.get("server_status") + "\n"	
						+JO.get("email_status") + "\n"	
						+JO.get("professional") + "\n"	
				);
		
    }
}
