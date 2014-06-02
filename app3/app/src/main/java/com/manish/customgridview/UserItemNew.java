package com.manish.customgridview;

import java.io.Serializable;

public class UserItemNew implements Serializable {

	private String headline;
	private String reporterName;
	private String date;
	private String url;
    private String body;
    private String urlBig;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "[ headline=" + headline + ", reporter Name=" + reporterName + " , date=" + date + "]";
	}

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrlBig() {
        return urlBig;
    }

    public void setUrlBig(String urlBig) {
        this.urlBig = urlBig;
    }
}
