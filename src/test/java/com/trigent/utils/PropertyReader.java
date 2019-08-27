package com.trigent.utils;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;


@Resource.Classpath("app.properties")
public class PropertyReader {
	
	
  @Property("BaseURL")
    private String baseURL;
	
	
	
    public String getBaseURL() {
		return baseURL;
	}



	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}


	/**
     * Instantiates a new portal properties.
     
	/* @Property("MailURL")
    private String MailURL;
	
	
	
    public String getMailURL() {
		return MailURL;
	}



	public void setMailURL(String MailURL) {
		this.MailURL = MailURL;
	}    
	*/


} 
