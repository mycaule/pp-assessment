package mycaule
import Models._
// This is a fake Database provider
// MySQL and Algolia is already used
// Let's suppose we add Redis to the stack for alerting

// Good practice is to use Either to handle potential errors

object Databases {
  object Channels {
    // Redis calls here

    def subscribe(id: User.ID): Unit =
      print(s"REDIS SUBSCRIBE assets:$id")

    def unsubscribe(id: User.ID): Unit =
      print(s"REDIS UNSUBSCRIBE assets:$id")

    def add(userId: User.ID, assetId: Asset.ID): Unit =
      print(s"REDIS RPUSH assets:$userId $assetId")

    def getAssetsByUser(userId: User.ID): List[Asset] = {
      print(s"REDIS GET assets:$userId")
      val AssetIDs = List(1, 2, 3).map(Asset.ID.apply)
      AssetIDs.map(Assets.getById)
    }
  }

  object Assets {
    // MySQL and Algolia calls here

    def getById(id: Asset.ID): Asset = {
      print(s"MySQL SELECT * FROM assets WHERE ID = $id;")

      id match {
        case Asset.ID(i) =>
          Asset(
            Asset.ID(i),
            Asset.Name(s"Super appart n° $i"),
            "rue de la Paix",
            "paris",
            Asset.Price(510000 + 10 * i),
            Asset.Surface(82),
            List(Features.Jardin, Features.Piscine)
          )
        case _ =>
          Asset(
            Asset.ID(99),
            Asset.Name(s"Studio pas terrible"),
            "rue Saint-Denis",
            "paris",
            Asset.Price(100000),
            Asset.Surface(15),
            Nil
          )
      }
    }

    def search(prefs: Preferences): List[Asset] = {
      print(s"ALGOLIA search $prefs")

      List(
        Asset(
          Asset.ID(99),
          Asset.Name(s"Studio pas terrible"),
          "rue Saint-Denis",
          "paris",
          Asset.Price(100000),
          Asset.Surface(15),
          Nil
        )
      )
    }
  }

  object Users {
    // MySQL calls here
    def getById(id: User.ID): UserProfile = ???

    def findByPrice(price: Double): List[UserProfile] = ???

    def findByLocation(city: String): List[UserProfile] = ???

    def searchMatching(asset: Asset): List[(User.ID, User.Name, User.Email)] =
      List(
        (User.ID(1515), User.Name("Alice"), User.Email("alice@fakemail.com")),
        (User.ID(1516), User.Name("Bob"), User.Email("bob@fakemail.com")),
        (User.ID(1516), User.Name("Charles"), User.Email("charles@fakemail.com"))
      )
  }
}
