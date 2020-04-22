package data

data class Student (
    val firstname: String,
    val surname: String
)

val studentList =
    arrayOf(
        Student("Anton", "Cooper"),
        Student("Anton", "Hofstadter"),
        Student("Anton", "Wolowitz")
    )