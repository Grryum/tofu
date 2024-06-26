package tofu.internal
package instances

import cats.MonadError
import tofu.Fire
import tofu.compat.unused
import tofu.internal.carriers.{FibersCarrier2, FibersCarrier3}

private[tofu] trait FireInstance extends FireInstances0 {
  final implicit def byCarrierCE3[F[_], E](implicit
      @unused FE: MonadError[F, E],
      carrier: FibersCarrier3[F, E]
  ): Fire[F] = carrier.content
}

private[tofu] trait FireInstances0 {
  final implicit def byCarrierCE2[F[_]](implicit
      carrier: FibersCarrier2[F]
  ): Fire[F] = carrier.content
}
