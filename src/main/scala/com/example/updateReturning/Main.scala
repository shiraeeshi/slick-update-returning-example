package com.example.updateReturning

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import slick.jdbc.PostgresProfile.api._

import utils.Slick.UpdateReturning._

object Main extends App {

  val users = UserDAO.users

  using(Database.forConfig("db")) { implicit db =>

    val createSchemaAndPopulate = for {
      _ <- users.schema.create
      _ <- users ++= Seq(
        User("Ann")
        , User("Ann")
        , User("Ann")
        , User("John")
        , User("John")
        , User("Mark")
        )
    } yield ()

    scala.concurrent.Await.result(db.run(createSchemaAndPopulate), 5.seconds)

    val update = users.filter(_.name === "Ann").map(_.name).updateReturning(users, "Jane")

    println("update statements:")
    update.statements.foreach(println)

    val updatedUsers = scala.concurrent.Await.result(db.run(update), 5.seconds)
    println(s"--------------updatedUsers: $updatedUsers")
  }

  def using[A <: AutoCloseable, B](resource: A)(block: A => B): B =
    try block(resource) finally resource.close()
}
