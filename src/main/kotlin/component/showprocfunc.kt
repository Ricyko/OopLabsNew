package component

import container.filterLink
import data.vision
import react.RBuilder
import react.dom.div
import react.dom.span
import redux.SetVisibilityFilter

fun RBuilder.showproc() =
        div {
            span { +"show: " }
            filterLink {
                attrs.filter =  vision.vse
                +"         vse         "
            }
            filterLink {
                attrs.filter = vision.prisutstvie
                +"     prisutstvie         "
            }
            filterLink {
                attrs.filter = vision.otsutstvie
                +"         otsutstive           "
            }
        }