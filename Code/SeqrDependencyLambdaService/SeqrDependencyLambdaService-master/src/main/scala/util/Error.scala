package SeqrDepdencyLambdaService.util

sealed trait Result[ReturnType,ErrorType]

case object OK[ReturnType](returnValue: ReturnType) extends Result[ReturnType,_]
case object Error[ErrorType](error:ErrorType) extends Result[_, ErrorType]

case class FailedLoginError(
    serviceName: String,
    userName: String,
    failureReason: Option[Either[String,Exception]]
)