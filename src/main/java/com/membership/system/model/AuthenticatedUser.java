package com.membership.system.model;

import java.util.HashMap;

public class AuthenticatedUser extends HashMap<String, String>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String USERNAME = "username";
    private static final String TOKEN = "token";
    
    public AuthenticatedUser setUserName(final String userName) {
        this.put(USERNAME, userName);
        return this;
    }
    
    public AuthenticatedUser setToken(final String token) {
        this.put(TOKEN, token);
        return this;
    }
    
    public String getUserName() {
        return this.get(USERNAME);
    }
    
    public String getToken() {
        return this.get(TOKEN);
    }
}
