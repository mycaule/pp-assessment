package mycaule

import org.scalatest._
import Models._

class UsersRecommenderSpec extends FlatSpec with Matchers {
  val asset = Asset(
    Asset.ID(1),
    Asset.Name("super appart"),
    "rue de la Paix",
    "paris",
    Asset.Price(510000),
    Asset.Surface(82),
    List(Features.Jardin, Features.Piscine)
  )

  "The UsersRecommender object" should "recommend users for a given asset" in {
    Recommenders.Users.recommendations(asset).length shouldEqual 3
  }
}
