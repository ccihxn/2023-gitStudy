package kr.ac.ks.cs.ccihxn

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

var todo_list = mutableListOf(
    "밥먹기", "씻기", "끝장나게 쉬기"
)

@Controller
class TodoController {
    @GetMapping("/todo")
    fun home(model: Model): String {
        model.addAttribute("todoList", todo_list)
        return "todo"
    }
    @PostMapping("/todo")
    fun add(newTodo: String): String {
        todo_list.add(newTodo)
        return "redirect:/todo"
    }
}