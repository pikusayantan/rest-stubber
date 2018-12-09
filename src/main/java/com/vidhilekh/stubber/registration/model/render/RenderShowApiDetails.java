package com.vidhilekh.stubber.registration.model.render;

/*
 * Render variable for showApiDetails.html page
 */
public class RenderShowApiDetails {
	
	private boolean showSearchDiv;
	private boolean showNoResultDiv;
	private boolean showSearchListDiv;
	private boolean showDisplayApiDiv;
	private boolean showEditApiDiv;
	
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
	public boolean isShowDisplayApiDiv() {
		return showDisplayApiDiv;
	}
	public void setShowDisplayApiDiv(boolean showDisplayApiDiv) {
		this.showDisplayApiDiv = showDisplayApiDiv;
	}
	public boolean isShowEditApiDiv() {
		return showEditApiDiv;
	}
	public void setShowEditApiDiv(boolean showEditApiDiv) {
		this.showEditApiDiv = showEditApiDiv;
	}
}