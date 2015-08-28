package beaglepusher

import com.heroicrobot.dropbit.registry.DeviceRegistry

import beaglepusher.scene._

object Main extends App {

  val registry = new DeviceRegistry()

  registry.startPushing()

  val scene = new Clear(registry)
  scene.run()

}
