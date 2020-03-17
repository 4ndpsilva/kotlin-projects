package br.com.lotominer

import br.com.lotominer.util.Constant
import br.com.lotominer.util.DownloaderUtil
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.nio.file.Files
import java.nio.file.Paths

@SpringBootApplication
class LotoMinerApplication : CommandLineRunner{
	override fun run(vararg args: String?) {
		if(Files.notExists(Paths.get(Constant.FILE_NAME))){
			DownloaderUtil.download(Constant.URL)
		}
	}
}

fun main(args: Array<String>) {
	runApplication<LotoMinerApplication>(*args)
}