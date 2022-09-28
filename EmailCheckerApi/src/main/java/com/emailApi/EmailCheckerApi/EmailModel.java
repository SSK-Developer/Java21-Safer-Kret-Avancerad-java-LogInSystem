package com.emailApi.EmailCheckerApi;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class EmailModel {

	// states
	private String query;
	private String format;
	private String server_status;
	private String email_status;
	private String professional;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getServer_status() {
		return server_status;
	}

	public void setServer_status(String server_status) {
		this.server_status = server_status;
	}

	public String getEmail_status() {
		return email_status;
	}

	public void setEmail_status(String email_status) {
		this.email_status = email_status;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public HttpResponse<JsonNode> getApiResponse(String emailInput) throws UnirestException, ParseException {

		// hämta api
		HttpResponse<JsonNode> response = Unirest
				.get("https://email-verifier-completely-free.p.rapidapi.com/email-verification/" + emailInput)
				.header("X-RapidAPI-Key", "29769a47d4msh6d483c9ef8feeaap11d38bjsnce91b4921f8e")
				.header("X-RapidAPI-Host", "email-verifier-completely-free.p.rapidapi.com").asJson();

		return response;
	}

	public void parseAndSetApiData(HttpResponse<JsonNode> response) throws ParseException {

		JSONParser parser = new JSONParser();

		// hämta "response" objektet i jsontexten
		JSONObject entry = (JSONObject) parser.parse(response.getBody().toString());

		// hämta alla objekt i "response" objektet
		JSONObject JO = (JSONObject) parser.parse(entry.get("response").toString());
		String q = (String) (JO.get("query"));
		String f = (String) (JO.get("format"));
		String s = (String) (JO.get("server_status"));
		String e = (String) (JO.get("email_status"));
		String p = (String) (JO.get("professional"));
		;

		setQuery(q);
		setFormat(f);
		setServer_status(s);
		setEmail_status(e);
		setProfessional(p);
	}

	public void setApiData(String emailInput) throws ParseException, UnirestException {
		parseAndSetApiData(getApiResponse(emailInput.trim()));
	}

}
