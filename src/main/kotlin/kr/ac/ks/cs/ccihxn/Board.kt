//package kr.ac.ks.cs.ccihxn
//
//import jakarta.persistence.Entity
//import jakarta.persistence.GeneratedValue
//import jakarta.persistence.GenerationType
//import jakarta.persistence.Id
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.data.repository.CrudRepository
//import org.springframework.stereotype.Controller
//import org.springframework.stereotype.Repository
//import org.springframework.ui.Model
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestMapping
//import javax.annotation.processing.Generated
//
//@Entity
//data class PostEntity(
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long? = null,
//
//    val title: String,
//    val content: String
//)
//
//@Repository
//interface PostRepository: CrudRepository<PostEntity, Long> {}
//
//@Controller
//@RequestMapping("/board")
//class Board(
//    @Autowired val postRepo: PostRepository
//) {
//    @GetMapping("/")
//    fun index(model: Model): String {
//        model.addAttribute("articles", postRepo.findAll().toList())
//        return "board_list"
//    }
//
//    @GetMapping("/write")
//    fun writeForm(): String = "board_write"
//
//    @PostMapping("/write")
//    fun write(title: String, content: String): String {
//        postRepo.save(PostEntity(title = title, content = content))
//        return "redirect:/board/"
//    }
//
//    @GetMapping("article/{id}")
//    fun article(model: Model, @PathVariable id: Long): String {
//        model.addAttribute()
//    }
//}