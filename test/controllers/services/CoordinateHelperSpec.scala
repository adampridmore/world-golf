import org.scalatestplus.play.PlaySpec
// package controllers.services

import org.scalatest._
import org.scalatest.Matchers._
// import org.eclipse.jetty.util.PathWatcher.DirAction
// import math._

// // https://www.movable-type.co.uk/scripts/latlong.html
object CoordinateHelper {
  val R = 6372.8  //radius in km

  def move(position: Position, vector: Vector) = {
  
    val aφ1 = position.latitude.v
    val aλ1 = position.longitude.v
    val d = vector.distance.v

    val brng = vector.direction.v.toRadians

    val aφ2 = Math.asin( Math.sin(aφ1)*Math.cos(d/R) +
                       Math.cos(aφ1)*Math.sin(d/R)*Math.cos(brng) );

    val aλ2 = aλ1 + Math.atan2(Math.sin(brng)*Math.sin(d/R)*Math.cos(aφ1),
                            Math.cos(d/R)-Math.sin(aφ1)*Math.sin(aφ2));

    position
  }

//   // def haversine(lat1:Double, lon1:Double, lat2:Double, lon2:Double)={
//   //   val dLat=(lat2 - lat1).toRadians
//   //   val dLon=(lon2 - lon1).toRadians

//   //   val a = pow(sin(dLat/2),2) + pow(sin(dLon/2),2) * cos(lat1.toRadians) * cos(lat2.toRadians)
//   //   val c = 2 * asin(sqrt(a))
//   //   R * c
//   // }
 
//   // def main(args: Array[String]): Unit = {
//   //   println(haversine(36.12, -86.67, 33.94, -118.40))
//   // }
}

case class Longitude(val v: Double) extends AnyVal
case class Latitude(val v: Double) extends AnyVal
case class Direction(val v: Double) extends AnyVal
case class Distance(val v: Double) extends AnyVal

case class Position(longitude: Longitude, latitude: Latitude)
case class Vector(direction: Direction, distance: Distance)

class CoordinateHelperSpec extends WordSpec {
  // val coordinatesHelper = new CoordinateHelper()
  
  "game" in {
    val start = Position(Longitude(50),Latitude(0))
    val vector = Vector(Direction(90), Distance(100))
    val newPosition = CoordinateHelper.move(start, vector)

    newPosition shouldBe Position(Longitude(49.96638889), Latitude(-2.79694444))
  }
}
