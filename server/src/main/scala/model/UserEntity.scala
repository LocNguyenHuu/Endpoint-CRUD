package model

import org.mindrot.jbcrypt.BCrypt

/**
	* Created by locnguyen on 3/27/17.
	*/
case class UserEntity(id: Option[Long] = None, username: String, password: String) {
	require(!username.isEmpty, "username.empty")
	require(!password.isEmpty, "password.empty")
	def withHashedPassword(): UserEntity = this.copy(password = BCrypt.hashpw(password, BCrypt.gensalt()))
}

case class UserEntityUpdate(username: Option[String] = None, password: Option[String] = None) {
	def merge(user: UserEntity): UserEntity = {
		UserEntity(user.id, username.getOrElse(user.username), password.map(ps => BCrypt.hashpw(ps, BCrypt.gensalt())).getOrElse(user.password))
	}
}