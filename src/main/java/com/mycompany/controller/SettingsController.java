package com.mycompany.controller;

import blackboard.data.ReceiptOptions;
import blackboard.platform.servlet.InlineReceiptUtil;
import com.mycompany.exception.GenericLtiException;
import com.mycompany.model.SettingsModel;
import com.mycompany.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class SettingsController {

    @Autowired
    SettingsService settingsService;

    // presents the setting page form
    @RequestMapping(value = {"settings"}, method = {RequestMethod.GET})
    public ModelAndView loadSettings(HttpServletRequest request) {

        SettingsModel settingsModel = null;

        try {
            settingsModel = settingsService.loadSettings();
            InlineReceiptUtil.addSuccessReceiptToRequest("Settings loaded successfully.");
        } catch (GenericLtiException ex) {
            settingsModel = new SettingsModel ();
            InlineReceiptUtil.addErrorReceiptToRequest(ex.getMessage());
        }

        return settingsModel.getSettingsView();
    }

    @RequestMapping(value = {"settings"}, method = {RequestMethod.POST})
    public ModelAndView saveSettings (@ModelAttribute("settings")SettingsModel settingsModel) {

        try {
            settingsService.saveSettings(settingsModel);
            InlineReceiptUtil.addSuccessReceiptToRequest("Settings saved successfully.");
        } catch (GenericLtiException ex) {
            settingsModel = new SettingsModel ();
            InlineReceiptUtil.addErrorReceiptToRequest(ex.getMessage());
        }

        return settingsModel.getSettingsView();
    }

}
