import data.Student
import data.studentList
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.input
import kotlinx.html.js.*
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.dom.clear


var ascending = true


fun main() {
    document.getElementById("root")!!
        .append {
            h1 {
                attributes += "id" to "header"
                +"Students"
                onClickFunction = onCLickFunction()
            }
            ol {
                attributes += "id" to "listStudents"
                studentList.map {
                    li {
                        +"${it.firstname} ${it.surname}"
                        attributes += "id" to it.surname
                        onClickFunction = CVET(it)
                    }
                }
            }
           input(options = arrayListOf("orange", "white", "pink","green","black"))// massiv


                /*value = arrayListOf(")
             input(options = arrayListOf("blue","green","pink"))
                onClickFunction = {
                    val header =
                        document.getElementById("header")!!
                    header.setAttribute("style", "color:${value}")
*/
                }
            }



fun TagConsumer<HTMLElement>.input(classes: String? = null, options: List<String>, block: DIV.() -> Unit = {}) = div(classes) {
    options.forEach {
        input(InputType.radio) { attributes += "value" to it
            onClickFunction = { val container = document.getElementById("root")!!
                container.className = value
            }
        }
        (studentList)+it
    }
    block()
}


fun CVET(it: Student): (Event) -> Unit {
    return { _ ->
        studentList+it
        val id = document.getElementById(it.firstname /*it.surname */)!!//func с цветом
        id.className = "CVET"

    }
}


fun onCLickFunction(): (Event) -> Unit {
    return {
        val listStudents = document.getElementById("listStudents")!!
        listStudents.clear()
        listStudents.append {
            if (ascending)
                studentList.sortBy { it.firstname }
            else
                studentList.sortByDescending { it.firstname }
            ascending = !ascending
            studentList.map {
                li {
                    +"${it.firstname} ${it.surname}"
                }
            }
        }
    }
}