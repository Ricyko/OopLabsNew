# OopLabsNew
Plyashkevich Anton 28-z
LAB10

<br>**Задание**
Доработайте приложение, добавив в списки фильтры, которые выводят либо всех студентов (уроки), либо только присутствующих, либо только отсутствующих. Идеи для реализации такого фильтра можно задействовать из этого проекта.
<br>**Создан компонент для задания vision**
```
package data

enum class vision{
    vse,
    prisutstvie,
    otsutstvie
}
```
<br>**В action добавлии новый class**
```
class SetVisibilityFilter(val filter: vision) : RAction
```
<br>**Созданы кнопки для нажатия(vision)**
```
package component

import container.filterLink
import data.vision
import react.RBuilder
import react.dom.div
import react.dom.span


fun RBuilder.showproc() =
        div {
            span { +"show: " }
            filterLink {
                attrs.filter =  vision.vse
                +"         vse         "
            }
            filterLink {
                attrs.filter = vision.prisutstvie
                +"     prisutstvie         "
            }
            filterLink {
                attrs.filter = vision.otsutstvie
                +"         otsutstive           "
            }
        }
```
<br>**Добавляем кнопки через span**
```
package component

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.span

interface LinkProps : RProps {
    var onClick: () -> Unit
}

class spanlink(props: LinkProps) : RComponent<LinkProps, RState>(props) {
    override fun RBuilder.render() {
        span("fakeLink") {
            attrs.onClickFunction = { props.onClick() }
            children()
        }
    }
}
```
<br>**Для anyfullcontainer добавили видимость студентов и предметов**
```
private fun studentPrisOts(
        students: Map<Int, Student>,
        presents: Map<Int, Boolean>?,
        filter: vision): Map<Int, Student>  {
    if (filter == vision.vse) return students
    if(filter == vision.otsutstvie){
        val absent :MutableMap<Int,Student> = students.toMutableMap()
        absent.clear()
        if (!presents?.isEmpty()!!) {
            presents.filter { !it.value }.map{
                absent[it.key] = students.getValue(it.key)
            }
        }
        return absent
    }
    if(filter == vision.prisutstvie){
        val present :MutableMap<Int,Student> = students.toMutableMap()
        present.clear()
        if (!presents?.isEmpty()!!) {
            presents.filter { it.value }.map{
                present[it.key] = students.getValue(it.key)
            }
        }
        return present
    }
    return students
}

private fun lessonPrisOts(
        lessons: Map<Int, Lesson>,
        presents: Map<Int, Boolean>?,
        filter: vision): Map<Int, Lesson>  {
    if (filter == vision.vse) return lessons
    if(filter == vision.otsutstvie){
        val absent :MutableMap<Int,Lesson> = lessons.toMutableMap()
        absent.clear()
        if (!presents?.isEmpty()!!) {
            presents.filter { !it.value }.map{
                absent[it.key] = lessons.getValue(it.key)
            }
        }
        return absent
    }
    if(filter == vision.prisutstvie){
        val present :MutableMap<Int,Lesson> = lessons.toMutableMap()
        present.clear()
        if (!presents?.isEmpty()!!) {
            presents.filter { it.value }.map{
                present[it.key] = lessons.getValue(it.key)
            }
        }
        return present
    }
    return lessons
}
```

<br>**Запуск приложения**

<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/713695270575145030/unknown.png>

<br>**В Lesson отмечаем одного студента**

<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/713699728700866587/unknown.png>

<br>**Нажимаем prisutstvie**

<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/713699827564675112/unknown.png>

<br>**Нажимаем otsutstvie**

<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/713700030548017162/unknown.png>

<br>**Нажимаем в student OOP and Philosophy**

<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/713700280084201593/unknown.png>

<br>**Нажимаем otstutstvie**

<br><img src=https://cdn.discordapp.com/attachments/407510344509030400/713700417602846720/unknown.png>
<br> Вывод: Доработали приложение, добавив в списки фильтры, которые выводят либо всех студентов (уроки), либо только присутствующих, либо только отсутствующих. Идеи для реализации такого фильтра задействованы из примера приложение на https://github.com/AltmanEA/kotlinjs/tree/2ef20e09a6e5db7d48f7b8d794d048a2e4a29267.
