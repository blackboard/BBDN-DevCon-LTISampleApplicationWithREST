package com.mycompany.service.impl;

import blackboard.platform.plugin.PlugInException;
import blackboard.platform.plugin.PlugInUtil;
import com.mycompany.Constants;
import com.mycompany.exception.GenericLtiException;
import com.mycompany.model.SettingsModel;
import com.mycompany.service.SettingsService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: jwiseman
 * Date: Jul 19, 2017
 * Time: 6:29:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SettingsServiceImpl implements SettingsService {
    public SettingsModel loadSettings() throws GenericLtiException {
        SettingsModel settingsModel = new SettingsModel();
        Properties p = loadProperties();
        if (p != null) {
            settingsModel.setKey(p.getProperty("key"));
            settingsModel.setSecret(p.getProperty("secret"));
            settingsModel.setLearnUrl(p.getProperty("learnUrl"));
        }
        return settingsModel;
    }

    public void saveSettings(SettingsModel model) throws GenericLtiException {
        // Write settings to properties file
        FileOutputStream fos = null;
        Properties b2Properties = new Properties();
        b2Properties.put("key", model.getKey());
        b2Properties.put("secret", model.getSecret());
        b2Properties.put("learnUrl", model.getLearnUrl());

        try {
            File f = new File(new StringBuilder().append(PlugInUtil.getConfigDirectory(Constants.B2Vendor,
                    Constants.B2Handle).getAbsolutePath()).append("/settings.properties").toString());
            fos = new FileOutputStream(f);
            b2Properties.store(fos, "storing");
            fos.close();
            fos = null;
        } catch (IOException e) {
            throw new GenericLtiException (e);
        } catch (PlugInException ex1) {
            throw new GenericLtiException(ex1);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    fos = null;
                } catch (Exception ex) {
                    throw new GenericLtiException (ex);
                }
            }
        }
    }

    private Properties loadProperties() throws GenericLtiException {
        Properties b2Properties = new Properties();
        FileInputStream fis = null;
        try {
            File f = new File(new StringBuilder().append(PlugInUtil.getConfigDirectory(Constants.B2Vendor,
                    Constants.B2Handle).getAbsolutePath()).append("/settings.properties").toString());
            if (!f.exists()) {
                return b2Properties;
            }

            fis = new FileInputStream(f);
            b2Properties.load(fis);
            fis.close();
            fis = null;
        } catch (IOException ex) {
            throw new GenericLtiException(ex);
        } catch (PlugInException ex1) {
            throw new GenericLtiException(ex1);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    fis = null;
                } catch (Exception ex) {
                    throw new GenericLtiException(ex);

                }
            }
        }

        return b2Properties;
    }
}
