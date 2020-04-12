package component
import data.*
import org.w3c.dom.events.Event
import react.*
import react.dom.h1
import react.dom.h2

interface AppProps : RProps {
    var students: Array<Student> }
interface AppState : RState {
    var presents: Array<Array<Boolean>>             //CHANGED
    var lessons: Array<Lesson>
}

class New : RComponent<AppProps, AppState>() {
    override fun componentWillMount() {
        state.lessons = lessonsList                     //changed
        state.presents = Array(state.lessons.size) {
            Array(props.students.size) { false }
        }
    }
    override fun RBuilder.render() {
        h1 { +"Lesson" }
        h2{+"Add new lesson"}
        LessonAdd(plus())
        lessonListFull(
            state.lessons,
            props.students,
            state.presents,
            onClickLessonFull
        )
        studentListFull(
            state.lessons,
            props.students,
            transform(state.presents),
            onClickStudentFull
        )
    }

    fun transform(source: Array<Array<Boolean>>) =
        Array(source[0].size){row->
            Array(source.size){col ->
                source[col][row]
            }
        }

    fun onClick(indexLesson: Int, indexStudent: Int) =
        { _: Event ->
            setState {
                presents[indexLesson][indexStudent] =
                    !presents[indexLesson][indexStudent]
            }
        }

    val onClickLessonFull =
        { indexLesson: Int ->
            { indexStudent: Int ->
                onClick(indexLesson, indexStudent)
            }
        }

    val onClickStudentFull =
        { indexStudent: Int ->
            { indexLesson: Int ->
                onClick(indexLesson, indexStudent)
            }
        }

    private fun plus():(String) -> Unit = { str->
        setState {
            lessons += Lesson(str)
            presents += arrayOf(Array(props.students.size){false})
        }
    }
}
fun RBuilder.app(
    students: Array<Student>
) = child(New::class) {
    attrs.students = students
}
