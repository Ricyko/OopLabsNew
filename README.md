# OopLabsNew
Plyashkevich Anton 28-z
LAB8

**Задание**
<br>Доработайте приложение из видеоуроков. Разработайте компоненты, отвечающий за редактирование названия занятия и имени и фамилии студента. Разработайте компонент, отвечающий за редактирование списка элементов (с возможностью добавить или удалить элемент). В качестве аргументов этому компоненту передаются компоненты для отображения и для редактирования элемента списка. Добавьте в приложение страницы для редактирования списка студентов и списка занятий. 
**Добавлены компоненты для изменения занятия и студента(файлы ComponentForLesson,ComponentForStudent**
<br>**ComponentForLesson**
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
            ```
**Д
