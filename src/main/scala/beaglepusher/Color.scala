package beaglepusher

import com.heroicrobot.dropbit.devices.pixelpusher.Pixel

object Color {

  case class RGB(red: Channel, green: Channel, blue: Channel) {

    def toPixel: Pixel = new Pixel(red.toByte, green.toByte, blue.toByte)

  }

  case class HSV(hue: Channel, saturation: Channel, value: Channel) {

    def toRGB: RGB = {
      val h = hue.toDouble * 360
      val c: Double = saturation.toDouble * value.toDouble
      val x: Double = c * (1 - Math.abs((h / 60) % 2 - 1))
      val m: Double = value.toDouble - c
      val (r0: Double, g0: Double, b0: Double) = if (h < 60) (c, x, 0.0)
      else if (h < 120) (x, c, 0.0)
      else if (h < 180) (0.0, c, x)
      else if (h < 240) (0.0, x, c)
      else if (h < 300) (x, 0.0, c)
      else (c, 0.0, x)
      RGB(Channel(r0 + m), Channel(g0 + m), Channel(b0 + m))
    }

  }

}
