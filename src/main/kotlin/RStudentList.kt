import data.Student
import org.w3c.dom.events.Event
import react.*
import react.dom.li


interface RStudentListProps : RProps {
    var students: Array<Student>
    var value: Array<Boolean>              // TODO students
    var onClick:  (Int) -> (Event) -> Unit
}
abstract  class RStudentList : RComponent<RStudentListProps, RState>() {}

/*override fun componentWillMount() {
    state.apply {
        present = Array(props.students.size){false}         not need
    }
}*/

val RFstudentlist =
    functionalComponent<RStudentListProps> { props ->
        props.students.mapIndexed { index, student ->
            li {
                RPREDMET(student, props.value[index], props.onClick(index))         // TODO functional component
            }
        }
    }
/*


    override fun RBuilder.render() {
        ol { props.students.map {
            li{
                rstudent(it)                //NOT NEEDED
            }
        } }
    }

}
*/

fun RBuilder.rstudentlist(students: Array<Student>, value: Array<Boolean>, onClick: (Int) -> (Event) -> Unit) =
    child(RFstudentlist/*functionalComponent<RSstudentListProps>*/) {
        attrs.students = students
        attrs.value = value                                         //changed
        attrs.onClick = onClick
    }
