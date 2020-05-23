package data
data class Lesson(
    val name: String
)
{
    override fun toString(): String = name
}
fun lessonsList () = arrayOf(
    Lesson("Philosophy"),
    Lesson("OOP"),
    Lesson("Math")
)