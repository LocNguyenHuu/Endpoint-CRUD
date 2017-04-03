import com.typesafe.config.ConfigFactory
//package util
//
//import com.typesafe.config._
//import slick.driver.JdbcProfile
//
///**
//	* Created by locnguyen on 3/27/17.
//	*/
//
//
////object Config {
////	val env = if (System.getenv("SCALA_ENV") == null) "development" else System.getenv("SCALA_ENV")
////
////	val conf = ConfigFactory.load()
////	def apply() = conf.getConfig(env)
////}
//
//trait DatabaseConfig {
//	val driver: JdbcProfile
//
//	import driver.api._
//
//
////	val db = DriverManager.getConnection("jdbc:mysql://localhost:3306/Arkmaxim?autoReconnect=true&useSSL=false", "root", "")
////	val db = Config().getString("mysql")
//
//	val db = Database.forConfig("mysql")
//}
//

trait Config {
	private val config = ConfigFactory.load()
	private val httpConfig = config.getConfig("http")
	private val databaseConfig = config.getConfig("database")

	val httpHost = httpConfig.getString("interface")
	val httpPort = httpConfig.getInt("port")

	val jdbcUrl = databaseConfig.getString("url")
	val dbUser = databaseConfig.getString("user")
	val dbPassword = databaseConfig.getString("password")
}