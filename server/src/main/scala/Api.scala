import endpoints.akkahttp.server._

import scala.concurrent.Future
import scala.util.Random

object Api extends ApiAlg with Endpoints with CirceEntities with OptionalResponses with BasicAuthentication {

	import akka.http.scaladsl.server.Directives._

	val routes =
		getUser.implementedBy{ case (username, password, _) => User(username, password) }
}


//val routes =
//	index.implementedBy {
//		case (name, age, _) => User(name, age)
//	} ~ action.implementedBy  {
//		param => ActionResult("Action")
//	} ~ actionFut.implementedByAsync {
//		param => Future.successful(ActionResult("Future Action"))
//	} ~
//		maybe.implementedBy  { _ =>
//			if (util.Random.nextBoolean()) Some(()) else None
//		} ~ auth.implementedBy { credentials =>
//		println(s"Authenticated request: ${credentials.username}")
//		if (Random.nextBoolean()) Some(()) else None // Randomly return a forbidden
//	}
//
//
//val getUser = endpoint(request(Get, path / "users" / segment[UserId]: Url[UserId], jsonRequest[GetUserRequest]), jsonResponse[GetUserResponse])
//
//val getAllUsers = endpoint(request(Get, path / "users": Url[Unit], jsonRequest[GetUserRequest]), jsonResponse[GetAllUsersResponse])
//
//val addUser = endpoint(request(Post, path / "users": Url[Unit], jsonRequest[AddUserRequest]), jsonResponse[AddUserResponse])
//
//val updateUser = endpoint(request(Put, path / "users" / segment[UserId]: Url[UserId], jsonRequest[UpdateUserRequest]), emptyResponse)
//
//val removeUser = endpoint(request(De
//
//
//
//val index =
//	endpoint(get(path / "user" / segment[String] /? (qs[Int]("age") & qs[String]("toto"))), jsonResponse[User])
//
//val action =
//	endpoint(post(path / "action", jsonRequest[ActionParameter]), jsonResponse[ActionResult])
//
//val actionFut =
//	endpoint(jsonRequest[ActionParameter], jsonResponse[ActionResult])
//
//val maybe =
//	endpoint(get(path / "option"), option(emptyResponse))
//
//val auth =
//	authenticatedEndpoint(Get, path / "auth", response = emptyResponse)
//
//val command/*: Endpoint[Command, Option[StoredEvent]]*/ =
//	endpoint(post(path / "command", jsonRequest[Command]), jsonResponse[Option[StoredEvent]])
//
//val actions = endpoint(request = path / "abc", )