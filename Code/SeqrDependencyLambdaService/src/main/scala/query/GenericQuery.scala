package SeqrDependencyLambdaService.query

import SeqrDependencyLambdaService.genomics._

trait GenericQuery{
    def QuerySteps : Seq[QueryBase] // probably not going to stay like this
}