package br.com.lotominer.util

import java.net.CookieHandler
import java.net.CookieManager
import java.net.CookiePolicy
import java.net.URL

object DownloaderUtil {
    fun download(url: String){
        CookieHandler.setDefault(CookieManager(null, CookiePolicy.ACCEPT_ALL))
        val urlObject = URL(url)
        val connection = urlObject.openConnection()
        ZipFileUtil.unzip(connection.getInputStream(), Constant.FILE_NAME)
    }
}