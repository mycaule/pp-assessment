package mycaule
import Models._

object Recommenders {
  case class UserReco(id: User.ID, name: User.Name, email: User.Email)
  case class AssetReco(id: Asset.ID, name: Asset.Name, price: Asset.Price)

  object Users {
    def recommendations(asset: Asset): List[UserReco] = {
      Databases.Users.searchMatching(asset).map(UserReco.tupled)
    }
  }

  object Assets {
    def recommendations(user: UserProfile): List[AssetReco] = ???
  }
}
