package kr.ac.ks.cs.ccihxn

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Lob
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.annotation.Id
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Repository
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Entity
data class TodoEntity(
    @jakarta.persistence.Id @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @Lob val title: String
)

@Repository
interface TodoRepository : CrudRepository<TodoEntity, Long>

@Controller
class TodoDBController(
    @Autowired private val todoRepo: TodoRepository
) {
    @GetMapping("/todoDB")
    fun view(model: Model): String{
        println("todoRepo: " + todoRepo.findAll())
        model.addAttribute("todoList", todoRepo.findAll())
        return "todoDB"
    }

    @PostMapping("/todoDB")
    fun create(newTitle: String): String {
        todoRepo.save(TodoEntity(title = newTitle))
        return "redirect:/todoDB"
    }

    @DeleteMapping("/todoDB")
    fun delete(@RequestBody data: MutableMap<String, Long>) {
        val id = data["id"]
        if(todoRepo.existsById(id!!)) todoRepo.deleteById(id)
    }
}