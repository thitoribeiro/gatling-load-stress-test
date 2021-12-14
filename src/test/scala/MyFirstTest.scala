import io.gatling.core.Predef._
import io.gatling.http.Predef._


class MyFirstTestm extends Simulation {

  // 1 Http Conf
  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header("Acept", "application/json")
    //.proxy(Proxy("localhost", 8888))

  // 2 Scenario Definition
  val scn = scenario("My First Test")
    .exec(http("Get All Games")
    .get("videogames"))

  // 3Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)


}
