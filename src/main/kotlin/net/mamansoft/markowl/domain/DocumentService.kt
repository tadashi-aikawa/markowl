package net.mamansoft.markowl.domain

import net.mamansoft.markowl.util.width

fun drawHeaderLine(doc: OwlDocument, lineSymbol: String) {
    doc.action() {
        if (doc.hasCurrentLineHeaderPrefix) {
            doc.removeCurrentLineHeaderPrefix()
        }

        val border = lineSymbol.repeat(width(doc.currentLineText))
        if (!doc.hasNextLine) {
            doc.insertToNextLine("")
            doc.insertToNextLine(border)
            doc.moveEOF()
            return@action
        }

        if (doc.isNextLineHeaderLine) {
            doc.replaceToNextLine(border)
        } else {
            doc.insertToNextLine(border)
        }
    }
}

fun drawHeaderPrefix(doc: OwlDocument, level: Int) {
    doc.action() {
        if (doc.hasCurrentLineHeaderPrefix) {
            doc.removeCurrentLineHeaderPrefix()
        }
        doc.insertCurrentLineHeaderPrefix(level)

        if (doc.isNextLineHeaderLine) {
            doc.deleteNextLine()
        }
    }
}
