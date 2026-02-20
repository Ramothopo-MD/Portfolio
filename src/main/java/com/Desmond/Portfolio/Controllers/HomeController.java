package com.Desmond.Portfolio.Controllers;

import com.Desmond.Portfolio.Services.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private MailSenderService mailSender;

    @RequestMapping("/")
    public String getHomePage(){
        return "index";
    }
    @PostMapping("/send-mail")
    public String sendMail(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message,
            Model model
    ) {
        String subject = "Portfolio Contact from " + name;
        String response = mailSender.sendMail(email, subject, message);

        model.addAttribute("response", response);

        // simple success detection (you can improve this)
        boolean isSuccess = response.toLowerCase().contains("success") || response.toLowerCase().contains("sent");
        model.addAttribute("isSuccess", isSuccess);

        return "index";
    }

}
