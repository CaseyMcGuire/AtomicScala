object Test {
  def main(args : Array[String]) {

    assert(List.init(List(1,2,3,4,5)) == List(1,2,3,4), "Init failed")
  }
}
