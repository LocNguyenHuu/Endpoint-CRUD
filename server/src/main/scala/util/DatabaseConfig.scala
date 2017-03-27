package util

/**
	* Created by locnguyen on 3/27/17.
	*/
trait DatabaseConfig {
	val driver = slick.driver.MySQLDriver

	import driver.api._

	def db = Database.forConfig("database")

	implicit val session: Session = db.createSession()
}

