package component
import data.*
import hoc.withDisplayName
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.router.dom.*
import kotlin.browser.document
interface AppProps : RProps {}
interface AppState : RState {
    var less: Array<Lesson>
    var students: Array<Student>
    var presents: Array<Array<Boolean>> }
interface Route : RProps {
    var number: String }
class App : RComponent<AppProps, AppState>() {
    override fun componentWillMount() {
        state.less = lessonsList
        state.students = studentList
        state.presents = Array(state.less.size) {
            Array(state.students.size) { false }
        } }
    override fun RBuilder.render() {
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
                    anyList(state.less, "Lessons", "/lessons") })
            route("/students",
                exact = true,
                render = {
                    anyList(state.students, "Students", "/students") })
            route("/lessons/:number",
                render = { route_props: RouteResultProps<Route> ->
                    val number = route_props.match.params.number.toIntOrNull() ?: -1
                    val less = state.less.getOrNull(number)
                    if (less != null)
                        anyFull(
                            RBuilder::student, less, state.students,
                            state.presents[number]
                        ) { onClick(number, it) }
                    else
                        p { +"No lesson here" }
                })
            route("/students/:number",
                render = { route_props: RouteResultProps<Route> ->
                    val number = route_props.match.params.number.toIntOrNull() ?: -1
                    val student = state.students.getOrNull(number)
                    if (student != null)
                        anyFull(
                            RBuilder::lesson, student, state.less,
                            state.presents.map {
                                it[number]
                            }.toTypedArray()
                        ) { onClick(it, number) }
                    else
                        p { +"No student here" }
                })
            route("/editStudents",
                render = {
                   Redact(
                        RBuilder::anyList, RBuilder::StudentAdd, state.students, addforstudent(), deleteforstudent(),
                        "Students",
                        "/students"
                    ) })
            route("/editLessons",
                render = {
                   Redact(
                        RBuilder::anyList, RBuilder::LessonAdd, state.less, addforelesson(), deleteforlesson(),
                        "Lessons",
                        "/lessons")
                })
        } }
    fun addforelesson():(Event) -> Unit = {
        val objectnew = document.getElementById("Lessons") as HTMLInputElement
        setState {
            less += Lesson(objectnew.value)
            presents += arrayOf(Array(state.students.size){false})
        } }
    fun deleteforlesson() :(Event) -> Unit = {
        val objectnew = document.getElementById("DeleteLessons") as HTMLInputElement
        val redactLesson = state.less.toMutableList().apply {
            removeAt(objectnew.value.toInt()-1) }
            .toTypedArray()
        val redactPresent = state.presents.toMutableList().apply {
            removeAt(objectnew.value.toInt()-1) }
            .toTypedArray()
        setState{
            less = redactLesson
            presents=redactPresent
        } }
    fun addforstudent():(Event) -> Unit = {
        val objectnew = document.getElementById("Students") as HTMLInputElement
        val newvalue = objectnew.value.split(" ")
        setState {
            students += Student(newvalue[0],newvalue[1])
            presents += arrayOf(Array(state.students.size){false})
        } }
    fun deleteforstudent() :(Event) -> Unit = {
        val objectnew = document.getElementById("DeleteStudents") as HTMLInputElement
        val redactStudent = state.students.toMutableList().apply {
            removeAt(objectnew.value.toInt()-1) }
            .toTypedArray()
        val redactPresent = state.presents.toMutableList().apply {
            removeAt(objectnew.value.toInt()-1) }
            .toTypedArray()
        setState{
            students = redactStudent
            presents= redactPresent
        } }
    fun onClick(indexLesson: Int, indexStudent: Int) =
        { _: Event ->
            setState {
                presents[indexLesson][indexStudent] =
                    !presents[indexLesson][indexStudent] } } }
fun RBuilder.app() =
    child(
        withDisplayName("AppHoc", App::class)
    ) {
    }



