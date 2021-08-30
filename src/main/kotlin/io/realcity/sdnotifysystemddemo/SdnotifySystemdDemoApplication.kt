package io.realcity.sdnotifysystemddemo

import info.faljse.SDNotify.SDNotify
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.util.logging.Logger

@EnableScheduling
@SpringBootApplication
class SdnotifySystemdDemoApplication {

    @Scheduled(cron = "0 * * * * *")
    fun runSdNotify() {
        if (SDNotify.isWatchdogEnabled()) {
            logger.info("SDNotify - watchdog is enabled")
            SDNotify.sendWatchdog()
            logger.info("SDNotify - watchdog sent")
        } else {
            logger.info("SDNotify - watchdog is not enabled")
        }
    }

    companion object {
        private val logger = Logger.getLogger(SdnotifySystemdDemoApplication::class.java.getCanonicalName())

        @JvmStatic
        fun main(args: Array<String>) {
            SDNotify.sendNotify()
            logger.info("SDNotify - notification sent")
            runApplication<SdnotifySystemdDemoApplication>(*args)
        }
    }
}
