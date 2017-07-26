package com.mycompany.service;

import org.springframework.stereotype.Service;
import com.mycompany.data.CourseDetails;
import com.mycompany.data.Token;
import com.mycompany.data.UserDetails;
import com.mycompany.model.SettingsModel;
import com.mycompany.exception.GenericRestException;

/**
 * Created by IntelliJ IDEA.
 * User: jwiseman
 * Date: Jul 21, 2017
 * Time: 11:51:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface DataFetcherService {
    public CourseDetails getCourseDetails (SettingsModel settingsModel, Token token, String uuid) throws GenericRestException;
    public UserDetails getUserDetails (SettingsModel settingsModel, Token token, String uuid) throws GenericRestException;
    public Token authorize (SettingsModel settingsModel) throws GenericRestException;
}
