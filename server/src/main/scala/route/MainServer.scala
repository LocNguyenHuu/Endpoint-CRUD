//package route
//
//import akka.actor.ActorSystem
//import akka.http.scaladsl.Http
//import akka.stream.ActorMaterializer
//
//import scala.io.StdIn
//import scala.services.UserService
//
///**
//	* Created by locnguyen on 4/1/17.
//	*/
//
//class HttpService(userService: UserService) {
//	val userRouter = new UserServer(userService)
//
//	val routes = userRouter.routes
//}