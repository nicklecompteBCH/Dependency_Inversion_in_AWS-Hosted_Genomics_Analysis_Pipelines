package SeqrDependencyLambdaService.util

sealed trait Result[ReturnType,ErrorType]

// case object OK[ReturnType,ErrorType]](returnValue: ReturnType) extends Result[ReturnType,ErrorType]];
// case object Error[ReturnType,ErrorType](error:ErrorType) extends Result[ReturnType, ErrorType];

case class FailedLoginError(
    serviceName: String,
    userName: String,
    failureReason: Option[Either[String,Exception]]
)