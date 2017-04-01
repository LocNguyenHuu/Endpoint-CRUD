package scala.model


import endpoint.scala.api._
import slick.lifted.Tag
import slick.driver.MySQLDriver.api._
import util.DatabaseConfig
import endpoint.parseuser.User


/**
	* Created by locnguyen on 3/27/17.
	*/

//case class User(id: Int, username: String, password: String)

trait UsersTables { this: DatabaseConfig =>

	import driver.api._

	class Users(tag: Tag) extends Table[User](tag, "Users") {
		def id = column[Int]("id", O.PrimaryKey)
		def username = column[String]("username")
		def password = column[String]("password")

		def * = (id, username, password) <> (User.tupled, User.unapply)
	}

	lazy val users = TableQuery[Users]
}




