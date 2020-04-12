# OopLabsNew
Plyashkevich Anton 28-z
LAB6

**Задания**
<br> -Перенесите массив lessons из AppProps в AppState
<br> -Добавьте компонент AddLesson, который позволяет добавить урок в массив lessons

**Перенсим массив lessons из AppProps в AppState**
```
interface AppProps : RProps {
    var students: Array<Student>
}

interface AppState : RState {
    var presents: Array<Array<Boolean>>
    var lessons: Array<Lesson>                      // changed
}
```
**Добавьте компонент AddLesson, который позволяет добавить урок в массив lessons**
**<br>Компонент AddLesson**
```
package component

import data.Lesson
import data.Student
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.onChange
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import kotlin.browser.document

interface Props : RProps {
   /* abstract val onClick: */
    var lessons: Array<Lesson>
    var new: (String) -> (Event) -> Unit
}

interface State : RState {
    var newLesson: String
}

class newaddLesson : RComponent<Props, State>() {
    override fun componentWillMount() {
        state.newLesson = ""
    }

    override fun RBuilder.render() {
        h2 {
            +"Add new lesson"
        }

        div {
            input(type = InputType.text) {
                attrs {
                    value = state.newLesson
                    onChangeFunction = {
                        val target = it.target as HTMLInputElement              //TODO
                        setState {
                            newLesson = target.value
                        }

                    }
                }
            }
            button {
                +"plus"
                attrs.onClickFunction = props.new(state.newLesson)
            }

        }
    }
}

fun RBuilder.addlesson(
    lessons: Array<Lesson>,
    new: (String) -> (Event) -> Unit
) = child(newaddLesson::class) {
    attrs.lessons = lessons
    attrs.new = new
}
```
** Функция "changes" добавляет новое занятие вызывает другую функцию, обновляя массив "lessons"**
```
 fun changes() = { newLesson: String ->
        { _: Event ->
            setState {
                lessons += Lesson(newLesson)
                presents += arrayOf(
                    Array(props.students.size) { false })

            }
        }
    }
 ```
 **После запуска**
<img src=https://cdn.discordapp.com/attachments/407510344509030400/698845633792049162/unknown.png>

**После добавления занятия**
<img src=https://cdn.discordapp.com/attachments/407510344509030400/698846271695224862/unknown.png>

**После нажатия на всех студентов в новом предмете**
<img src=https://cdn.discordapp.com/attachments/407510344509030400/698846631914635364/unknown.png>


Мы доработали приложение из видео. Перенесите массив lessons из AppProps в AppState. Добавили компонент AddLesson, который позволяет добавить урок в массив lessons. Другие компоненты (кроме App и AddLesson) не изменились, работают корректн.
