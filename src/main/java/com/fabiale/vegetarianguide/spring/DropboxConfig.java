package com.fabiale.vegetarianguide.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;

@Configuration
public class DropboxConfig {

	private static final String APP_KEY = System.getenv("DROPBOX_APP_KEY");
    private static final String APP_SECRET = System.getenv("DROPBOX_APP_SECRET");
    private static final String USER_KEY = System.getenv("DROPBOX_USER_KEY");
    private static final String USER_SECRET = System.getenv("DROPBOX_USER_SECRET");
    private static final AccessType ACCESS_TYPE = AccessType.DROPBOX;
    
    @Bean
    public DropboxAPI<WebAuthSession> dropboxAPI() {
    	AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE, new AccessTokenPair(USER_KEY, USER_SECRET));
        DropboxAPI<WebAuthSession> dbApi = new DropboxAPI<WebAuthSession>(session);
        
        return dbApi;
    }
}
