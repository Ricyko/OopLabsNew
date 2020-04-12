package component
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.*
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*
import kotlin.browser.document

interface Props :RProps{
    var clicks : (String) ->  Unit
}
/*interface State : RState {
    var newLesson: String
}*/
 fun RBuilder.LessonAdd(click :(String) -> Unit ) =
    child(functionalComponent<Props> {props ->
        div{
            h1{""}
        }
        input(InputType.text) {
            attrs {
                id = "newlesson"
            }
        }                                                                          //TODO
        button {
            +"plus"
            attrs.onClickFunction = {
                val nameLesson = document.getElementById("newlesson") as HTMLInputElement
                props.clicks(nameLesson.value)
                //console.log(value)
                /*attrs { button } }*/
            }
        }
    }){
        attrs.clicks=click
       /* attrs.lessons = lessons*/
    }
