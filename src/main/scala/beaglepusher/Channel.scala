package beaglepusher

object Channel {

  val MinValue = Channel(0)
  val MaxValue = Channel(0xffff)

  def apply(d: Double): Channel = Channel((d * MaxValue.value).toInt & MaxValue.value)

}

case class Channel(value: Int) {
  import Channel._

  def toByte: Byte = ((value >> 8) & 0xff).toByte

  def toDouble: Double = (value & MaxValue.value).toDouble / MaxValue.value

}
