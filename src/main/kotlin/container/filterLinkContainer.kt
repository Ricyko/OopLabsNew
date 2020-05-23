package container

import component.spanlink

import data.State
import data.vision
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.LinkProps
import redux.SetVisibilityFilter
import redux.WrapperAction

interface SortingLinkProps : RProps {
    var filter: vision
}
private interface LinkStateProps : RProps {
    var active: Boolean
}

private interface LinkDispatchProps : RProps {
    var onClick: () -> Unit
}

val filterLink: RClass<SortingLinkProps> =
        rConnect<State, SetVisibilityFilter, WrapperAction, SortingLinkProps, LinkStateProps, LinkDispatchProps, LinkProps>(
                { state, ownProps ->
                    active = vision.vse == ownProps.filter
                },
                { dispatch, ownProps ->
                    onClick = { dispatch(SetVisibilityFilter(ownProps.filter)) }
                }
        )(spanlink::class.js.unsafeCast<RClass<LinkProps>>())