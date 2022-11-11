package controllers

import javax.inject._
import play.api.mvc._
import service.JobAggregatorService

import scala.concurrent.ExecutionContext

@Singleton
class JobAggregatorController @Inject()(val controllerComponents: ControllerComponents, jobAggregatorService: JobAggregatorService)(implicit ec: ExecutionContext) extends BaseController {

  def index() = Action.async { implicit request: Request[AnyContent] =>
    jobAggregatorService.addJobTest("Test title").map(_ => Ok(""))
  }
}
