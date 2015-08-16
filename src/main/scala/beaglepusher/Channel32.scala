package beaglepusher

object Channel32 {

  val MinValue = Channel32(0)
  val MaxValue = Channel32(0xffff)

}

case class Channel32(value: Int) {

  def toByte: Byte = ((value >> 8) & 0xff).toByte

}
