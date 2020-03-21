import data.Student
import data.Lesson
import data.studentList
import org.w3c.dom.events.Event
import react.*
import react.dom.ol

interface RpredmetProps : RProps {
    var predmet: Array<Lesson>
    var listStudent :Array<Student>
/* var value: Array<Boolean> */
}
interface RpredmetState : RState {
    var value: Array<Boolean>
}

class RPREDMET : RComponent<RpredmetProps, RpredmetState>() {
    override fun componentWillMount() {
        state.apply {
            value = Array(props.listStudent.size) { false }
        }
    }
    fun RBuilder.onIndex(): (Int) -> (Event) -> Unit = {
        onClick(it)
    }
    override fun RBuilder.render() {
        props.predmet.map {
            + it.name
            ol {
                rstudentlist(props.listStudent, state.value, onIndex())
            }
        }
    }
    /*class SLesson : RComponent<LessonProps, RState>() {
        override fun componentWillMount() {
            state.apply {
                value = Array(props.listStudent.size) { false }
            }
        }
        fun RBuilder.onIndex(): (Int) -> (Event) -> Unit = {
            onClick(it)
        }
        override fun RBuilder.render() {
            props.predmet.map {
                + it.name
                ol {
                    rstudentlist(props.listStudent, state.value, onIndex())
                }
            }
        }*/

    fun RBuilder.onClick(index: Int): (Event) -> Unit = {
        setState {
            value[index] = !value[index]
        }
    }
}
/*fun RBuilder.predmet(predmet:  ArrayList<Lesson> ) =
    child(SLesson::class)
    {
        attrs.predmet = predmet.toTypedArray()
        attrs.listStudent = studentList.toTypedArray()
    }*/



fun RBuilder.RPREDMET(predmet:  ArrayList<Lesson> ) =
    child(RPREDMET::class)
    {
        attrs.predmet = predmet.toTypedArray()
        attrs.listStudent = studentList.toTypedArray()
    }

