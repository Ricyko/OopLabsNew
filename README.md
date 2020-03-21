# OopLabsNew
Plyashkevich Anton 28z

**Программа после запуска**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/690966580858847373/unknown.png>

 **Программа после нажатия. TRUE = присутсвует студент. FALCE = отсутсвует студент.**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/690967156539785306/unknown.png>

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
**RstudentList преобразован в functionalComponent**
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
