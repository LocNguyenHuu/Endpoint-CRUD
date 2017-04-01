//package scala.services
//
//import com.sun.javafx.tk.Toolkit
//import endpoint.parseuser.UserId
//import endpoint.parseuser.User
//
//import scala.model._
//import org.mindrot.jbcrypt.BCrypt
//import monix.eval.Task
//
//import scala.concurrent._
//import scala.model
//
///**
//	* Created by locnguyen on 3/27/17.
//	*/
//class UserService(userRepo: UserRepository) {
//	def getAll(): Future[List[User]] = {
//		userRepo.findAll()
//	}
//}