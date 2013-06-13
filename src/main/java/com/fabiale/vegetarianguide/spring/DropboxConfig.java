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

	private static final String APP_KEY = "1xz9xqh3jh1e0y3";
    private static final String APP_SECRET = "zzfq1vx36k6m5fo";
    private static final String USER_KEY = "qq1oi37ufc70cci";
    private static final String USER_SECRET = "6hqwwa7ao8xwux5";
    private static final AccessType ACCESS_TYPE = AccessType.DROPBOX;
    
    @Bean
    public DropboxAPI<WebAuthSession> dropboxAPI() {
    	AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE, new AccessTokenPair(USER_KEY, USER_SECRET));
        DropboxAPI<WebAuthSession> dbApi = new DropboxAPI<WebAuthSession>(session);
        
        return dbApi;
    }
}
