package mycaule

object Models {
  object User {
    case class ID(id: Int)
    case class Email(email: String)
    case class Name(name: String)
  }

  case class UserProfile(
      id: User.ID,
      name: User.Name,
      email: User.Email,
      preferences: Preferences
  )

  object AssetType extends Enumeration {
    type AssetType = Value
    val Appartment, House, Parking, Building, Studio = Value
  }

  object Features extends Enumeration {
    type Features = Value
    val Jardin, Piscine, Balcon = Value
  }

  case class Preferences(
      cities: List[String],
      assetType: AssetType.AssetType,
      surfaceRange: (Double, Double),
      priceRange: (Double, Double),
      features: List[Features.Features]
  )

  object Asset {
    case class ID(id: Int)
    case class Name(name: String)
    case class Price(price: Double)
    case class Surface(surf: Double)
  }

  case class Asset(
      id: Asset.ID,
      name: Asset.Name,
      address: String,
      city: String,
      price: Asset.Price,
      surface: Asset.Surface,
      features: List[Features.Features]
  )
}
