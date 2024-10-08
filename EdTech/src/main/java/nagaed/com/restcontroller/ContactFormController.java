package nagaed.com.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import nagaed.com.entity.ContactForm;

@Controller
public class ContactFormController {
	
	@GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("form", new ContactForm()); // Add an empty form object for Thymeleaf
        return "contactUs"; // This will return the contactUs.html form view
    }
	
	 @PostMapping("/contact")
	public String submitForm(@ModelAttribute("form") ContactForm form,Model model) {
		 System.out.println("Contact Form Submitted:");
	        System.out.println("Name: " + form.getName());
	        System.out.println("Email: " + form.getEmail());
	        System.out.println("Message: " + form.getMessage());
	        
	        model.addAttribute("successMessage", "Thank you for contacting us, " + form.getName() + "!");

	        // Return the name of the HTML view (e.g., contact.html)
	        return "contactUs";
	}

}
