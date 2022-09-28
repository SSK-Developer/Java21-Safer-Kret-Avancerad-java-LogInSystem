module com.emailApi.EmailCheckerApi {
    requires javafx.controls;
    requires javafx.fxml;
	requires unirest.java;
	requires gson;
	requires java.desktop;
	requires json.simple;
	requires java.net.http;
	requires java.sql;

    opens com.emailApi.EmailCheckerApi to javafx.fxml;
    exports com.emailApi.EmailCheckerApi;
}