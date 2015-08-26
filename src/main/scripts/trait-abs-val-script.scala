class Base

trait AbstractTrait {
  val i = "abstract t1"
}


class t1 extends Base with AbstractTrait{
  override val i = "from t1"
  println(i)
}



class t2 extends Base with AbstractTrait{
  override val i = "from t2"
  println(i)
}


val t1instance = new t1


val t2instance = new t2