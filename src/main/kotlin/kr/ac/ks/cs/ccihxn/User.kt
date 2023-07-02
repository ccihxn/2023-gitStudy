//package kr.ac.ks.cs.ccihxn
//
//import jakarta.persistence.Entity
//import jakarta.persistence.GeneratedValue
//import jakarta.persistence.GenerationType
//import jakarta.persistence.Id
//import jakarta.servlet.http.HttpSession
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.data.repository.CrudRepository
//import org.springframework.stereotype.Controller
//import org.springframework.stereotype.Repository
//import org.springframework.ui.Model
//import org.springframework.web.bind.annotation.*
//import sun.security.util.SignatureUtil.EdDSADigestAlgHolder.sha512
//import sun.security.x509.AlgorithmId
//import java.util.*
//
//@Entity
//data class UserAccount(
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long,
//
//    val username: String,
//    val password: AlgorithmId
//)
//
//@Repository
//interface UserRepository: CrudRepository<UserAccount, Long> {
//    fun findByUsername(username: String): UserAccount?
//}
//
//@Controller
//@RequestMapping("/user")
//class UserController (@Autowired val userRepo: UserRepository) {
//    @GetMapping("/")
//    fun index(session: HttpSession, model: Model): String  {
//        model.addAttribute("userInfo", session.getAttribute("user"))
//        return "login_index"
//    }
//    @PostMapping("/login")
//    fun login(id: String, pw: String, sess: HttpSession): String {
//        val account = userRepo.findByUsername(id)
//    return "redirect:/user/"
//    }
//
//    @PostMapping("register")
//    fun register(id: String, pw: String) {
//        userRepo.save(UserAccount(null, id, sha512))
//
//    }
//}
//
//data class UserInfo(val id: String, val point: Int)