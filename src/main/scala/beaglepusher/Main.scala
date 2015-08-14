package beaglepusher

import com.heroicrobot.dropbit.registry.DeviceRegistry

import scala.collection.JavaConversions._

object Main extends App {

  val registry = new DeviceRegistry()

  registry.startPushing()

  while (true) {
    registry.getStrips.foreach { strip =>
      var t = System.currentTimeMillis() * 0.001
      for (x <- 0 until strip.getLength) {
        val color = getColor(t, x)
        strip.setPixel(color, x)
      }
    }
    Thread.sleep(20)
  }

  def getColor(t: Double, x: Int) = {
    val hsv = Color.HSV(360 * (Math.sin(t + x * 0.05) / 2 + 0.5), 1.0, 0.25)
    hsv.toRGB.toPixel
  }

}
