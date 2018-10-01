package com.example.updateReturning

object UserDAO {

  import slick.jdbc.PostgresProfile.api._

  class UserTable(tag: Tag) extends Table[User](tag, "users") {

    def id = column[Long]("ad", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def * = (name, id.?) <> ((User.apply _).tupled, User.unapply)

  }

  lazy val users = TableQuery[UserTable]

}
