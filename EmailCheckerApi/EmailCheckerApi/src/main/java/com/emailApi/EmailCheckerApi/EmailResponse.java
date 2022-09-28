package com.emailApi.EmailCheckerApi;

public class EmailResponse {

	// states
	String email_status;
	String format;
	String professional;
	String query;
	String server_status;

	public EmailResponse(String email_status, String format, String professional, String query, String server_status) {
		super();
		this.email_status = email_status;
		this.format = format;
		this.professional = professional;
		this.query = query;
		this.server_status = server_status;
	}

	public String getEmail_status() {
		return email_status;
	}

	public String getFormat() {
		return format;
	}

	public String getProfessional() {
		return professional;
	}

	public String getQuery() {
		return query;
	}

	public String getServer_status() {
		return server_status;
	}

}
