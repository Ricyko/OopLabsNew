# OopLabsNew
Plyashkevich Anton 28z

**Задания**

<br>-Переделать приложение, реализовав компонент «Занятие»;
<br>-Поднимите состояние компонента RStudentList в созданный компонент;
<br>-StudentList преобразуйте в функциональный компонент;

**Добавлено занятие "Philosophy"** 
 ```
fun main() {
    render(document.getElementById("root")!!) {
        h1 {
            +"Students"

        }
        PREDMET("PHILOSOPHY", studentList.toTypedArray())
    }
}
```
**Задание: Поднимите состояние компонента RStudentList в созданный компонент.**
```
interface RClassProps : RProps {
    var predm: String
    var students: Array<Student>
    /*  var value: Array<Boolean>*/                 //changed
}

interface RpredmetState : RState {
    var value: Array<Boolean>

}

```
**Переделан main.kt. Добавлено:** 
```
fun main() {
    render(document.getElementById("root")!!) {
        h1 {
            +"Timetable for objects"
        }
        ol{
            +"StudentsList"
            li{
                +"Anton Cooper, Anton Hofstadter, Anton Wolowitz"
            }
        }
        PREDMET("PHILOSOPHY", studentList.toTypedArray())
    }
}
```
**Задание: RstudentList преобразован в functionalComponent**
```
val RFStudentList =
    functionalComponent<RSProps> { props ->
        ol {                                                        // TODO FUNC COMPONNENT
            props.students.mapIndexed { index, student ->
                li {
                    rstudent(student, props.value[index], props.onClick(index))
                }
            }
        }
    }

```
**Задание: Переделать приложение, реализовав компонент «Занятие»**
```
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
```
**Rlesson убран**
```
package data



data class Lesson(
    val name: String
)

val Predmet
        = arrayListOf(
    Lesson("Philosophy")
)
```

**Программа после запуска**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/693049005466189944/unknown.png>

 **Программа после нажатия. TRUE = присутсвует студент. FALCE = отсутсвует студент.**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/693049047824597162/unknown.png>
