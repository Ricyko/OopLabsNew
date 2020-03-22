# OopLabsNew
Plyashkevich Anton 28z

**Задания**

<br>-Переделать приложение, реализовав компонент «Занятие»;
<br>-Поднимите состояние компонента RStudentList в созданный компонент;
<br>-StudentList преобразуйте в функциональный компонент;

**Добавлен список предметов** 
 ```
 data class Lesson(
    val name: String
 )

 val Predmet
       = arrayListOf(
   Lesson("Philosophy"),
    Lesson("Information Processing Theories"),
   Lesson("OOP")
 )
```
**Задание: Поднимите состояние компонента RStudentList в созданный компонент.**
```
interface RpredmetProps : RProps {
   var predmet: Array <Lesson>
  var listStudent :Array <Student>
 /* var value: Array <Boolean> */
}

 interface RpredmetState : RState {
   var value: Array <Boolean>
 }
```
**Переделан main.kt. Добавлено:** 
```
h1 {
          +"Timetable for objects"
      }
        ol{
          +"StudentsList"
          li{
             +"Anton Cooper, Anton Hofstadter, Anton Wolowitz"
         }
     }
    RPREDMET(Predmet)
```
**Задание: RstudentList преобразован в functionalComponent**
```
val RFstudentlist =
    functionalComponent<RStudentListProps> { props ->
      props.students.mapIndexed { index, student ->
          li {
               RPREDMET(student, props.value[index], props.onClick(index))         // TODO functional component
           }
       }
  }
```
**Задание: Переделать приложение, реализовав компонент «Занятие»**
```
class RPREDMET : RComponent<RpredmetProps, RpredmetState>() {
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
    }
    /*class SLesson : RComponent<LessonProps, RState>() {
        override fun componentWillMount() {
            state.apply {
                value = Array(props.listStudent.size) { false }              // TODO Компонент PREDMET
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

    fun RBuilder.onClick(index: Int): (Event) -> Unit = {
        setState {
            value[index] = !value[index]
        }
    }
}
/*fun RBuilder.predmet(predmet:  ArrayList<Lesson> ) =
    child(SLesson::class)
    {
        attrs.predmet = predmet.toTypedArray()
        attrs.listStudent = studentList.toTypedArray()
    }*/



fun RBuilder.RPREDMET(predmet:  ArrayList<Lesson> ) =
    child(RPREDMET::class)
    {
        attrs.predmet = predmet.toTypedArray()
        attrs.listStudent = studentList.toTypedArray()
    }
```
**Программа после запуска**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/690966580858847373/unknown.png>

 **Программа после нажатия. TRUE = присутсвует студент. FALCE = отсутсвует студент.**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/690967156539785306/unknown.png>
