package component
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*
interface Props3<O> :RProps{
    /*    abstract var delete: (Event) -> Unit*/
    var deletenew : (Int) -> Unit
    var dobavlenie : (Event) -> Unit
    var way : String
    var name : String
    var subject : Array<O>}
fun <O> Redact(
    rAddObj :RBuilder.() -> ReactElement,
    Component: RBuilder.(Array<O>, String, String,(Int) -> Unit)->ReactElement
) = functionalComponent<Props3<O>> {props ->
    h1{+"you can add or delete students/lessons"}
    h2{+"write something"}
    p {
        +"redact ${props.name}"
        rAddObj()
        br {}
        button {
            +"ADD"
            attrs.onClickFunction = props.dobavlenie
        }
        Component(props.subject,props.name,props.way,props.deletenew)
    }
}
fun <O> RBuilder.Redact(
    rComponent: RBuilder.(Array<O>, String, String,(Int) -> Unit)->ReactElement,
    addobject :RBuilder.() -> ReactElement,
    subject : Array<O>,
    dobavlenie: (Event) -> Unit,
    deletenew: (Int) -> Unit,
    name : String,
    way: String
) =  child(Redact<O>(addobject,rComponent)){
    attrs.dobavlenie=dobavlenie
    attrs.deletenew=deletenew
    attrs.subject= subject
    attrs.name = name
    attrs.way = way}