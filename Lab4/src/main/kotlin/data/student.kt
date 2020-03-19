package data

data class Student (
    val firstname: String,
    val surname: String
)

val studentList =
    arrayListOf(
        Student("Anton", "Plyashkevich"),
        Student("Anton", "Test2")
    )