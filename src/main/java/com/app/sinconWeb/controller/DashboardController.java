package com.app.sinconWeb.controller;

import com.app.sinconWeb.controller.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by imdadareeph.
 */

@Controller
public class DashboardController {

	@RequestMapping(value={"/index","/dashboard/index"})
    public String index() {
        return "dashboard/index";
    }
    
    @RequestMapping(value={"/dashboard/index2", "/index2"})
    public String index2() {
        return "dashboard/index2";
    }
    
/*@RequestMapping(value={"/dashboard/usuario", "/usuario"})
    public String usuario() {
        return "dashboard/usuario";
    }*/

    
}
