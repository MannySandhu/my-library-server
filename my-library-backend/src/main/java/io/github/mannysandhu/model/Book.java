package io.github.mannysandhu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "volume_genre")
	private String genre;
	
	@Column(name = "volume_title")
	private String title;
	
	@Column(name = "volume_author")
	private String author;
	
	@Column(name = "page_count")
	private long pageCount;
	
	@Column(name = "volume_started_status")
	private boolean volumeStartedStatus = false;
	
	@Column(name = "volume_completed_status")
	private boolean volumeCompletedStatus = false;
	
	@Column(name = "pages_read")
	private long pagesRead = 0;
	
	@Column(name = "volume_ISBN")
	private String isbn;
	
	public Book() {
		
	}
	
	public Book(String genre, String title, String author, long pageCount, String isbn) {
		super();
		this.genre = genre;
		this.title = title;
		this.author = author;
		this.pageCount = pageCount;
		this.isbn = isbn;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public boolean getVolumeStartedStatus() {
		return volumeStartedStatus;
	}

	public void setVolumeStartedStatus(boolean volumeStartedStatus) {
		this.volumeStartedStatus = volumeStartedStatus;
	}
	
	public boolean getVolumeCompletedStatus() {
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public long getId() {
		return id;
	}
	
}
