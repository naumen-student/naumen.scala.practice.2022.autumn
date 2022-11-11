package service

import model.Job
import model.db.DBTables.jobTable
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.jdbc.PostgresProfile.api._

import java.util.UUID
import javax.inject.{Inject, Singleton}

import scala.concurrent.Future

@Singleton
class JobAggregatorService @Inject()(val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {

    def addJobTest(title: String): Future[Int] = {
        db.run(jobTable += Job(UUID.randomUUID(), title))
    }

}
