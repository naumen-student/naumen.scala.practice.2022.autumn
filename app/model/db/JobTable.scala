package model.db

import model.Job
import slick.jdbc.PostgresProfile.api._

import java.util.UUID

class JobTable(tag: Tag) extends Table[Job](tag, "job") {
    def id = column[UUID]("id", O.PrimaryKey)
    def title = column[String]("title")


    def * = (id,title) <> (Job.tupled, Job.unapply)
}

