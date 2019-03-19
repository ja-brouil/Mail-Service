package com.jb.mailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.jb.mailservice.repository.EmailRepository;
import com.jb.mailservice.model.EmailEntry;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeEmailController {
    @Autowired
    private EmailRepository emailRepository;


    @GetMapping("/subPage")
    public String getEmailList(Model model){
        model.addAttribute("emailEntry", new EmailEntry());
        model.addAttribute("emailEntries", emailRepository.findAll());
        return "subPage";
    }

    @PostMapping("/subPage")
    public String addEmailList(@ModelAttribute("emailEntry") EmailEntry emailEntry){
        emailRepository.save(emailEntry);
        return "thankyou";
    }


    /*
        Map these redirects from post mappings in order to not get null/404 errors
     */
    @PostMapping("/removeSub")
    public String removeEmailList(@ModelAttribute("emailEntry") EmailEntry emailEntry){

        for (EmailEntry emailValue : emailRepository.findAll()) {
            if (emailValue.getName().equals(emailEntry.getName()) && emailValue.getEmail().equals(emailEntry.getEmail())) {
                emailRepository.deleteById(emailValue.getID());
                return "redirect:removed";
            }
        }

        return "redirect:errorRemoving";
    }
}
