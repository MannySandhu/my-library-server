package io.github.mannysandhu.dto.volumeDto; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class Pdf{
    @JsonProperty("isAvailable") 
    public boolean getIsAvailable() { 
		 return this.isAvailable; } 
    public void setIsAvailable(boolean isAvailable) { 
		 this.isAvailable = isAvailable; } 
    boolean isAvailable;
}
