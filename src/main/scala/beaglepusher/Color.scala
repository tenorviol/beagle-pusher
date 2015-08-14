package beaglepusher

import com.heroicrobot.dropbit.devices.pixelpusher.Pixel

object Color {

  case class RGB(red: Double, green: Double, blue: Double) {

    def toPixel: Pixel = new Pixel((red * 0xff).toByte, (green * 0xff).toByte, (blue * 0xff).toByte)

  }

  case class HSV(hue: Double, saturation: Double, value: Double) {

    def toRGB: RGB = {
      val h = hue % 360
      val c: Double = saturation * value
      val x: Double = c * (1 - Math.abs((h / 60) % 2 - 1))
      val m: Double = value - c
      val (r0: Double, g0: Double, b0: Double) = if (h < 60) (c, x, 0.0)
      else if (h < 120) (x, c, 0.0)
      else if (h < 180) (0.0, c, x)
      else if (h < 240) (0.0, x, c)
      else if (h < 300) (x, 0.0, c)
      else (c, 0.0, x)
      RGB(r0 + m, g0 + m, b0 + m)
    }

  }

}
