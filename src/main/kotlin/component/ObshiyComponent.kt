package component
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*
interface Props3<O> :RProps{
/*    abstract var delete: (Event) -> Unit*/
   var deletenew : (Event) -> Unit
    var dobavlenie : (Event) -> Unit
    var way : String
    var name : String
    var subject : Array<O>}
fun <O> Redact(
    rAddObj :RBuilder.() -> ReactElement,
    Component: RBuilder.(Array<O>, String, String)->ReactElement
) = functionalComponent<Props3<O>> {props ->
        h2{+"Edit Page"}
        p {
            +"redact ${props.name}"
            rAddObj()
            br {}
            button {
                +"ADD"
                attrs.onClickFunction = props.dobavlenie }
            button {
                +"DEL"
                attrs.onClickFunction = props.deletenew }
            Component(props.subject,props.name,props.way) } }
fun <O> RBuilder.anyEdit(
    Component: RBuilder.(Array<O>, String, String)->ReactElement,
    addobject :RBuilder.() -> ReactElement,
    subject : Array<O>,
    dobavlenie: (Event) -> Unit,
    deletenew: (Event) -> Unit,
    name : String,
    way: String
) = child(Redact<O>(addobject,Component)){
    attrs.dobavlenie=dobavlenie
    attrs.deletenew=deletenew
    attrs.subject= subject
    attrs.name = name
    attrs.way = way}