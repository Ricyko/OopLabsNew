import data.Student
import org.w3c.dom.events.Event
import react.*
import react.dom.li
import react.dom.ol

interface RSProps : RProps {
    var students: Array<Student>
    var value: Array<Boolean>                         //TODO STUDENT
    var onClick: (Int) -> (Event) -> Unit
}
/*override fun componentWillMount() {
    state.apply {
        present = Array(props.students.size){false}         not need
    }
    abstract  class RStudentList : RComponent<RStudentListProps, RState>() {}
}*/
val RFStudentList =
    functionalComponent<RSProps> { props ->
        ol {                                                        // FUNC component sdelan
            props.students.mapIndexed { index, student ->
                li {
                    rstudent(student, props.value[index], props.onClick(index))
                }
            }
        }
    }


fun RBuilder.studentList(students: Array<Student>, value: Array<Boolean>, onClick: (Int) -> (Event) -> Unit) =
    child(RFStudentList) {
        attrs.students = students
        attrs.value = value                                             // Changed
        attrs.onClick = onClick
    }
