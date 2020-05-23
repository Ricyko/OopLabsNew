package container

import component.*
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import redux.*
import react.redux.rConnect

interface AnyFullDispatchProps : RProps {
    var onClick: (Int) -> (Event) -> Unit
}

interface AnyFullStateProps<O, S> : RProps {
    var subobjs: Map<Int, S>
    var presents: Map<Int, Boolean>?
}

interface AnyFullOwnProps<O> : RProps {
    var obj: Pair<Int, O>
}

val lessonFullContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            AnyFullOwnProps<Lesson>,
            AnyFullStateProps<Lesson, Student>,
            AnyFullDispatchProps,
            AnyFullProps<Lesson, Student>>(
        { state, ownProps ->
            subobjs = studentPrisOts(state.students, state.presents[ownProps.obj.first], state.visibilityFilter)
            presents = state.presents[ownProps.obj.first]
        },
        { dispatch, ownProps ->
            onClick =
                { index ->
                    {
                        dispatch(ChangePresent(ownProps.obj.first, index))
                    }
                }
        }
    )(
        withDisplayName(
            "LessonFull",
            fAnyFull<Lesson, Student>(RBuilder::student)
        )
            .unsafeCast<RClass<AnyFullProps<Lesson, Student>>>()
    )

val studentFullContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            AnyFullOwnProps<Student>,
            AnyFullStateProps<Student, Lesson>,
            AnyFullDispatchProps,
            AnyFullProps<Student, Lesson>>(
        { state, ownProps ->
            subobjs = lessonPrisOts(state.lessons, state.presentsStudent(ownProps.obj.first), state.visibilityFilter)
            presents = state.presentsStudent(ownProps.obj.first)
        },
        { dispatch, ownProps ->
            onClick = { index ->
                {
                    dispatch(ChangePresent(index, ownProps.obj.first))
                }
            }
        }
    )(
        withDisplayName(
            "StudentFull",
            fAnyFull<Student, Lesson>(RBuilder::lesson)
        )
            .unsafeCast<RClass<AnyFullProps<Student, Lesson>>>()
    )

private fun studentPrisOts(
        students: Map<Int, Student>,
        presents: Map<Int, Boolean>?,
        filter: vision): Map<Int, Student>  {
    if (filter == vision.vse) return students
    if(filter == vision.otsutstvie){
        val absent :MutableMap<Int,Student> = students.toMutableMap()
        absent.clear()
        if (!presents?.isEmpty()!!) {
            presents.filter { !it.value }.map{
                absent[it.key] = students.getValue(it.key)
            }
        }
        return absent
    }
    if(filter == vision.prisutstvie){
        val present :MutableMap<Int,Student> = students.toMutableMap()
        present.clear()
        if (!presents?.isEmpty()!!) {
            presents.filter { it.value }.map{
                present[it.key] = students.getValue(it.key)
            }
        }
        return present
    }
    return students
}

private fun lessonPrisOts(
        lessons: Map<Int, Lesson>,
        presents: Map<Int, Boolean>?,
        filter: vision): Map<Int, Lesson>  {
    if (filter == vision.vse) return lessons
    if(filter == vision.otsutstvie){
        val absent :MutableMap<Int,Lesson> = lessons.toMutableMap()
        absent.clear()
        if (!presents?.isEmpty()!!) {
            presents.filter { !it.value }.map{
                absent[it.key] = lessons.getValue(it.key)
            }
        }
        return absent
    }
    if(filter == vision.prisutstvie){
        val present :MutableMap<Int,Lesson> = lessons.toMutableMap()
        present.clear()
        if (!presents?.isEmpty()!!) {
            presents.filter { it.value }.map{
                present[it.key] = lessons.getValue(it.key)
            }
        }
        return present
    }
    return lessons
}