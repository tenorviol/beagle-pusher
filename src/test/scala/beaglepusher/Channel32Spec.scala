package beaglepusher

class Channel32Spec extends TestBase {

  "toByte" should {
    "return bits 9 through 16" in {
      Channel32(0x1234).toByte should equal(0x12.toByte)
    }
  }
}
