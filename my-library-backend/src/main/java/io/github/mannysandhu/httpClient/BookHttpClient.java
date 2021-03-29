package io.github.mannysandhu.httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.mannysandhu.dto.volumeDto.VolumeInfo;

/*
 * REST HTTP client for querying Google Books APIs
 */
public class BookHttpClient {

	ObjectMapper objectMapper = new ObjectMapper();
	
	// private static final String API_KEY = "AIzaSyDo2cnCW4hMGWQ4p_xAeaY_IXUpmGIEcXA";
	/*
	 * Google Books API end points
	 */
	// Fetch a volume by ISBN value
	public String getVolumeByIsbn(String isbn) throws InterruptedException, IOException {
		final String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")
				.uri(URI.create(url))
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		VolumeInfo volume = objectMapper.readValue(response.body(), VolumeInfo.class);
		return volume.getTitle();
	}
	
	// Fetch a volume by terms
	public String getVolumeByTerms(String terms) throws InterruptedException, IOException {
		final String url = "https://www.googleapis.com/books/v1/volumes?q=" + terms;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")
				.uri(URI.create(url))
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}
}
