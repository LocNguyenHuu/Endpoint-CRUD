package route

import akka.actor.ActorSystem
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import endpoint.parseuser
import endpoint.parseuser.GetAllUsersResponse
import endpoint.scala.api.UserEndpoint
import endpoints.akkahttp.server._
import monix.eval.Task
import monix.execution.Scheduler
import restapi.services.UserService
import slick.backend.DatabaseConfig

import scala.concurrent.Future
import scala.io.StdIn
import scala.util.Random
import scala.concurrent._
import ExecutionContext.Implicits.global
/**
	* Created by locnguyen on 3/27/17.
	*/
class UserServer(val userService: UserService)(implicit executionContext: ExecutionContext) extends UserEndpoint with Endpoints with CirceEntities {

	import userService._
	
	val route = getAllUsers.implementedByAsync { _ =>
		userService.getUsers().map(GetAllUsersResponse.apply)
	}.runAsync
}
