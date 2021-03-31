package io.github.mannysandhu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/*
 * Entity represents a book resource
 */
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

//	@Column(name = "volume_genre")
//	private List<String> genre;

	@Column(name = "volume_title")
	private String title;

	@Column(name = "volume_subtitle")
	private String subtitle;

//	@Column(name = "volume_authors")
//	private List<String> authors;

	@Column(name = "page_count")
	private long pageCount;

	@Column(name = "volume_started_status")
	private boolean volumeStartedStatus = false;

	@Column(name = "volume_completed_status")
	private boolean volumeCompletedStatus = false;

	@Column(name = "pages_read")
	private long pagesRead = 0;

	@Column(name = "ratings_count")
	private int ratingsCount = 0;

	@Column(name = "average_rating")
	private double averageRating;

	@Column(name = "maturity_rating")
	private String maturityRating;

	@Column(name = "published_date")
	private String publishedDate;

	@Column(name = "print_type")
	private String printType;

	@Column(name = "publisher")
	private String publisher;

	@Lob
	@Column(name = "description")
	private String description;

	@Column(name = "language")
	private String language;

	@Column(name = "preview_link")
	private String preview_link;

	@Column(name = "info_link")
	private String infoLink;

	@Column(name = "image_link")
	private String imageLink;

//	@Column(name = "volume_identifiers")
//	private List<String> indentifiers;

	public Book() {

	}

	public Book(String title, String subtitle, long pageCount,
			int ratingsCount, double averageRating, String maturityRating, String publishedDate, String printType,
			String publisher, String description, String language, String preview_link, String infoLink,
			String imageLink) {
		this.title = title;
		this.subtitle = subtitle;
		this.pageCount = pageCount;
		this.ratingsCount = ratingsCount;
		this.averageRating = averageRating;
		this.maturityRating = maturityRating;
		this.publishedDate = publishedDate;
		this.printType = printType;
		this.publisher = publisher;
		this.description = description;
		this.language = language;
		this.preview_link = preview_link;
		this.infoLink = infoLink;
		this.imageLink = imageLink;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public List<String> getGenre() {
//		return genre;
//	}
//
//	public void setGenre(List<String> genre) {
//		this.genre = genre;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

//	public List<String> getAuthors() {
//		return authors;
//	}
//
//	public void setAuthors(List<String> authors) {
//		this.authors = authors;
//	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public boolean isVolumeStartedStatus() {
		return volumeStartedStatus;
	}

	public void setVolumeStartedStatus(boolean volumeStartedStatus) {
		this.volumeStartedStatus = volumeStartedStatus;
	}

	public boolean isVolumeCompletedStatus() {
		return volumeCompletedStatus;
	}

	public void setVolumeCompletedStatus(boolean volumeCompletedStatus) {
		this.volumeCompletedStatus = volumeCompletedStatus;
	}

	public long getPagesRead() {
		return pagesRead;
	}

	public void setPagesRead(long pagesRead) {
		this.pagesRead = pagesRead;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public String getMaturityRating() {
		return maturityRating;
	}

	public void setMaturityRating(String maturityRating) {
		this.maturityRating = maturityRating;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getPrintType() {
		return printType;
	}

	public void setPrintType(String printType) {
		this.printType = printType;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPreview_link() {
		return preview_link;
	}

	public void setPreview_link(String preview_link) {
		this.preview_link = preview_link;
	}

	public String getInfoLink() {
		return infoLink;
	}

	public void setInfoLink(String infoLink) {
		this.infoLink = infoLink;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

//	public List<String> getIndentifiers() {
//		return indentifiers;
//	}
//
//	public void setIndentifiers(List<String> indentifiers) {
//		this.indentifiers = indentifiers;
//	}
}
