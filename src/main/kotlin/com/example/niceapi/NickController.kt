package com.example.niceapi

import com.example.niceapi.FlagMain.niceCheck
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest

@Controller
class NickController {

    @GetMapping("/fail")
    fun getFail(): String {

        return "checkplus_fail.jsp"
    }

    @GetMapping("/main")
    fun getMain(model: Model): String {
        val nice = niceCheck()
        println("nice = ${nice}")
        model.addAttribute("niceCheck", nice)
        return "main"
    }

    @GetMapping("/success")
    fun getSuccess(req: HttpServletRequest): String {
        req.getParameter("");
        return "checkplus_success.jsp"
    }
}