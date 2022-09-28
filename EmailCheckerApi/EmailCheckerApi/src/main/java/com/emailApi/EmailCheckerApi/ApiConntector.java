package com.emailApi.EmailCheckerApi;

import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiConntector {

	public String getApiInfo() throws UnirestException {
	
		
		return null;
	}

	/*
	 * public static String getEmailStatusFromAPI() { try { HttpResponse<JsonNode>
	 * apiResponse = Unirest .get(
	 * "https://email-verifier-completely-free.p.rapidapi.com/email-verification/saferkret@hotmail.com")
	 * .header("X-RapidAPI-Key",
	 * "29769a47d4msh6d483c9ef8feeaap11d38bjsnce91b4921f8e")
	 * .header("X-RapidAPI-Host",
	 * "email-verifier-completely-free.p.rapidapi.com").asJson(); EmailResponse
	 * emailResponse = new Gson().fromJson(apiResponse.getBody().toString(),
	 * EmailResponse.class); System.out.println(emailResponse); return
	 * emailResponse.getEmail_status(); } catch (UnirestException e) {
	 * e.printStackTrace(); } return null; }
	 * 
	 * public static String getEmailFormatFromAPI() { try { HttpResponse<JsonNode>
	 * apiResponse = Unirest .get(
	 * "https://email-verifier-completely-free.p.rapidapi.com/email-verification/saferkret@hotmail.com")
	 * .header("X-RapidAPI-Key",
	 * "29769a47d4msh6d483c9ef8feeaap11d38bjsnce91b4921f8e")
	 * .header("X-RapidAPI-Host",
	 * "email-verifier-completely-free.p.rapidapi.com").asJson(); EmailResponse
	 * emailResponse = new Gson().fromJson(apiResponse.getBody().toString(),
	 * EmailResponse.class); return emailResponse.getFormat(); } catch
	 * (UnirestException e) { e.printStackTrace(); } return null; }
	 * 
	 * public static String getEmailQueryFromAPI() { try { HttpResponse<JsonNode>
	 * apiResponse = Unirest .get(
	 * "https://email-verifier-completely-free.p.rapidapi.com/email-verification/saferkret@hotmail.com")
	 * .header("X-RapidAPI-Key",
	 * "29769a47d4msh6d483c9ef8feeaap11d38bjsnce91b4921f8e")
	 * .header("X-RapidAPI-Host",
	 * "email-verifier-completely-free.p.rapidapi.com").asJson(); EmailResponse
	 * emailResponse = new Gson().fromJson(apiResponse.getBody().toString(),
	 * EmailResponse.class); return emailResponse.getQuery(); } catch
	 * (UnirestException e) { e.printStackTrace(); } return null; }
	 * 
	 * public static String getEmailProfessionalFromAPI() { try {
	 * HttpResponse<JsonNode> apiResponse = Unirest .get(
	 * "https://email-verifier-completely-free.p.rapidapi.com/email-verification/saferkret@hotmail.com")
	 * .header("X-RapidAPI-Key",
	 * "29769a47d4msh6d483c9ef8feeaap11d38bjsnce91b4921f8e")
	 * .header("X-RapidAPI-Host",
	 * "email-verifier-completely-free.p.rapidapi.com").asJson(); EmailResponse
	 * emailResponse = new Gson().fromJson(apiResponse.getBody().toString(),
	 * EmailResponse.class); return emailResponse.getProfessional(); } catch
	 * (UnirestException e) { e.printStackTrace(); } return null; }
	 * 
	 * public static String getEmailServerStatusFromAPI() { try {
	 * HttpResponse<JsonNode> apiResponse = Unirest .get(
	 * "https://email-verifier-completely-free.p.rapidapi.com/email-verification/saferkret@hotmail.com")
	 * .header("X-RapidAPI-Key",
	 * "29769a47d4msh6d483c9ef8feeaap11d38bjsnce91b4921f8e")
	 * .header("X-RapidAPI-Host",
	 * "email-verifier-completely-free.p.rapidapi.com").asJson(); EmailResponse
	 * emailResponse = new Gson().fromJson(apiResponse.getBody().toString(),
	 * EmailResponse.class); return emailResponse.getServer_status(); } catch
	 * (UnirestException e) { e.printStackTrace(); } return null; }
	 */

}
