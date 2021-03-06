package com.qcloud.weapp;

import com.huanghuo.common.util.HttpClientUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;

/**
 * 用于创建网络请求，SDK 内部使用
 * */
public class HttpRequest {
	
	public interface ConnectionProvider {
		HttpURLConnection getConnection(String url, Proxy proxy) throws IOException;
	}
	
	private static ConnectionProvider connectionProvider = new ConnectionProvider() {
		
		@Override
		public HttpURLConnection getConnection(String url, Proxy proxy) throws IOException {
			if (proxy == null) {
				return (HttpURLConnection) new URL(url).openConnection();
			} else {
				return (HttpURLConnection) new URL(url).openConnection(proxy);
			}
		}
	};
	
	public static void setUrlProvider(ConnectionProvider provider) {
		connectionProvider = provider;
	}

	public static ConnectionProvider getUrlProvider() {
		return connectionProvider;
	}
	
	private String url;
	
	public HttpRequest(String url) {
		this.url = url;
	}
	
	public Map<String, Object> post(Map<String, Object> params) throws IOException {
		HttpClientUtils.HttpResult result =HttpClientUtils.post(url, params);
		return result.getJsonContent();
	}
	
}
