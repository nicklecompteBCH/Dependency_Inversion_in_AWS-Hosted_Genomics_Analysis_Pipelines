package SeqrDependencyLambdaService.wuxi

import SeqrDependencyLambdaService.util._
import SeqrDependencyLambdaService.aws._

case class GORDBContext(
    username: String,
    password: String,
    project: String,
    isLoggedIn: Boolean){
        def gordb_login(ctx: GORDBContext) : Either[String,FailedLoginError] = {
            val loginCommand = "" //s"./bin/gordb/bin/gordb login --allowpass --project=$(ctx.project) --user=$(ctx.username)/$(ctx.password) --site=connect.bchresearch.org"
            val result = "" //loginCommand.!!
            if (result contains "Login failed") {
                Left(result)
            } else {
                Right(FailedLoginError("gordb",ctx.username,None))
            }
        }

        def gordb_context_from_secrets_manager() : Option[GORDBContext] = {
            //val secret = SecretManagerHelper("gordb_login","us-east-2").get_secret()
            //secret
            None

        }
    }