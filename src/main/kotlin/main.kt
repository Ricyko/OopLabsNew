/*import data.Lesson*/
import data.studentList
import data.studentList
import react.dom.h1
import react.dom.li
import react.dom.ol
import react.dom.render
import kotlin.browser.document


fun main() {
    render(document.getElementById("root")!!) {
        h1 {
            +"Timetable for objects"
        }
        ol{
            +"StudentsList"
            li{
                +"Anton Cooper, Anton Hofstadter, Anton Wolowitz"
            }
        }
        PREDMET("PHILOSOPHY", studentList.toTypedArray())
    }
}
