package sample.connect.spring.thymeleaf;

import com.atlassian.connect.spring.IgnoreJwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String getIframe() {
        return "thymeleaf";
    }
}
