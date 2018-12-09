package e;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Хелоу Spring MVC Framework!");
        return "hello";
    }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		return "login";
	}
}