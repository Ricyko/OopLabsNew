import data.Student
import org.w3c.dom.events.Event
import react.*
import react.dom.li
import react.dom.ol

interface RStudentListProps : RProps {
    var students: Array<Student>
}

/*interface RStudentListState : RState {
    var present: Array<Boolean>                not need
}*/

class RStudentList : RComponent<RStudentListProps, RState>() {

    /*override fun componentWillMount() {
        state.apply {
            present = Array(props.students.size){false}         not need
        }
    }*/

    override fun RBuilder.render() {
        ol { props.students.map {
            li{
                rstudent(it)
            }
        } }
    }

}

/* fun onClick(index: Int): (Event) -> Unit = {
     setState {
         present[index] = !present[index]               not need
     }
 }
}*/

fun RBuilder.studentList(students: Array<Student>) =
    child(functionalComponent<RStudentListProps> {
        ol { students.map {
            li{
                rstudent(it)                    //changed on functionalComponnet
            }
        } }
    })
    {
        attrs.students=students
    }