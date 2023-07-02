package kr.ac.ks.cs.ccihxn

import kr.ac.ks.cs.ccihxn.CcihxnApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Calc

fun main(args: Array<String>) {
    runApplication<CcihxnApplication>(*args)
}

@Controller
class CalcController {
    // 루트 경로로 접속(GET)하면 calcTemplate.html 에 해당되는 템플릿을 랜더링(반환)
    @GetMapping("/calc")
    fun home() = "calc"

    // 루트 경로로 접속(POST)하면 num1 과 num2 를 받아서 더한 값을 result 에 담아서 calc.html 에 해당되는 템플릿을 랜더링(반환)
// num1 과 num2 는 calc.html 의 form 에 있는 input 태그의 name 값에서 가져옴
    @PostMapping("/calc")
    fun calc(model: Model, num1: Int, num2: Int): String {
// 모델에 필요한 값을 채워넣음. View(template)에는 모델 정보만 넘어감.
// 모델은 Controller 와 View 사이의 데이터 교환을 위한 객체라고 생각하면 됨.
        model.addAttribute("num1", num1)
        model.addAttribute("num2", num2)
        model.addAttribute("result", num1 + num2)
// calc.html 템플릿을 반환 return "calc"
        return "calc"
    }
}