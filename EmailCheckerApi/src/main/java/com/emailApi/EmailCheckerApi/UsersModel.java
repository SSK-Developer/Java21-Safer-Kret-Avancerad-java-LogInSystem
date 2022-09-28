package com.emailApi.EmailCheckerApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersModel {

	// states
	public static String dbURL = "jdbc:mysql://localhost:3306/userdbtest";
	public static String username = "root";
	public static String password = "safer1234";
	// ArrayList<UserModel> Users = new ArrayList();

	public UsersModel() {

	}

	/*
	 * behvaiours: add user. check if exists: username and email. get user info:
	 * username, password and email.
	 * 
	 */

	public static boolean checkRegisterUser(String userInputUsername, String userInputEmail) {

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "SELECT * FROM Users";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("user_id");
				String name = result.getString("username");
				String pass = result.getString("password");
				String email = result.getString("email");

				if (name.equals(userInputUsername) || email.equals(userInputEmail)) {
					return true;
				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static boolean checkLogInUser(String userInputUsername, String userPasswordInput) {

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "SELECT * FROM Users";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("user_id");
				String name = result.getString("username");
				String pass = result.getString("password");
				String email = result.getString("email");

				if (name.equals(userInputUsername) && pass.equals(userPasswordInput)) {
					return true;
				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static void selectUsers() {

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "SELECT * FROM Users";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("user_id");
				String name = result.getString("username");
				String pass = result.getString("password");
				String email = result.getString("email");

				String output = "User %d: %s - %s - %s";
				System.out.println(String.format(output, id, name, pass, email));

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void insertUser(String newUsername, String newPass, String newEmail) {
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newUsername);
			statement.setString(2, newPass);
			statement.setString(3, newEmail);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void deleteUser(String deleteUserName) {

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "DELETE FROM Users WHERE username=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, deleteUserName);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void updateUser(String newUserName, String newPass, String newEmail, String oldUserName) {

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "UPDATE Users SET username=?, password=?, email=? WHERE username=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newUserName);
			statement.setString(2, newPass);
			statement.setString(3, newEmail);
			statement.setString(4, oldUserName);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	/*
	 * public boolean checkUser(String username, String email) { for (UserModel item
	 * : Users) { if (item.equals(email) || item.equals(username)) {
	 * 
	 * return true; } } return false; }
	 * 
	 * public void addUser(UserModel userModel) { Users.add(userModel); }
	 * 
	 * public void getUsers() { for (UserModel userModel : Users) {
	 * System.out.println("Email: " + userModel.getUserEmail() + " Username: " +
	 * userModel.getUserName() + " Password: " + userModel.getUserPassword()); } }
	 */

}
