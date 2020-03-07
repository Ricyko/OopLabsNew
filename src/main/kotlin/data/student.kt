package data

data class Student (
    val firstname: String,
    val surname: String,
    var CVET: Boolean
)

val studentList =
    arrayListOf(
        Student("Anton", "TEST1", true),
        Student("Anton, ","Plyashkevich", true)
    )