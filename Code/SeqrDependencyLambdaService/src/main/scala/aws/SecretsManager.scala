package SeqrDependencyLambdaService.aws

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder
import com.amazonaws.services.secretsmanager.model._

import SeqrDependencyLambdaService.util._

class SecretManagerHelper(secretName: String, region: String){

    def get_secret() : Either[String,Exception] = {

      val client = AWSSecretsManagerClientBuilder.standard().withRegion(region).build()

      val getSecretValueRequest: GetSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName)

      var getSecretValueResult: GetSecretValueResult = null

      try {
        getSecretValueResult = client.getSecretValue(getSecretValueRequest)

      } catch {
          case e : Exception => Right(e)
        // case e: InternalServiceErrorException =>
        //   throw e
        // case e: DecryptionFailureException =>
        //   throw e
        // case e: InvalidParameterException =>
        //   throw e
        // case e: InvalidRequestException =>
        //   throw e
        // case e: ResourceNotFoundException =>
        //   throw e
      }

      Left(getSecretValueResult.getSecretString())
    }
}
