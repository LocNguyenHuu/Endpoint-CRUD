package util

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}

/**
	* Created by locnguyen on 4/3/17.
	*/
class DatabaseService(jdbcUrl: String, dbUse: String, dbPassword: String) {
	private val hikariConfig = new HikariConfig()
	hikariConfig.setJdbcUrl(jdbcUrl)
	hikariConfig.setUsername(dbUse)
	hikariConfig.setPassword(dbPassword)

	private val dataSource = new HikariDataSource(hikariConfig)

	val driver = slick.driver.PostgresDriver
	import driver.api._
	val db = Database.forDataSource(dataSource)
	db.createSession()
}
