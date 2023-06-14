package com.microapi.microapi.users;

public class Support {
    private String url;
    private String text;
    public Support() {
		//apparently, fasterxml.jackson insists i have this
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

    
}
