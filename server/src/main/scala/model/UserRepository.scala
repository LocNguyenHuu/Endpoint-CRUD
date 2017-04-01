package scala.model

import endpoint.parseuser.User
import slick.dbio.DBIOAction
import slick.driver.MySQLDriver.api._
import util.{DatabaseConfig, MySQLDBImp}

import scala.concurrent.Future

/**
	* Created by locnguyen on 3/27/17.
	*/
//final class UserRepository(val config: DatabaseConfig[JdbcProfile]) extends Db with UsersTables {
//
//	import scala.concurrent.ExecutionContext.Implicits.global
//
//	def init() = db.run(DBIOAction.seq(users.schema.create))
//	def drop() = db.run(DBIOAction.seq(users.schema.drop))
//
//	def insert(user: User) = db.run(users += user)
//
//	def insert(user: User) = db.run(users returning users.map(_.id) += user).map(id => user.copy(id = Some(id)))
//
//	def find(id: Int) = db.run((for (user <- users if user.id === id) yield user).result.headOption)
//
//	def findAll(): Future[List[User]] = db.run {
//		users.to[List].result
//	}
//
//	def update(id: Int, username: Option[String], password: Option[String]) = {
//		val query = for (user <- users if user.id === id)
//			yield (user.username, user.password)
//		db.run(query.update(username, password)) map { _ > 0}
//	}
//
//	def delete(id: Int) = {
//		db.run(users.filter(_.id === id).delete) map { _ > 0}
//	}
//}

trait UserRepository extends UsersTables { this: DatabaseConfig =>

	def findAll(): Future[List[User]] = db.run {
		println("call find all user")
		users.to[List].result
	}

	def ddl = db.run {
		println("Call users schema")
		users.schema.create
	}
}

trait UserRepositoryImpl extends UserRepository with MySQLDBImp
