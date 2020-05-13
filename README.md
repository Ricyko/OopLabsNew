# OopLabsNew
Plyashkevich Anton 28-z
LAB9

<br>**Задание**
<br>Используя код приложения из лекций переделайте приложения из последнего задания предыдущего модуля с использованием redux. Реализовать хранилище нужно простым способом, без использования функций комбинирования reducer'ов (их мы рассмотрим далее).

<br>**Файлы исходного кода подверглись изменению,app,reducer,action**
<br>**В action привнесли несколько классов, c помощью которых возможна корректная работа **
``` 
class ChangePresent(val lesson: Int, val student: Int) : RAction
class addforstudent (val studname: String, val studsurname: String) :RAction
class addforlesson (val less: String) :RAction
class deleteforstudent (val number: Int) :RAction
class deleteforlesson (val number: Int) :RAction
```

<br>**Reducer изменен,добавлены некоторые изменения,такие как:**
```
package redux


import data.Student
import data.*
import data.Lesson
import data.State
import react.dom.*
import react.router.dom.*
import hoc.withDisplayName
import kotlinx.html.InputType
import react.*
import redux.*
import kotlin.browser.document
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
fun changeReducer(state: State, action: RAction) =
    when (action) {
        is ChangePresent -> State(
            state.presents.mapIndexed { indexLesson, lesson ->
                if (indexLesson == action.lesson)
                    lesson.mapIndexed { indexStudent, student ->
                        if (indexStudent == action.student)
                            !student
                        else student
                    }.toTypedArray()
                else
                    lesson }.toTypedArray(),
            state.lessons,
            state.students)
        is addforstudent ->State(
            state.presents.mapIndexed{index,_ ->
                state.presents[index].plus(arrayOf(false))
            }.toTypedArray(),
            state.lessons,
            state.students.plus(Student(action.studname,action.studsurname)))
        is deleteforstudent -> State(
            state.presents.mapIndexed{ index, _ ->
                state.presents[index].toMutableList().apply {
                    removeAt(action.number)
                }.toTypedArray()
            }.toTypedArray(),
            state.lessons,
            state.students.toMutableList().apply {
                removeAt(action.number)
            }.toTypedArray())
        is addforlesson -> State(
            state.presents.plus(arrayOf(Array(state.students.size) { false })),
            state.lessons.plus(Lesson(action.less)),
            state.students)
        is deleteforlesson -> State(
            state.presents.toMutableList().apply {
                removeAt(action.number)
            }.toTypedArray(),
            state.lessons.toMutableList().apply {
                removeAt(action.number)
            }.toTypedArray(),
            state.students)
        else -> state }
```
<br>**App подкорректирован для работы**
<br>**Суть работы программы не изменилась с 8 lab, предыдущий модуль был переделан с использованием redux**
<br>**Программа после запуска**
<img src=https://cdn.discordapp.com/attachments/407510344509030400/710250398039932979/unknown.png>
<br>**Открываем редактирование студентов**
<img src=https://cdn.discordapp.com/attachments/407510344509030400/710251282585092116/unknown.png>
<br>**Добавляем студента,удаляем 2 первых**
<img src=https://cdn.discordapp.com/attachments/407510344509030400/710251607689920562/unknown.png>
<br>**Аналогично можно проделать с редактированием уроков**
Вывод: Используя код приложения из лекций переделали приложения из последнего задания предыдущего модуля с использованием redux. Реализовали хранилище простым способом, без использования функций комбинирования reducer'ов.
