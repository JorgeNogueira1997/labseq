package com.springBootExample.labseq.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(){
        return "index"; // this will automatically search for index.html in the templates folder
    }

}
