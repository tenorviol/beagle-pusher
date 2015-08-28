package beaglepusher.scene

import beaglepusher.Color
import com.heroicrobot.dropbit.registry.DeviceRegistry

import scala.collection.JavaConversions._

class Clear(registry: DeviceRegistry) {

  def run(): Unit = {
    while (true) {
      registry.getStrips.foreach { strip =>
        for (x <- 0 until strip.getLength) {
          strip.setPixel(0, x)
        }
      }
      Thread.sleep(20)
    }
  }

}
