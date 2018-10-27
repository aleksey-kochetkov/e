package e;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirectPage() {
        return "redirect:final";
    }

    @RequestMapping(value = "/final", method = RequestMethod.GET)
    public String finalPage() {
        return "final";
    }
}
