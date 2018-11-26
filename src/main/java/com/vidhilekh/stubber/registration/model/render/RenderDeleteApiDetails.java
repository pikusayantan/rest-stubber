package com.vidhilekh.stubber.registration.model.render;

//Render variable for showApiDetails.html page
public class RenderDeleteApiDetails {
	
	private boolean showSearchDiv;
	private boolean showNoResultDiv;
	private boolean showSearchListDiv;
	private boolean showDeleteMessageDiv;
	
	public boolean isShowSearchDiv() {
		return showSearchDiv;
	}
	public void setShowSearchDiv(boolean showSearchDiv) {
		this.showSearchDiv = showSearchDiv;
	}
	public boolean isShowNoResultDiv() {
		return showNoResultDiv;
	}
	public void setShowNoResultDiv(boolean showNoResultDiv) {
		this.showNoResultDiv = showNoResultDiv;
	}
	public boolean isShowSearchListDiv() {
		return showSearchListDiv;
	}
	public void setShowSearchListDiv(boolean showSearchListDiv) {
		this.showSearchListDiv = showSearchListDiv;
	}
	public boolean isShowDeleteMessageDiv() {
		return showDeleteMessageDiv;
	}
	public void setShowDeleteMessageDiv(boolean showDeleteMessageDiv) {
		this.showDeleteMessageDiv = showDeleteMessageDiv;
	}
}