package com.emailApi.EmailCheckerApi;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.mashape.unirest.http.exceptions.UnirestException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

	@FXML
	Text emailText;

	@FXML
	TextField createUserNameInput;

	@FXML
	TextField createPasswordInput;

	@FXML
	TextField createEmailInput;

	@FXML
	TextField logInUserNameInput;

	@FXML
	TextField logInPasswordInput;

	@FXML
	Text loggedInText;

	@FXML
	Text logInErrorText;

	@FXML
	Text registerErrorMessage;

	EmailModel em = new EmailModel();
	App app = new App();
	UsersModel usersModel = new UsersModel();

	@FXML
	private void switchToRegisterPage() throws IOException {
		app.setRoot("CreateAccountView");
	}

	@FXML
	private void switchToLogInPage() throws IOException {
		app.setRoot("LogInView");
	}

	@FXML
	private void switchToPrimaryPage() throws IOException {
		app.setRoot("primary");
	}

	@FXML
	private void switchToLoggedInPage() throws IOException {
		app.setRoot("LoggedInView");
	}

	@FXML
	private void createAccount() throws ParseException, UnirestException {
		usersModel.selectUsers();

		if (!(createEmailInput.getText().trim() == "" )) {
			em.setApiData(createEmailInput.getText());

			if (em.getFormat().equalsIgnoreCase("yes")) {

				if (usersModel.checkRegisterUser(createUserNameInput.getText(), createEmailInput.getText())) {
					System.out.println("User already exists");
					registerErrorMessage.setText("User already exists");
				} else {
					usersModel.insertUser(createUserNameInput.getText().toUpperCase(),
							createPasswordInput.getText().toUpperCase(), createEmailInput.getText().toUpperCase());
					System.out.println("User added");
				}

			} else {
				System.out.println("wrong format on email");
				registerErrorMessage.setText("Wrong email format");
			}
		}else registerErrorMessage.setText("Wrong email format");
	}

	@FXML
	private void logIn() throws IOException {

		usersModel.selectUsers();

		if (usersModel.checkLogInUser(logInUserNameInput.getText(), logInPasswordInput.getText())) {
			System.out.println("You're logged in");
			switchToLoggedInPage();
		} else {
			logInErrorText.setText("Wrong Username or Password!");
			System.out.println("You have to create an account");
		}
	}

}
