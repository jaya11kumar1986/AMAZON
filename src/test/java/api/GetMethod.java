package api;

import java.io.IOException;

public class GetMethod {

	public static void main(String[] args) throws IOException {
		
		BaseClass.getResponseValue("https://reqres.in/api/users?page=2");
		BaseClass.getResponseMessage("https://reqres.in/api/users?page=2");
		BaseClass.getResponseTime("https://reqres.in/api/users?page=2");
		BaseClass.getResponseBody("https://reqres.in/api/users?page=2");

	}

}
