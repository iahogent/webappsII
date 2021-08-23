package aplication;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Camp;
import domain.Person;
import domain.PostalCode;
import service.CampService;
import validator.PersonValidation;

@Controller
@RequestMapping("/summercamp")
public class SummerCampController {

	
    @Autowired
    private PersonValidation personValidation;
    @Autowired
    private CampService summerCampService;
    
    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("postalCode", new PostalCode());
        return "postalCodeForm";
    }

    @PostMapping
    public String showCamps(@Valid PostalCode postalCode, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "postalCodeForm";
        }
        model.addAttribute("camps", summerCampService.findCamps(Integer.valueOf(postalCode.getPostalCode())));
        return "campView";
    }
    
    /*
     * Decided that using the Controller as explained here 
     * https://www.baeldung.com/spring-controller-vs-restcontrollerd
     * was more clean for part 3
     */
	@GetMapping(value = "/{id}", produces = "application/json")
	public @ResponseBody Camp getCamp(@PathVariable("id") int campId) {
		return summerCampService.findCamp(campId);
	}
    
    @GetMapping(value = "/add/{id}")
    public String register(@PathVariable("id") Integer campId, Model model) {
       
        Camp camp = summerCampService.findCamp(campId);
        if (camp == null || camp.maxChildrenExceeded()) {
        	model.addAttribute("message",camp.getManager().getName() + "is fully booked!");
			return "redirect:/summercamp";
		}
        model.addAttribute("camp", camp);
        model.addAttribute("person", new Person());
        return "summercamp/registrationForm";
    }
    
    //@@TODO
    @PostMapping(value = "/add/{id}")
    public String processRegistration(@PathVariable("id") Integer campId, @Valid Person child, BindingResult result, Model model) {
       
    	personValidation.validate(child, result);
    	Camp camp = summerCampService.findCamp(campId);
    	
        if (result.hasErrors()) {
        	model.addAttribute("camp", camp);
			return "summercamp/registrationForm";
		}
        camp.signUpChild(child);
        model.addAttribute("message", "The children has been added");
        return "redirect:/summercamp";
    }


}
