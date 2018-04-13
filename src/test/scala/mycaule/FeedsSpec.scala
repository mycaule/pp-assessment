package mycaule

import org.scalatest._
import Models._

class FeedsSpec extends FlatSpec with Matchers {
  "Feeds" should "get the list of all relevant assets for a user's channel" in {
    Feeds.feed(User.ID(1515)).length shouldEqual 3
  }

  "Feeds" should "support adding an asset to a user's channel" in {
    Feeds.add(User.ID(1515), Asset.ID(14))
  }

  "Feeds" should "allow someone to subscribe or unsubscribe a user's channel" in {
    Feeds.subscribe(User.ID(1515))
    Feeds.unsubscribe(User.ID(1515))
  }
}
