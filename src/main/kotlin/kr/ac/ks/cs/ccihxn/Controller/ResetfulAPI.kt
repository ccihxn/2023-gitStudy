package kr.ac.ks.cs.ccihxn.Controller

import kr.ac.ks.cs.ccihxn.CcihxnApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
//
//fun main(args: Array<String>) {
//    runApplication<CcihxnApplication>(*args)
//}

data class News(val title: String, val address: String)

var news2 = mutableListOf(

    News("누리호 5월 24일 3차 발사...인공위성 8개 싣고 우주로",
        "https://n.news.naver.com/mnews/article/448/0000404277?sid=105"),

    News("‘넷플릭스’ 잡으려다 ‘누누티비’까지 등장... 적자폭 껑충 뛴 토종 OTT",
        "https://n.news.naver.com/mnews/article/366/0000892375?sid=105"),

    News("The end of a myth: Distributed transactions can scale",
        "https://muratbuffalo.blogspot.com/2023/04/the-end-of-myth-distributed.html"),

    News("Getting the ^D", "https://owengage.com/writing/2023-04-08-getting-the-ctrl-d/")
)

@RestController
@RequestMapping("/api")
class ResetfulAPI {
    @GetMapping("/")
    fun index() = news2

    @PostMapping("/")
    @CrossOrigin("*")
    fun add(req: addRequest): Boolean {
        news2.add(News(req.title, req.address))
        return true
    }
data class addRequest(val title: String, val address: String)

}