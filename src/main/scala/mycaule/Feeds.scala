package mycaule

import Models._

object Feeds {
  object NewsStatus extends Enumeration {
    type NewsStatus = Value
    val Sent, Delivered, Unread, Read = Value
  }

  case class News(
      status: NewsStatus.NewsStatus,
      reco: Recommenders.AssetReco
  )

  def subscribe(id: User.ID) = Databases.Channels.subscribe(id)

  def unsubscribe(id: User.ID) = Databases.Channels.unsubscribe(id)

  def add(userId: User.ID, assetId: Asset.ID) = Databases.Channels.add(userId, assetId)

  def feed(id: User.ID): List[News] = Databases.Channels.getAssetsByUser(id).map(asset => {
    News(
      NewsStatus.Read,
      Recommenders.AssetReco(
        asset.id,
        asset.name,
        asset.price
      )
    )
  })
}
