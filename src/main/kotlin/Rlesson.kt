import data.Student
import data.studentList
import org.w3c.dom.events.Event
import react.*
import react.dom.div
import react.dom.ol

interface RClassProps : RProps {
    var predm: String
    var students: Array<Student>
    /*  var value: Array<Boolean>*/                 //changed
}

interface RpredmetState : RState {
    var value: Array<Boolean>

}

class PREDMET : RComponent<RClassProps, RpredmetState>() {

    override fun componentWillMount() {
        state.apply {
            value = Array(props.students.size) { false }
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

    fun onClick() = { index: Int ->
        { _: Event ->
            setState {
                value[index] = !value[index]
            }
        }
    }

    override fun RBuilder.render() {
        div {
            +props.predm
            studentList(props.students, state.value, onClick())
        }


    }

}
/*fun RBuilder.predmet(predmet:  ArrayList<Lesson> ) =
    child(SLesson::class)
    {
        attrs.predmet = predmet.toTypedArray()
        attrs.listStudent = studentList.toTypedArray()
    }*/


fun RBuilder.PREDMET(predm: String, students: Array<Student>) =
    child(PREDMET::class) {
        attrs.predm = predm                                             //TODO
        attrs.students = students
    }
