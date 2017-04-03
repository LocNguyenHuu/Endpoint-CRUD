package restapi.services

import model.UserEntity
import util.DatabaseService

import scala.concurrent.{ExecutionContext, Future}
import scala.model.UserEntityTable

class UserService(val databaseService: DatabaseService)(implicit executionContext: ExecutionContext)
extends UserEntityTable {

	import databaseService._
	import databaseService.driver.api._

	def getUsers(): Future[Seq[UserEntity]] = db.run(users.result)
}