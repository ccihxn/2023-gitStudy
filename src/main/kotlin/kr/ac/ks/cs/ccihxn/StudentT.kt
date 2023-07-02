package kr.ac.ks.cs.ccihxn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class StudentT

fun main(args: Array<String>) {
    runApplication<CcihxnApplication>(*args)
}

//var news = mutableListOf("2030부산세계박람회 유치기원 ‘불꽃쇼’ 안전 총력 대응! ", "커터칼로 초등생 목 그은 고등학생 긴급체포", "광화문광장서 신원 미상 중년 남성 분신...중태 빠져")
//var count = 1;

data class Student (
    val id: Int,
    val name: String,
    val age: Int,
    val enroll: String,
    val score: Int
)

val students = mutableListOf<Student>()

@Controller
class StudentController {
    @GetMapping("/stud")
    fun index(model: Model):String {
        model.addAttribute("students", students)
        return "studentTable"
    }
    @PostMapping("/stud")
    fun add(id: Int, name: String, age: Int, enroll: String, score: Int): String {
        students.add(Student(id, name, age, enroll, score))
        return "redirect:/stud"
    }
}

