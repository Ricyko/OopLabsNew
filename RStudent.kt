
import data.Student
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.span
import react.functionalComponent

interface StudentProps : RProps {
    var student: Student
    var value: Boolean
    var onClick: (Event) -> Unit
}

/*class RStudent : RComponent<RStudentProps, RState>() {
    override fun RBuilder.render() {
        +"${props.student.firstname} ${props.student.surname}"
            *//*attrs.onClickFunction =it.onClick*//*
    }
}*/
val RFStudent =
    functionalComponent<StudentProps> {
        span (
            if(it.value) "present" else "absent"
        ){
            +"${it.student.firstname} ${it.student.surname}"
            attrs.onClickFunction = it.onClick
        }
    }

fun RBuilder.RPREDMET(student: Student, value: Boolean, onClick: (Event)->Unit) =
    child(RFStudent) {
        attrs.student = student
        attrs.value = value
        attrs.onClick = onClick
    }
/*fun RBuilder.rstudent(student: Student,present: Boolean,onClick: (Event) -> Unit) =
    child(functionalComponent<RStudentProps> {
        +"${it.student.firstname} ${it.student.surname}"
    }) {
        attrs.student = student
        attrs.present = present
        attrs.onClick = onClick
    }*/
//    child(RStudent::class){
//        attrs.student = student
//    }                                 not need