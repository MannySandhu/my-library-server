package io.github.mannysandhu.repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.mannysandhu.dto.volumeIsbnDto.Root;
import io.github.mannysandhu.dto.volumeIsbnDto.VolumeInfo;
import io.github.mannysandhu.model.Book;

public class BookByIsbnHttpClient {
	
	final static ObjectMapper objectMapper = new ObjectMapper();
	
	// private static final String API_KEY = "AIzaSyDo2cnCW4hMGWQ4p_xAeaY_IXUpmGIEcXA";
	/*
	 * Google Books API end points
	 */
	// Fetch a volume by ISBN value
	public static Book getVolumeByIsbn(long isbn) throws InterruptedException, IOException {
		final String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")
				.uri(URI.create(url))
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Root jsonObject = objectMapper.readValue(response.body(), Root.class);
		VolumeInfo volume = jsonObject.getItems().get(0).getVolumeInfo();
		return new Book(
				volume.getTitle(),
				volume.getSubtitle(),
				volume.getPageCount(),
				volume.getRatingsCount(),
				volume.getAverageRating(),
				volume.getMaturityRating(),
				volume.getPublishedDate(),
				volume.getPrintType(),
				volume.getPublisher(),
				volume.getDescription(),
				volume.getLanguage(),
				volume.getPreviewLink(),
				volume.getInfoLink(),
				volume.getImageLinks().toString());
	}

}
