package io.github.mannysandhu.dto.volumeIsbnDto; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class SaleInfo{
    @JsonProperty("country") 
    public String getCountry() { 
		 return this.country; } 
    public void setCountry(String country) { 
		 this.country = country; } 
    String country;
    @JsonProperty("saleability") 
    public String getSaleability() { 
		 return this.saleability; } 
    public void setSaleability(String saleability) { 
		 this.saleability = saleability; } 
    String saleability;
    @JsonProperty("isEbook") 
    public boolean getIsEbook() { 
		 return this.isEbook; } 
    public void setIsEbook(boolean isEbook) { 
		 this.isEbook = isEbook; } 
    boolean isEbook;
}
