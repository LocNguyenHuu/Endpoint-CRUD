import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import restapi.services.UsersService
import restapi.utils.{DatabaseService, FlywayService}
import route.HttpService
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._

import scala.concurrent.ExecutionContext
import scala.io.StdIn
/**
	* Created by locnguyen on 4/1/17.
	*/
object Main extends App with Config {

	implicit val actorSystem = ActorSystem()
	implicit val executor: ExecutionContext = actorSystem.dispatcher
	implicit val log: LoggingAdapter = Logging(actorSystem, getClass)
	implicit val materializer: ActorMaterializer = ActorMaterializer()

//	val flywayService = new FlywayService(jdbcUrl, dbUser, dbPassword)
//	flywayService.migrateDatabaseSChema()

	val databaseService = new DatabaseService(jdbcUrl, dbUser, dbPassword)

	val usersService = new UsersService(databaseService)
	val httpService = new HttpService(usersService)

	Http().bindAndHandle(httpService.routes, httpHost, httpPort)

}