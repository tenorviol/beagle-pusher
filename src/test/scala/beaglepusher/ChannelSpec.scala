package beaglepusher

class ChannelSpec extends TestBase {

  "toByte" should {
    "return bits 9 through 16" in {
      Channel(0x1234).toByte should equal(0x12.toByte)
    }
  }
}
