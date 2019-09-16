package Java.Inamning;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

public class Del_A_VG {

	private String id;
	private Client client;
	private String url;
	private String result;

	// This construktor takes a path id and a url
	public Del_A_VG(String id, String url) {

		this.id = id;
		this.url = url;
		client = ClientBuilder.newClient();
	}

	// Connects to to the webpage and returns all value from the JSON
	public void getJson() {

		result = client.target(url).path(id).request(MediaType.APPLICATION_JSON).get(String.class);

		JSONObject json = new JSONObject(result);

		System.out.println("date: " + json.get("date") + " Mili_sec: " + json.get("milliseconds_since_epoch")
				+ " Time: " + json.get("time"));
	}

}
