package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UniRestLibrary {

	public void getmethod() throws UnirestException {

		HttpResponse<JsonNode> asJson = Unirest.get("https://reqres.in/api/users?page=2").asJson();

		System.out.println("Status Code :" + asJson.getStatus());
		System.out.println("Status Message :" + asJson.getStatusText());
		System.out.println("Status Body :" + asJson.getBody());
		System.out.println("Status Headers :" + asJson.getHeaders());
		System.out.println("Status Raw Body :" + asJson.getRawBody());
	}

	public void postmethod() throws UnirestException {

		HttpResponse<JsonNode> asJson = Unirest.post("https://reqres.in/api/users")
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}").asJson();

		System.out.println("Status Code :" + asJson.getStatus());
		System.out.println("Status Message :" + asJson.getStatusText());
		System.out.println("Status Body :" + asJson.getBody());
		System.out.println("Status Headers :" + asJson.getHeaders());
		System.out.println("Status Raw Body :" + asJson.getRawBody());
	}
	
	public void putmethod() throws UnirestException {

		HttpResponse<JsonNode> asJson = Unirest.put("https://reqres.in/api/users/2")
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"Team leader\"\r\n" + "}").asJson();

		System.out.println("Status Code :" + asJson.getStatus());
		System.out.println("Status Message :" + asJson.getStatusText());
		System.out.println("Status Body :" + asJson.getBody());
		System.out.println("Status Headers :" + asJson.getHeaders());
		System.out.println("Status Raw Body :" + asJson.getRawBody());
	}
	
	public void deletemethod() throws UnirestException {

		HttpResponse<JsonNode> asJson = Unirest.delete("https://reqres.in/api/users/2")
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"Team leader\"\r\n" + "}").asJson();

		System.out.println("Status Code :" + asJson.getStatus());
		System.out.println("Status Message :" + asJson.getStatusText());
		System.out.println("Status Body :" + asJson.getBody());
		System.out.println("Status Headers :" + asJson.getHeaders());
		System.out.println("Status Raw Body :" + asJson.getRawBody());
	}

	public static void main(String[] args) throws UnirestException {

		UniRestLibrary library = new UniRestLibrary();
		// library.getmethod();
		//library.postmethod();
		//library.putmethod();
		library.deletemethod();

	}

}
