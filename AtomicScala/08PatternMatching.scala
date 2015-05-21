//a match expression compares a value against a selection of possibilities

//example
def matchColor(color:String):String = {
  color match{
    case "red" => "RED"
    case "blue" => "BLUE"
    case "green" => "GREEN"
    case _ => "UNKNOWN COLOR: " + color
  }
}

//the _ is a wildcard which means it matches against anything that isn't matched above.
