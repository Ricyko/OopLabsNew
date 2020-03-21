import data.Student
import data.Lesson
import data.studentList
import org.w3c.dom.events.Event
import react.*
import react.dom.ol

interface RSubjectProps : RProps {
    var subject: Array<Lesson>
    var listStudent :Array<Student>
/* var present: Array<Boolean> */
}



interface RSubjectState : RState {
    var value: Array<Boolean>
}

class RPREDMET : RComponent<RSubjectProps, RSubjectState>() {
    override fun componentWillMount() {
        state.apply {
            value = Array(props.listStudent.size) { false }
        }
    }
    fun RBuilder.onIndex(): (Int) -> (Event) -> Unit = {
        onClick(it)
    }
    override fun RBuilder.render() {
        props.subject.map {
            + it.name
            ol {
                rstudentlist(props.listStudent, state.value, onIndex())
            }
        }
    }
    /*class SLesson : RComponent<LessonProps, RState>() {
        override fun componentWillMount() {
            state.apply {
                present = Array(props.listStudent.size) { false }
            }
        }
        fun RBuilder.onIndex(): (Int) -> (Event) -> Unit = {
            onClick(it)
        }
        override fun RBuilder.render() {
            props.subject.map {
                + it.name
                ol {
                    rstudentlist(props.listStudent, state.present, onIndex())
                }
            }
        }*/

    fun RBuilder.onClick(index: Int): (Event) -> Unit = {
        setState {
            value[index] = !value[index]
        }
    }
}
/*fun RBuilder.predmet(subject:  ArrayList<Lesson> ) =
    child(SLesson::class)
    {
        attrs.subject = subject.toTypedArray()
        attrs.listStudent = studentList.toTypedArray()
    }*/



fun RBuilder.RPREDMET(subject:  ArrayList<Lesson> ) =
    child(RPREDMET::class)
    {
        attrs.subject = subject.toTypedArray()
        attrs.listStudent = studentList.toTypedArray()
    }

