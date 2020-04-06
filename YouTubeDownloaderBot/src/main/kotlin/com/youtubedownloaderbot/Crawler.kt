package com.youtubedownloaderbot

import org.jsoup.Jsoup

class Crawler {
    private val url = "https://notube.net/convert-pt/pt"

    fun execute(): String{
        val doc = Jsoup.connect(url).get()
        println("abrindo")
        Thread.sleep(2000)
        println("pronto")
        val input = doc.getElementById("keyword")
        println(input.html())
        return input.html() ?: "nao encontrado"
    }
}