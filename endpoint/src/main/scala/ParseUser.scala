package endpoint.parseuser

import java.util.UUID

import io.circe.{Decoder, Encoder}
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.generic.auto._
import io.circe.syntax._

import scala.concurrent.Future

/**
	* Created by locnguyen on 3/28/17.
	*/
case class User(id: Option[Long] = None, username: String, password: String)

//final case class GetUserRequest(
//	userId: UserId
//)
//
//object GetUserRequest {
//	implicit val encoder: Encoder[GetUserRequest] = deriveEncoder
//	implicit val decoder: Decoder[GetUserRequest] = deriveDecoder
//}
//
//final case class GetUserResponse(
//	user: User
//)
//
//object GetUserResponse {
//	implicit val encoder: Encoder[GetUserResponse] = deriveEncoder
//	implicit val decoder: Decoder[GetUserResponse] = deriveDecoder
//}

final case class GetAllUsersResponse(
	user: Seq[User]
)

object GetAllUsersResponse {
	implicit val encoder: Encoder[GetAllUsersResponse] = deriveEncoder
	implicit val decoder: Decoder[GetAllUsersResponse] = deriveDecoder
}

//final case class AddUserRequest(
//	username: String,
//	password: String
//)
//
//object AddUserRequest {
//	implicit val encoder: Encoder[AddUserRequest] = deriveEncoder
//	implicit val decoder: Decoder[AddUserRequest] = deriveDecoder
//}
//final case class AddUserResponse(
//	userId: UserId,
//	user: User
//)
//
//object AddUserResponse {
//	implicit val encoder: Encoder[AddUserResponse] = deriveEncoder
//	implicit val decoder: Decoder[AddUserResponse] = deriveDecoder
//}
//
//final case class UpdateUserRequest(
//	user: User
//)
//
//object UpdateUserRequest {
//	implicit val encoder: Encoder[UpdateUserRequest] = deriveEncoder
//	implicit val decoder: Decoder[UpdateUserRequest] = deriveDecoder
//}
