package kr.ac.ks.cs.ccihxn

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Lob
import org.springframework.data.annotation.Id
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Repository
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

var count = 0

@Controller
class TodoDelController {
    data class Todo (val id: Int, val title: String)
    var todoList = mutableListOf(
        Todo(count++ ,"밥먹기"),
        Todo(count++, "씻기"),
        Todo(count++, "끝장나게 놀기")
    )
    @GetMapping("/todoDel")
    fun home(model: Model): String {
        model.addAttribute("todoList", todoList)
        return "todoDel"
    }
    @PostMapping("/todoDel")
    fun add(newTodo: String): String {
        todoList.add(Todo(count++, newTodo))
        return "redirect:/todoDel"
    }

    @DeleteMapping("/todoDel")
    @ResponseBody
    fun deleteTodo(@RequestBody delList: List<Int>) : Unit {
        todoList = todoList.filter { it.id !in delList } as MutableList<Todo>
    }
}