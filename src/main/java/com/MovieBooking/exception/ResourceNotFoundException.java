package com.MovieBooking.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	String recourceName;
	String feildName;
	long feildValue;
	public String getRecourceName() {
		return recourceName;
	}
	public void setRecourceName(String recourceName) {
		this.recourceName = recourceName;
	}
	public String getFeildName() {
		return feildName;
	}
	public void setFeildName(String feildName) {
		this.feildName = feildName;
	}
	public long getFeildValue() {
		return feildValue;
	}
	public void setFeildValue(long feildValue) {
		this.feildValue = feildValue;
	}
	public ResourceNotFoundException(String recourceName, String feildName, long feildValue) {
		super(String.format("%s not found with %s: %s", recourceName, feildName, feildValue));
		this.recourceName = recourceName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
	
	

}
