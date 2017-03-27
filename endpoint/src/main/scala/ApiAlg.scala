import java.util.UUID

import endpoints.algebra.{CirceEntities, Endpoints}
//import endpoints.algebra._
import io.circe.Decoder
import io.circe.Encoder

import io.circe.generic.JsonCodec
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveDecoder
import io.circe.generic.extras.semiauto.deriveEncoder
import io.circe.generic.extras.semiauto.deriveEnumerationDecoder
import io.circe.generic.extras.semiauto.deriveEnumerationEncoder
import io.circe.generic.auto._
/**
	* Created by locnguyen on 3/23/17.
	*/

trait ApiAlg extends Endpoints with CirceEntities {
	implicit val userIdSegment: Segment[UserId]

	val getUser = endpoint(request(Get, path / "users" / segment[UserId]: Url[UserId], jsonRequest[GetUserRequest]), jsonResponse[GetUserResponse])

	val getAllUsers = endpoint(request(Get, path / "users": Url[Unit], jsonRequest[GetUserRequest]), jsonResponse[GetAllUsersResponse])

	val addUser = endpoint(request(Post, path / "users": Url[Unit], jsonRequest[AddUserRequest]), jsonResponse[AddUserResponse])

	val updateUser = endpoint(request(Put, path / "users" / segment[UserId]: Url[UserId], jsonRequest[UpdateUserRequest]), emptyResponse)

	val removeUser = endpoint(request(Delete, path / "users" / segment[UserId]: Url[UserId], emptyRequest), emptyResponse)
}

case class User(
	username: String,
	password: String
)

case class UserId(uuid: UUID) {
	def idString: String = uuid.toString
}

final case class GetUserRequest(
	userId: UserId
)

object GetUserRequest {
	implicit val encoder: Encoder[GetUserRequest] = deriveEncoder
	implicit val decoder: Decoder[GetUserRequest] = deriveDecoder
}

final case class GetUserResponse(
	user: User
)

object GetUserResponse {
	implicit val encoder: Encoder[GetUserResponse] = deriveEncoder
	implicit val decoder: Decoder[GetUserResponse] = deriveDecoder
}
final case class GetAllUsersResponse(
	usernadIds: Seq[(UserId, User)]
)

object GetAllUsersResponse {
	implicit val encoder: Encoder[GetAllUsersResponse] = deriveEncoder
	implicit val decoder: Decoder[GetAllUsersResponse] = deriveDecoder
}

final case class AddUserRequest(
	username: String,
	password: String
)

object AddUserRequest {
	implicit val encoder: Encoder[AddUserRequest] = deriveEncoder
	implicit val decoder: Decoder[AddUserRequest] = deriveDecoder
}
final case class AddUserResponse(
	userId: UserId,
	user: User
)

object AddUserResponse {
	implicit val encoder: Encoder[AddUserResponse] = deriveEncoder
	implicit val decoder: Decoder[AddUserResponse] = deriveDecoder
}

final case class UpdateUserRequest(
	user: User
)

object UpdateUserRequest {
	implicit val encoder: Encoder[UpdateUserRequest] = deriveEncoder
	implicit val decoder: Decoder[UpdateUserRequest] = deriveDecoder
}

object circe {
	implicit val config = Configuration.default.withSnakeCaseKeys

	implicit val userEncoder: Encoder[User] = deriveEncoder
	implicit val userDecoder: Decoder[User] = deriveDecoder
}