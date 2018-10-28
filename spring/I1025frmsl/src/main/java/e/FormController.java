package e;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import java.util.Map;
import java.util.LinkedHashMap;

@Controller
public class FormController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexPage(ModelMap model) {
		Map<String, String> countries = new LinkedHashMap<>();
		countries.put("US", "Соединённые Штаты");
		countries.put("CHINA", "Китай");
		countries.put("SG", "Сингапур");
		countries.put("MY", "Малазия");
		model.addAttribute("countries", countries);
		Country country = new Country("US", countries.get("US"));
        return new ModelAndView("index", "command",
                                               new Student(14, country));
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String resultPage(@ModelAttribute Student student,
                             ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("countryCode",
                                         student.getCountry().getCode());
        return "result";
    }
}
