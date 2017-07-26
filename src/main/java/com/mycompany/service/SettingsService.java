package com.mycompany.service;

import com.mycompany.model.SettingsModel;
import com.mycompany.exception.GenericLtiException;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: jwiseman
 * Date: Jul 19, 2017
 * Time: 6:29:39 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public interface SettingsService {
    public SettingsModel loadSettings () throws GenericLtiException;
    public void saveSettings (SettingsModel settingsModel) throws GenericLtiException;
}
