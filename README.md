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
**Добавили в header "/addlesson li {navLink("/addLesson") {+"add more Lesson"} } **
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
