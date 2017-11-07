1 == 2
1 != 2

//You can use== to compare lists:
List(1, 2, 3) == List(1, 2, 3)
List(1, 2, 3) == List(4, 5, 6)


//you can compare two objects that have different types:
1 == 1.0
List(1, 2, 3) == "hello"

//You can even compare against null, or against things that might be null. No exception will be thrown:
List(1, 2, 3) == null
null == List(1, 2, 3)
