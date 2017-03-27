package route

import akka.http.javadsl.server.directives.SecurityDirectives
import services.UsersService

/**
	* Created by locnguyen on 3/27/17.
	*/
trait UsersServiceRoute extends UsersService with SecurityDirectives {


}
