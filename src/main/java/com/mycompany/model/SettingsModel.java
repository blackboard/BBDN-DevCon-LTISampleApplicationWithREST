package com.mycompany.model;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.HashMap;

import blackboard.platform.plugin.PlugInUtil;
import com.mycompany.Constants;

/**
 * Created by IntelliJ IDEA.
 * User: jwiseman
 * Date: Jul 19, 2017
 * Time: 6:15:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class SettingsModel {
    private String key;
    private String secret;
    private String learnUrl;
    
    public ModelAndView getSettingsView () {
        Map<String, String> settingsValues = new HashMap<String, String>();
        settingsValues.put("key", getKey());
        settingsValues.put("secret", getSecret());
        settingsValues.put("learnUrl", getLearnUrl());
        settingsValues.put("actionUrl", PlugInUtil.getUri(Constants.B2Vendor, Constants.B2Handle, "app/admin/settings"));
        settingsValues.put("cancelUrl", "/webapps/plugins/execute/plugInController");        
        return new  ModelAndView ("settings", settingsValues);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getLearnUrl() {
        return learnUrl;
    }

    public void setLearnUrl(String learnUrl) {
        this.learnUrl = learnUrl;
    }
}
