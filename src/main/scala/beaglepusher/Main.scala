package beaglepusher

import com.heroicrobot.dropbit.registry.DeviceRegistry

import beaglepusher.scene.CycleHSV

object Main extends App {

  val registry = new DeviceRegistry()

  registry.startPushing()

  val scene = new CycleHSV(registry)
  scene.run()

}
