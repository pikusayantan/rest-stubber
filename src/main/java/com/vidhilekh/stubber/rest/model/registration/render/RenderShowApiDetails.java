package com.vidhilekh.stubber.rest.model.registration.render;

//Render variable for showApiDetails.html page
public class RenderShowApiDetails {
	
	private boolean showSearchDiv;
	private boolean showDisplayApiDiv;
	private boolean showEditApiDiv;
	
	public boolean isShowSearchDiv() {
		return showSearchDiv;
	}
	public void setShowSearchDiv(boolean showSearchDiv) {
		this.showSearchDiv = showSearchDiv;
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
