package component
import data.*
import react.dom.*
import react.router.dom.*
import hoc.withDisplayName
import kotlinx.html.InputType
import react.*
import redux.*
import kotlin.browser.document
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
interface AppProps : RProps {
    var store: Store<State, RAction, WrapperAction> }
interface RouteNumberResult : RProps {
    var number: String }
fun App() =
    functionalComponent<AppProps> { props ->
        header {
            h1 { +"APP" }
            nav {
                ul {
                    li { navLink("/lessons") { +"Lessons" } }
                    li { navLink("/students") { +"Students" } }
                    li {navLink("/editStudents"){+"Redact Students"} }
                    li {navLink("/editLessons"){+"Redact Lessons"} }
                } } }
        switch {
            route("/lessons",
                exact = true,
                render = {
                    anyList(props.store.getState().lessons, "Lessons", "/lessons",props.deleteforlesson())
                })
            route("/students",
                exact = true,
                render = {
                    anyList(props.store.getState().students, "Students", "/students",props.deleteforstudent())
                })
            route("/lessons/:number",
                render = renderLesson(props))
            route("/students/:number",
                render = renderStudent(props))
            route("/editStudents",
                render = editStudent(props))
            route("/editLessons",
                render = redactlesson(props)
                ) } }
fun AppProps.addStud(): (Event) -> Unit ={
    val name = document.getElementById("Students") as HTMLInputElement
    val now = name.value.split(" ")
    store.dispatch(addforstudent(now[0],now[1]))
}
fun AppProps.deleteforstudent():(Int) -> Unit = {index->
    store.dispatch(deleteforstudent(index))
}

fun AppProps.addforlesson(): (Event) -> Unit = {
    val name = document.getElementById("Lessons") as HTMLInputElement
    store.dispatch(addforlesson(name.value))
}

fun AppProps.deleteforlesson(): (Int) -> Unit = {index ->
    store.dispatch(deleteforlesson(index))
}
fun RBuilder.editStudent(props: AppProps) = {
    Redact(
        RBuilder::anyList, RBuilder::StudentAdd, props.store.getState().students, props.addStud(), props.deleteforstudent(),
        "Students",
        "/students"
    ) }
fun RBuilder.redactlesson (props: AppProps) = {
    Redact(RBuilder::anyList, RBuilder::LessonAdd, props.store.getState().lessons, props.addforlesson(), props.deleteforlesson(),
        "Lessons",
        "/lessons"
    ) }
fun AppProps.StudClick(num: Int): (Int) -> (Event) -> Unit =
    { index ->
        {
            store.dispatch(ChangePresent(index, num))
        } }
fun AppProps.LessClick(num: Int): (Int) -> (Event) -> Unit =
    { index ->
        {
            store.dispatch(ChangePresent(num, index))
        } }
fun RBuilder.renderLesson(props: AppProps) =
    { route_props: RouteResultProps<RouteNumberResult> ->
        val num = route_props.match.params.number.toIntOrNull() ?: -1
        val less = props.store.getState().lessons.getOrNull(num)
        if (less != null)
            anyFull(
                RBuilder::student, less, props.store.getState().students, props.store.getState().presents[num], props.LessClick(num)
            )
        else
            p { +"No such lesson" } }
fun RBuilder.renderStudent(props: AppProps) =
    { route_props: RouteResultProps<RouteNumberResult> ->
        val number = route_props.match.params.number.toIntOrNull() ?: -1
        val student = props.store.getState().students.getOrNull(number)
        if (student != null)
            anyFull(
                RBuilder::lesson, student, props.store.getState().lessons, props.store.getState().presents.map {
                    it[number]
                }.toTypedArray(),
                props.StudClick(number)
            ) else
            p { +"No such student" } }
fun RBuilder.app(
    store: Store<State, RAction, WrapperAction>
) = child(
        withDisplayName("App", App())
    ) {
        attrs.store = store }





