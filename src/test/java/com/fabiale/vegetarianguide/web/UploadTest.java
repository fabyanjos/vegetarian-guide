package com.fabiale.vegetarianguide.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;
import com.google.gson.JsonObject;

@Service
public class UploadTest {
	
	public static void main(String[] args) throws MalformedURLException, DropboxException, IOException, URISyntaxException {
		new UploadTest().uploadDropbox();
	}
	
	@Autowired RestTemplate restTemplate;
	
	private static final String APP_KEY = "1xz9xqh3jh1e0y3";
    private static final String APP_SECRET = "zzfq1vx36k6m5fo";
    private static final AccessType ACCESS_TYPE = AccessType.DROPBOX;
    private static DropboxAPI<WebAuthSession> mDBApi;
	
	public void uploadDropbox() throws DropboxException, MalformedURLException, IOException, URISyntaxException {
		AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE);
        
        
//        WebAuthInfo authInfo = session.getAuthInfo();
 
//        RequestTokenPair pair = authInfo.requestTokenPair;
//        String url = authInfo.url;
 
//        Desktop.getDesktop().browse(new URL(url).toURI());
//        JOptionPane.showMessageDialog(null, "Press ok to continue once you have authenticated.");
//        session.retrieveWebAccessToken(pair);
 
//        AccessTokenPair tokens = session.getAccessTokenPair();
//        AccessTokenPair tokens = new AccessTokenPair("qq1oi37ufc70cci", "6hqwwa7ao8xwux5");
//        System.out.println("Use this token pair in future so you don't have to re-authenticate each time:");
//        System.out.println("Key token: " + tokens.key);
//        System.out.println("Secret token: " + tokens.secret);
        
        AccessTokenPair pair = new AccessTokenPair("qq1oi37ufc70cci", "6hqwwa7ao8xwux5");
        session.setAccessTokenPair(pair);
 
        mDBApi = new DropboxAPI<WebAuthSession>(session);
        System.out.println();
        System.out.print("Uploading file...");
        String fileContents = "Hello World!";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fileContents.getBytes());
        Entry newEntry = mDBApi.putFile("/Users/alefabi/Downloads/knobs/PNG/Knob Blue.png ", inputStream, fileContents.length(), null, null);
        System.out.println("Done. \nRevision of file: " + newEntry.rev);
	}

	private String key = "fa7b73a3b5526b7c7ce85258c8368b30";
	private String secret = "3900a6fe02be835f";
	private String methodGetFrob = "flickr.auth.getFrob";
	private String methodGetToken = "flickr.auth.getToken";
	private String signature = MD5(secret + "api_key" + key + "formatjsonmethod" + methodGetFrob + "nojsoncallback1"); 
	private String urlFrob = "http://flickr.com/services/rest/?method=flickr.auth.getFrob&format=json&nojsoncallback=1&api_key={api_key}&api_sig={api_sig}";
	private String urlToken = "http://flickr.com/services/rest/?method=flickr.auth.getToken&format=json&nojsoncallback=1&api_key={api_key}&frob{frob}&api_sig={api_sig}";
	private String urlAuth = "http://flickr.com/services/auth/?api_key={api_key}&perms=read&api_sig={api_sig}";
	private String ulrUp = "http://api.flickr.com/services/upload/?api_key={api_key}&api_sig={api_sig}&photo={photo}&format=json&nojsoncallback=1";

//	public static void main(String[] args) throws Exception {
//		System.out.println(new UploadTest().frob());
//	}
	
	public void upload() throws Exception {
//		sig = "http://flickr.com/services/auth/?api_key=fa7b73a3b5526b7c7ce85258c8368b30&perms=write&frob=72157633933686018-3d8a3fd086de1f4e-948235&api_sig=45d22849e3c1130b2b7a8846e3ae141e";
//		signature = MD5(secret + "api_key" + key + "frob" + frob() + "permswrite");
//		String frob = MD5(frob());
//		String s = restTemplate.postForObject(ulrUp, null, String.class, key, signature, new Image());
//		http://www.flickr.com/services/auth/?api_key=fa7b73a3b5526b7c7ce85258c8368b30&perms=write&frob=72157633973500953-adee634af7a86380-120865&api_sig=c2214a8d86fa730f4103cbb90d1e380d
//		Token <token>72157633973544323-d746bf3f24d19d65</token>
//		JsonObject r = restTemplate.getForObject(urlFrob, JsonObject.class, key, signature);
		String frob = frob();
//		Frob 72157633980854731-abeba16827c9cf10-95107
//		http://www.flickr.com/services/auth/?api_key=fa7b73a3b5526b7c7ce85258c8368b30&format=json&nojsoncallback=1&perms=write&frob=72157633980854731-abeba16827c9cf10-95107&api_sig=eb1091c97c111908758b762a6c984a05
		signature = MD5(secret + "api_key" + key + "frob" + frob + "permswrite");
		System.out.println("http://flickr.com/services/auth/?api_key=" + key + "&perms=write&frob=" + frob + "&api_sig=" + signature);
		signature = MD5(secret + "api_key" + key + "frob" + frob + "methodflickr.auth.getToken");
		System.out.println("http://flickr.com/services/rest/?method=flickr.auth.getToken&api_key=" + key + "&frob=" + frob+ "&api_sig=" + signature);
		
//		System.out.println("Frob: " + frob);
//		String sig = MD5(secret + "api_key" + key + "formatjsonfrob" + frob + "method" + methodGetToken + "nojsoncallback1");
//		String js = restTemplate.getForObject(urlToken, String.class, key, frob, sig);
//		System.out.println("Token: " + js);
//		System.out.println(secret + "api_key" + key + "formatjsonfrob" + frob() + "nojsoncallback1permswrite");
//		System.out.println(MD5(secret + "api_key" + key + "frob" + frob() + "permswrite"));
	}
	
	public String frob() {
		JsonObject r = restTemplate.getForObject(urlFrob, JsonObject.class, key, signature);
		
		return r.getAsJsonObject("frob").get("_content").getAsString();
	}

	public static String MD5(String text) {
		String md5Text = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			md5Text = new BigInteger(1, digest.digest((text).getBytes())).toString(16);
		} catch (Exception e) {
			System.out.println("Error in call to MD5");
		}

		if (md5Text.length() == 31) {
			md5Text = "0" + md5Text;
		}
		return md5Text;
	}
}

class Response {
	private Frob frob;
	private String stat;

	public Frob getFrob() {
		return frob;
	}

	public void setFrob(Frob frob) {
		this.frob = frob;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
}

class Frob {
	private String _content;
	
	public String get_content() {
		return _content;
	}
	public void set_content(String _content) {
		this._content = _content;
	}

}
