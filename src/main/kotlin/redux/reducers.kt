package redux

import data.Lesson
import data.State
import data.Student
import data.*
import react.dom.*
import react.router.dom.*
import hoc.withDisplayName
import kotlinx.html.InputType
import react.*
import redux.*
import kotlin.browser.document
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
fun changeReducer(state: State, action: RAction) =
    when (action) {
        is ChangePresent -> State(
            state.presents.mapIndexed { indexLesson, lesson ->
                if (indexLesson == action.lesson)
                    lesson.mapIndexed { indexStudent, student ->
                        if (indexStudent == action.student)
                            !student
                        else student
                    }.toTypedArray()
                else
                    lesson }.toTypedArray(),
            state.lessons,
            state.students)
        is addforstudent ->State(
            state.presents.mapIndexed{index,_ ->
                state.presents[index].plus(arrayOf(false))
            }.toTypedArray(),
            state.lessons,
            state.students.plus(Student(action.studname,action.studsurname)))
        is deleteforstudent -> State(
            state.presents.mapIndexed{ index, _ ->
                state.presents[index].toMutableList().apply {
                    removeAt(action.number)
                }.toTypedArray()
            }.toTypedArray(),
            state.lessons,
            state.students.toMutableList().apply {
                removeAt(action.number)
            }.toTypedArray())
        is addforlesson -> State(
            state.presents.plus(arrayOf(Array(state.students.size) { false })),
            state.lessons.plus(Lesson(action.less)),
            state.students)
        is deleteforlesson -> State(
            state.presents.toMutableList().apply {
                removeAt(action.number)
            }.toTypedArray(),
            state.lessons.toMutableList().apply {
                removeAt(action.number)
            }.toTypedArray(),
            state.students)
        else -> state }