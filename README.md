# OopLabsNew
Plyashkevich Anton 28-z
LAB8

<br>**Задание**
<br>Доработайте приложение из видеоуроков. Разработайте компоненты, отвечающий за редактирование названия занятия и имени и фамилии студента. Разработайте компонент, отвечающий за редактирование списка элементов (с возможностью добавить или удалить элемент). В качестве аргументов этому компоненту передаются компоненты для отображения и для редактирования элемента списка. Добавьте в приложение страницы для редактирования списка студентов и списка занятий. 
<br>**Добавлены компоненты для изменения занятия и студента(файлы ComponentForLesson,ComponentForStudent.**
<br>**СomponentForLesson.**
```
package component
import kotlinx.html.InputType
import kotlinx.html.id
import react.*
import react.dom.*
interface Props1 :RProps{
}
fun RBuilder.LessonAdd( ) =
    child(functionalComponent<Props1> {
        input(InputType.text) {
            attrs {
                placeholder = "Write lesson name"
                id = "Lessons" } }
        input(InputType.text){
            attrs{
                placeholder = "Delete lesson name)"
                id = "DeleteLessons"
            } } }){
    }
```   
<br>**ComponentForStudent.**
```
package component
import kotlinx.html.InputType
import kotlinx.html.id
import react.RBuilder
import react.RProps
import react.child
import react.dom.input
import react.functionalComponent
interface Props2 : RProps {
}
fun RBuilder.StudentAdd () =
    child(functionalComponent<Props2> {
        input(InputType.text) {
            attrs {
                placeholder = "Write student name"
                id = "Students" } }
        input(InputType.text) {
            attrs {
                placeholder = "Delete student name"
                id = "DeleteStudents" } }
    }){
    }
 ```
<br>**В app были созданы функции,такие как "deleteforstudent","addforstudent","deleteforlesson","addforlesson" для изменения состояния с учетом редактирования списков студента или урока.**
```
fun addforelesson():(Event) -> Unit = {
        val objectnew = document.getElementById("Lessons") as HTMLInputElement
        setState {
            less += Lesson(objectnew.value)
            presents += arrayOf(Array(state.students.size){false})
        } }
    fun deleteforlesson() :(Event) -> Unit = {
        val objectnew = document.getElementById("DeleteLessons") as HTMLInputElement
        val redactLesson = state.less.toMutableList().apply {
            removeAt(objectnew.value.toInt()-1) }
            .toTypedArray()
        val redactPresent = state.presents.toMutableList().apply {
            removeAt(objectnew.value.toInt()-1) }
            .toTypedArray()
        setState{
            less = redactLesson
            presents=redactPresent
        } }
    fun addforstudent():(Event) -> Unit = {
        val objectnew = document.getElementById("Students") as HTMLInputElement
        val newvalue = objectnew.value.split(" ")
        setState {
            students += Student(newvalue[0],newvalue[1])
            presents += arrayOf(Array(state.students.size){false})
        } }
    fun deleteforstudent() :(Event) -> Unit = {
        val objectnew = document.getElementById("DeleteStudents") as HTMLInputElement
        val redactStudent = state.students.toMutableList().apply {
            removeAt(objectnew.value.toInt()-1) }
            .toTypedArray()
        val redactPresent = state.presents.toMutableList().apply {
            removeAt(objectnew.value.toInt()-1) }
            .toTypedArray()
        setState{
            students = redactStudent
            presents= redactPresent
        } }
```
<br>**Программа после запуска.**
<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/706215821994885142/unknown.png>
<br>**Нажатие на изменение урока/студента.**
<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/706216664726896710/unknown.png>
<br>**Добавляем нового студента.**
<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/706217042088558672/unknown.png>
<br>**Удаляем первых 3 студентов.**
<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/706217134388150312/unknown.png>
<br>**Добавляем новую пару.**
<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/706217353536471110/unknown.png>
<br>**Удаляем 2 первых пары.**
<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/706219236821041162/unknown.png>
<br>**Переделайте программу так, чтобы удалить можно было без ввода имени студента, а просто нажав на кнопку.**
<br>**Изменен файл ComponentForLesson, аналогично ему изменен ComponentForStudent.**
```
package component
import kotlinx.html.InputType
import kotlinx.html.id
import react.*
import react.dom.*
interface Props1 :RProps{
}
fun RBuilder.LessonAdd( ) =
    child(functionalComponent<Props1> {
        input(InputType.text) {
            attrs {
                placeholder = "Write lesson name"
                id = "Lessons"
            }
            }
    }){
    }
```
<br>**Исправлению подверглись функции для удаления урока и удаления студента в app,немного изменен AnyList и ObshiyComponent.**
<br>**Программа после открытия.**
<img src=https://cdn.discordapp.com/attachments/407510344509030400/707165682650972250/unknown.png>
<br>**Программа после удаления студента.**
<img src=https://cdn.discordapp.com/attachments/407510344509030400/707165849282281532/unknown.png>

<br> Вывод: Мы доработали приложение из видеоуроков. Разрабтали компоненты, отвечающие за редактирование названия занятия и имени и фамилии студента. Разработали компонент, отвечающий за редактирование списка элементов. Добавили в приложение страницы для редактирования списка студуентов и списка занятий.
    
