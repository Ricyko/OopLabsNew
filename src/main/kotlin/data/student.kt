package data

data class Student (
    val firstname: String,
    val surname: String
)
{
    override fun toString(): String =
        "$firstname $surname"
}
fun studentList () =
    arrayOf(
        Student("Anton", "Cooper"),
        Student("Anton", "Hofstadter"),
        Student("Anton", "Wolowitz")
    )