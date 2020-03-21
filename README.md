# OopLabsNew
Plyashkevich Anton 28z

Программа после запуска

<img src=https://cdn.discordapp.com/attachments/407510344509030400/690966580858847373/unknown.png>

Программа после нажатия. TRUE = присутсвует студент. FALCE = отсутсвует студент.

<img src=https://cdn.discordapp.com/attachments/407510344509030400/690967156539785306/unknown.png>

Добавлен список предметов
 
<br> data class Lesson(
 <br>    val name: String
<br> )
<br> 
<br> val Predmet
  <br>       = arrayListOf(
 <br>    Lesson("Philosophy"),
 <br>    Lesson("Information Processing Theories"),
 <br>    Lesson("OOP")
<br> )

Задание: Поднимите состояние компонента RStudentList в созданный компонент.
<br>interface RpredmetProps : RProps {
 <br>   var predmet: Array<Lesson>
 <br>   var listStudent :Array<Student>
<br> /* var value: Array<Boolean> */
<br> }

<br> interface RpredmetState : RState {
 <br>    var value: Array<Boolean>
<br> }

Переделан main.kt. Добавлено
 <br> h1 {
     <br>       +"Timetable for objects"
     <br>   }
       <br> ol{
      <br>      +"StudentsList"
      <br>      li{
          <br>      +"Anton Cooper, Anton Hofstadter, Anton Wolowitz"
    <br>        }
    <br>    }
     <br>   RPREDMET(Predmet)

RstudentList преобразован в functionalComponent

val RFstudentlist =
    <br>functionalComponent<RStudentListProps> { props ->
      <br>  props.students.mapIndexed { index, student ->
         <br>   li {
            <br>    RPREDMET(student, props.value[index], props.onClick(index))         // TODO functional component
        <br>    }
       <br> }
 <br>   }
