package route

import akka.actor.ActorSystem
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import de.heikoseeberger.akkahttpcirce.CirceSupport
import endpoint.parseuser
import endpoint.parseuser.GetAllUsersResponse
import endpoint.scala.api.UserEndpoint
import endpoints.akkahttp.server._
import restapi.services.UsersService
import slick.backend.DatabaseConfig

import scala.concurrent.Future
import scala.io.StdIn
import scala.util.Random
import scala.concurrent.ExecutionContext
import io.circe.generic.auto._
import io.circe.syntax._
import model.UserEntityUpdate

/**
	* Created by locnguyen on 3/27/17.
	*/
class UserServiceRoute(val userService: UsersService)(implicit executionContext: ExecutionContext) extends CirceSupport {

	import userService._

	val route = pathPrefix("users") {
		pathEndOrSingleSlash {
			get {
				complete(getUsers().map(x => x.asJson))
			}
		} ~ pathPrefix(IntNumber) { id =>
			pathEndOrSingleSlash {
				get {
					complete(getUserById(id).map(_.asJson))
				} ~ put {
					entity(as[UserEntityUpdate]) { userUpdate =>
						complete(updateUser(id, userUpdate).map(_.asJson))
					}
				} ~ delete {
					onSuccess(deleteUser(id)) { ignored =>
						complete("success delete user")
					}
				}
			}
		}
	}
}
