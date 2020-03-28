# OopLabsNew
Plyashkevich Anton 28z

**Задания**

<br>-Переделать приложение, реализовав компонент «Занятие»;
<br>-Поднимите состояние компонента RStudentList в созданный компонент;
<br>-StudentList преобразуйте в функциональный компонент;


**Задание: Поднимите состояние компонента RStudentList в созданный компонент. Поднято состояние RpredmetState компонента RstudentList**
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
**Переделан main.kt. Добавлено: занятие "Philosophy" в нее передается функция RPREDMET** 
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
**Задание: RstudentList преобразован в functionalComponent, исходя из данных полученных на видеоуроке в Stepik**
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
**Задание: Переделать приложение, реализовав компонент «Занятие». Компонент занятие реализован в файле Rlesson представленной ниже.**
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
fun RBuilder.PREDMET(predm: String, students: Array<Student>) =
    child(PREDMET::class) {
        attrs.predm = predm                                             //TODO
        attrs.students = students
    }
```
**lesson убран по вашему заданию**
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
**Меняем цвет текста и бекграунда с помощью css файла** 
 ```
body {
    background-color: black;
    color: white;
}
.value {
    font-weight: bold
    color: white;
}

.absent {
    font-style: italic;
    color: darkgreen;
}
h1
{
color: green;
font-weight:bold;}
ol{
color:darkgreen;
font-weight:bold;}
```

**Программа после запуска**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/693049005466189944/unknown.png>

 **Программа после нажатия. TRUE = присутсвует студент. FALCE = отсутсвует студент.**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/693049047824597162/unknown.png>
