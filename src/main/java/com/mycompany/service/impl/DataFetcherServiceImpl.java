package com.mycompany.service.impl;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import com.mycompany.exception.GenericRestException;
import com.mycompany.model.SettingsModel;
import com.mycompany.Constants;
import com.mycompany.service.DataFetcherService;
import com.mycompany.data.Token;
import com.mycompany.data.CourseDetails;
import com.mycompany.data.UserDetails;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * User: jwiseman
 * Date: Jul 21, 2017
 * Time: 11:27:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DataFetcherServiceImpl implements DataFetcherService {
    public Token authorize (SettingsModel settingsModel) throws GenericRestException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = null;
        Token token = null;

        try {
            uri = new URI(settingsModel.getLearnUrl() + Constants.AUTH_PATH );
            String auth = settingsModel.getKey() + ":" + settingsModel.getSecret();
            String hash = Base64.getEncoder().encodeToString(auth.getBytes());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + hash);
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<String> request = new HttpEntity<String>("grant_type=client_credentials",headers);
            ResponseEntity<Token> response = restTemplate.exchange(uri, HttpMethod.POST, request, Token.class);
            token = response.getBody();
        } catch (URISyntaxException e) {
            throw new GenericRestException (e);
        }
        return token;
    }

    public CourseDetails getCourseDetails (SettingsModel settingsModel, Token token, String uuid) throws GenericRestException {
		CourseDetails crsDetails = null;
        RestTemplate restTemplate = new RestTemplate();
        URI uri = null;

        try {
            uri = new URI(settingsModel.getLearnUrl() + Constants.COURSES_PATH + "/uuid:" + uuid);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token.getAccess_token());
            headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<CourseDetails> request = new HttpEntity<CourseDetails>(new CourseDetails(), headers);
            ResponseEntity<CourseDetails> response = restTemplate.exchange(uri, HttpMethod.GET, request, CourseDetails.class);
            crsDetails = response.getBody();
        } catch (URISyntaxException e) {
            throw new GenericRestException (e);
        }
        return crsDetails;
    }

    public UserDetails getUserDetails (SettingsModel settingsModel, Token token, String uuid) throws GenericRestException {
		UserDetails userDetails = null;
        RestTemplate restTemplate = new RestTemplate();
        URI uri = null;

        try {
            uri = new URI(settingsModel.getLearnUrl() + Constants.USERS_PATH + "/uuid:" + uuid);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token.getAccess_token());
            headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<UserDetails> request = new HttpEntity<UserDetails>(new UserDetails(), headers);
            ResponseEntity<UserDetails> response = restTemplate.exchange(uri, HttpMethod.GET, request, UserDetails.class);
            userDetails = response.getBody();
        } catch (URISyntaxException e) {
            throw new GenericRestException (e);
        }
        return userDetails;
    }
}
