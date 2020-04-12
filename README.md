# OopLabsNew
Plyashkevich Anton 28-z
LAB6

**Задания**
<br> Перенесите массив lessons из AppProps в AppState
<br> Добавьте компонент AddLesson, который позволяет добавить урок в массив lessons

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
