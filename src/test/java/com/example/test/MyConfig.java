package com.example.test;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.SelectorMode;
import org.openqa.selenium.MutableCapabilities;

public class MyConfig implements Config{

	@Override
	public AssertionMode assertionMode() {
		/*  SOFT - Test are failing only at the end of the methods.
			STRICT - Default mode - tests are failing immediately*/
		return AssertionMode.SOFT;
	}

	@Override
	public String baseUrl() {
		return "https://www.google.ru/";
	}

	@Override
	public String browser() {
		return "CHROME";
	}

	@Override
	public String browserBinary() {
		// use standalone browser
		return null;
	}

	@Override
	public MutableCapabilities browserCapabilities() {
		//Map<String,String> caps = new HashMap<String,String>();
		//caps.put("browserName", "chrome");
		//caps.put("platformName", "linux");
		//MutableCapabilities mc = new MutableCapabilities(caps);
		return null;
	}

	@Override
	public String browserPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String browserSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String browserVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean clickViaJs() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String downloadsFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean driverManagerEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fastSetValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FileDownloadMode fileDownload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean headless() {
		// true - headless
		return false;
	}

	@Override
	public boolean holdBrowserOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String pageLoadStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long pollingInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean proxyEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String proxyHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int proxyPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String remote() {
		return "http://172.17.0.4:4444/wd/hub";
	}

	@Override
	public boolean reopenBrowserOnFail() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String reportsFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportsUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean savePageSource() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean screenshots() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SelectorMode selectorMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean startMaximized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long timeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean versatileSetValue() {
		// TODO Auto-generated method stub
		return false;
	}
	
}