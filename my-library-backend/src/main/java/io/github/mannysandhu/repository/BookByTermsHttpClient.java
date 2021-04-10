package io.github.mannysandhu.repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.mannysandhu.dto.volumeTermsDto.Root;
import io.github.mannysandhu.dto.volumeTermsDto.VolumeInfo;
import io.github.mannysandhu.model.Book;

public class BookByTermsHttpClient {
	
	final static ObjectMapper objectMapper = new ObjectMapper();
	
	// private static final String API_KEY = "AIzaSyDo2cnCW4hMGWQ4p_xAeaY_IXUpmGIEcXA";
	/*
	 * Google Books API end points
	 */
	// Fetch a volume by terms 
	public static List<Book> getVolumeByTerms(String terms) throws InterruptedException, IOException {
		terms = terms.replace(' ', '+');
		final String url = "https://www.googleapis.com/books/v1/volumes?q=" + terms;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")
				.uri(URI.create(url))
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Root jsonObject = objectMapper.readValue(response.body(), Root.class);
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		for(int i=0; i<jsonObject.getItems().size(); i++) {
			VolumeInfo volume = jsonObject.getItems().get(i).getVolumeInfo();
			bookList.add(new Book(
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
					volume.getImageLinks().toString())
			);			
		}
		return bookList;
	}
}
