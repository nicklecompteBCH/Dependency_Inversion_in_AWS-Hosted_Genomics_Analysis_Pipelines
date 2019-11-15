package SeqrDependencyService.query

import SeqrDependencyService.genomics._

trait GenericQuery{
    def QuerySteps : Seq[QueryBase] // probably not going to stay like this
}