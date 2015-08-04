package beaglepusher

import com.heroicrobot.dropbit.registry.DeviceRegistry

import scala.collection.JavaConversions._

object Main extends App {

  val registry = new DeviceRegistry()

  val scene = new Scene() {
    def frame(): Unit = {
      var t = System.currentTimeMillis() * 0.001
      registry.getStrips.foreach { strip =>
        for (x <- 0 until strip.getLength) {
          var color = Math.round(0xff * (Math.sin(t + x * 0.25) / 2 + 0.5)).toInt
          strip.setPixel(color, x)
        }
        Thread.sleep(1)
      }
    }
  }

  registry.setFrameCallback(scene, "frame")

  registry.startPushing()

}
