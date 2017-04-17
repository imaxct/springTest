package imaxct


import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

/**
 * Created by imaxct on 17-4-6.
 */
object LogTest {
    private val logger = LogManager.getLogger(LogTest::class.java)

    @JvmStatic fun main(args: Array<String>) {
        logger.warn("warn")
        logger.debug("debug")
        logger.error("error")
    }
}
