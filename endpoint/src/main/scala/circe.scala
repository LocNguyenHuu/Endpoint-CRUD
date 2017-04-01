import io.circe.{Decoder, Encoder}
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.{deriveDecoder, deriveEncoder}
import endpoint.parseuser.User
/**
	* Created by locnguyen on 3/28/17.
	*/
object circe {
	implicit val config = Configuration.default.withSnakeCaseKeys

	implicit val userEncoder: Encoder[User] = deriveEncoder
	implicit val userDecoder: Decoder[User] = deriveDecoder
}