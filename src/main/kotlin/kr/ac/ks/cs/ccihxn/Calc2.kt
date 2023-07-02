package kr.ac.ks.cs.ccihxn

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class Calc2Controller {
    @GetMapping("/calc2")
    fun home() = "calc2"

    @PostMapping("/calc2")
    fun calc(model: Model, num1: Int, num2: Int): String {
        model.addAttribute("num1", num1)
        model.addAttribute("num2", num2)
        model.addAttribute("sum", num1 + num2)

        return "calc2"
    }
}