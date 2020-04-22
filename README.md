# OopLabsNew
Plyashkevich Anton 28-z
LAB7

**Задание**
<br>Доработайте приложение, добавив компонент, разработанный в последнем задании прошлого урока на отдельную страницу приложения и прописав маршруты к нему.

**В switch добавили вызов функции  LessonAdd**
```
route("/addLesson",
    exact = true,
       render={
        LessonAdd (newFunction())
 })
```
**Добавили в header "/addlesson li {navLink("/addLesson") {+"add more Lesson"} }**

```  
override fun RBuilder.render() {
        header {
            h1 { +"App" }
            nav {
                ul {
                    li { navLink("/lessons") { +"Lessons" } }
                    li { navLink("/students") { +"Students" } }
                    li {navLink("/addLesson") {+"add more Lesson"} }     
                } } }
```
**Немного изменен main.kt**
```
import component.app
import data.*
import react.dom.render
import react.router.dom.browserRouter
import react.router.dom.hashRouter
import kotlin.browser.document
fun main() {
    render(document.getElementById("root")!!) {
        browserRouter {
            app(studentList)
        } }
}
```
**Запустили программу**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/702554365344612472/unknown.png>

**Добавляем "Predmet"**

<img src=https://cdn.discordapp.com/attachments/407510344509030400/702555133665345536/unknown.png>
