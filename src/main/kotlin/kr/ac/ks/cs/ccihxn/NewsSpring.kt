package kr.ac.ks.cs.ccihxn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class NewsSpring

fun main(args: Array<String>) {
    runApplication<CcihxnApplication>(*args)
}

@Controller
class NewsController {
    data class News(val title: String, val address: String)

    var news = mutableListOf(

        News("누리호 5월 24일 3차 발사...인공위성 8개 싣고 우주로",
            "https://n.news.naver.com/mnews/article/448/0000404277?sid=105"),

        News("‘넷플릭스’ 잡으려다 ‘누누티비’까지 등장... 적자폭 껑충 뛴 토종 OTT",

            "https://n.news.naver.com/mnews/article/366/0000892375?sid=105"),
        News("The end of a myth: Distributed transactions can scale",

            "https://muratbuffalo.blogspot.com/2023/04/the-end-of-myth-distributed.html"),

        News("Getting the ^D", "https://owengage.com/writing/2023-04-08-getting-the-ctrl-d/")

    )


    @GetMapping("/news")
    fun home(model: Model): String{
        model.addAttribute("newsList", news)
        return "news"
    }

    @PostMapping("/news")
    fun add(req: NewsAddRequest): String {

        news.add(News(req.title, req.address))
        return "redirect:/news"

    }

    @DeleteMapping("/news/{idx}")
    @ResponseBody
    fun delete(@PathVariable idx: Int): Boolean =
        Result.runCatching { news.removeAt(idx) }.isSuccess

    @PutMapping("/news/{idx}")
    @ResponseBody
    fun update(@PathVariable idx: Int, @RequestBody form: NewsDTO): Boolean {
        return Result.runCatching {
            news[idx] = News(form.title ?: "제목 없음", form.address ?: "#")
        }.isSuccess
    }

    data class NewsDTO (val title: String?, val address: String?)

    data class NewsAddRequest(val title: String, val address: String)
}