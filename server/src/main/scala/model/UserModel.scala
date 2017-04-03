package scala.model


import endpoint.scala.api._
import slick.lifted.Tag
import slick.driver.MySQLDriver.api._
import slick.driver.MySQLDriver.backend.Database
import endpoint.parseuser.User
import model.UserEntity
import slick.backend.DatabaseConfig
import slick.dbio.DBIOAction
import slick.driver.{JdbcProfile, MySQLDriver}
import util.DatabaseService

import scala.concurrent.Future


/**
	* Created by locnguyen on 3/27/17.
	*/

trait UserEntityTable {

	protected val databaseService: DatabaseService
	import databaseService.driver.api._

	class Users(tag: Tag) extends Table[UserEntity](tag, "users") {
		def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
		def username = column[String]("username")
		def password = column[String]("password")

		def * = (id, username, password) <> ((UserEntity.apply _).tupled, UserEntity.unapply)
	}

	protected val users = TableQuery[Users]

}



