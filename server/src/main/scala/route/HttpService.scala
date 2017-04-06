package route

import restapi.services.{UsersService}
import akka.http.scaladsl.server.Directives._

import scala.concurrent.ExecutionContext
/**
	* Created by locnguyen on 4/3/17.
	*/
class HttpService(userSerice: UsersService)(implicit  executionContext: ExecutionContext) {
	val usersRouter = new UserServiceRoute(userSerice)

	val routes = pathPrefix("v1") {
		usersRouter.route
	}
}
