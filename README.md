
<p align="center">
  March 2018 PP Interview Assessment
</p>

<p align="center">
  <a href="http://travis-ci.org/mycaule/pp-assessment"><img src="https://api.travis-ci.org/mycaule/pp-assessment.svg?branch=master" alt="Build Status"></a>
  <br>
  <br>
</p>


## Running the project
```
sbt test
```

## Architecture proposal

I only investigated to backend aspects of the problems.

We maintain channels in Redis, these channels contain a list of assets specific to each users for them to subscribe to consume.

We suppose users and assets collections are available through the already available stack with MySQL and Algolia.

The application needs to have a recommender component:
- based on a given asset, returns a list of recommended users (potential buyers). Retrieval is made through MySQL.
- based on a given user, returns a list of recommended assets. Retrieval is made through Algolia InstantSearch.

So in the event when an asset is added, those tasks are performed:
- update MySQL assets table,
- update Algolia's index,
- update Redis channels

Clients of the user's Redis channel can be websockets, emails, push notifications or a Facebook-like newsfeed. This way publish/subscribe mechanisms can be used to alert the relevant users of the event above.

The Feed component provides a generic interface for these types of notification.
