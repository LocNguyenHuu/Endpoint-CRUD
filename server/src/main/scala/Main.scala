import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import route.UserServer
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import util.DatabaseConfig
import slick.driver.MySQLDriver.api._

import scala.io.StdIn
import scala.model.{UserRepository, UserRepositoryImpl}
/**
	* Created by locnguyen on 4/1/17.
	*/
object Main extends App with UserServer with UserRepositoryImpl {

	implicit val system = ActorSystem("example")
	implicit val materializer = ActorMaterializer()
	implicit val dispatcher = system.dispatcher

	println("Call before complete")
	ddl.onComplete {
		_ =>
			val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)

			println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
			StdIn.readLine() // let it run until user presses return
			bindingFuture
				.flatMap(_.unbind()) // trigger unbinding from the port
				.onComplete(_ => system.terminate()) // and shutdown when done
	}
}