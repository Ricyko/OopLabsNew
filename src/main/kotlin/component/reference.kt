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