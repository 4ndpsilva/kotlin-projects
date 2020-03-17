package br.com.lotominer.util

import org.apache.tomcat.util.http.fileupload.IOUtils
import java.io.FileOutputStream
import java.io.InputStream
import java.util.zip.ZipInputStream

object ZipFileUtil {
    fun unzip(input: InputStream, fileName: String){
        val source = ZipInputStream(input)
        var ze = source.nextEntry

        while(ze != null){
            if(ze.name.contains(Constant.EXTENSION.toLowerCase())){
                val destination = FileOutputStream(fileName)
                IOUtils.copy(source, destination)
                break
            }
            ze = source.nextEntry
        }
    }
}