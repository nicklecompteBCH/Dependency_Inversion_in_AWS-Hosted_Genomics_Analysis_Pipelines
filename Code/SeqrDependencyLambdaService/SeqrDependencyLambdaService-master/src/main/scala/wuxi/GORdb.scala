package SeqrDepdencyLambdaService.wuxi

import SeqrDepdencyLambdaService.util._
import scala.sys.process._

case class GORDBContext(
    username: String,
    password: String,
    project: String,
    isLoggedIn: Boolean){
        def login(ctx: GORDBContext) : Result[String,FailedLoginError] =
            loginCommand = s"./gordb login --allowpass --project=$(ctx.project) --user=$(ctx.username)/$(ctx.password) --site=connect.bchresearch.org"
            result = loginCommand.!!
            OK(result)
    }