package example

import scala.sys.process._

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder
import com.amazonaws.services.secretsmanager.model._

import SeqrDependencyLambdaService.wuxi

class ScalaLambda extends RequestHandler[String, String] {
  override def handleRequest(event: String, context: Context): String = {

    // AWS Secrets Manager

    // input format: chr,min,max,service
    // input is:     "1,100,500,Wuxi"  or  "1,100,500,Hail"
    val args = event.split(",")

    if (args(3).equalsIgnoreCase("WUXI")) {

        val loginCommand = ".bin/gordb/bin/gordb" //s"./bin/gordb/bin/gordb login --allowpass --project=$(ctx.project) --user=$(ctx.username)/$(ctx.password) --site=connect.bchresearch.org"
        loginCommand.!!


    } else if (args(3).equalsIgnoreCase("HAIL")) {
      /*GET test1/_search
        {
          "query": {
            "bool" : {
              "must" : [
                {"match" : {"locus.contig" : "1"}},
                {"range" :
                  {
                    "locus.position" : {
                    "gte" : 900000,
                    "lt" : 1000000
                    }
                  }
                }
              ]
            }
          }
        }*/

      val url = "https://search-test2-hnkwuh5gdzna4fwynnbelmggkq.us-east-2.es.amazonaws.com/_search?q=locus.contig:" +
        args(0) + "%20AND%20locus.position:[" + args(1) + "+TO+" + args(2) + "]&pretty"
      val content = scala.io.Source.fromURL(url).mkString
      content
    }
    "Error Service"
  }
}