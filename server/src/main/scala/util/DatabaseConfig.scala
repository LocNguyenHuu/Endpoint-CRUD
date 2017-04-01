package util

import slick.driver.JdbcProfile

/**
	* Created by locnguyen on 3/27/17.
	*/
import com.typesafe.config._

object Config {
	val env = if (System.getenv("SCALA_ENV") == null) "development" else System.getenv("SCALA_ENV")

	val conf = ConfigFactory.load()
	def apply() = conf.getConfig(env)
}

trait DatabaseConfig {
	val driver: JdbcProfile

	import driver.api._

	val db = Config().getString("mysql")

//	val db = Database.forConfig("mysql")
}

