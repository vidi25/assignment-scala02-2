val list = Map("java"->2,"scala"->3)
val rnd = new scala.util.Random
val subjects = list.keySet.toList
val sub = subjects(rnd.nextInt(subjects.length))