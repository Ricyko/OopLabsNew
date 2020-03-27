import data.Student

import org.w3c.dom.events.Event

import react.dom.span

import react.*

import react.functionalComponent

import kotlinx.html.js.onClickFunction

interface RStudentProps : RProps {
    var student: Student
    var value: Boolean
    var onClick: (Event) -> Unit
}

val RFStudent =
    functionalComponent<RStudentProps> {
        span(
            if (it.value) "present" else "absent"
        ) {
            +"${it.student.firstname} ${it.student.surname}"
            attrs.onClickFunction = it.onClick
        }
    }
/*class RStudent : RComponent<RStudentProps, RState>() {
    override fun RBuilder.render() {
        +"${props.student.firstname} ${props.student.surname}"
            *//*attrs.onClickFunction =it.onClick*//*
    }
}*/

fun RBuilder.rstudent(student: Student, value: Boolean, onClick: (Event)->Unit) =
    child(RFStudent) {
        attrs.student = student
        attrs.value = value
        attrs.onClick = onClick
    }

//    child(RStudent::class){
//        attrs.student = student
//    }                                      not need
