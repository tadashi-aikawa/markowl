package net.mamansoft.markowl.domain

import net.mamansoft.markowl.util.width

fun drawHeaderLine(doc: OwlDocument, lineSymbol: String) {
    if (doc.hasCurrentLineHeaderPrefix) {
        doc.removeCurrentLineHeaderPrefix()
    }

    val border = lineSymbol.repeat(width(doc.currentLineText))
    if (!doc.hasNextLine) {
        doc.safeInsertToNextLine("")
        doc.safeInsertToNextLine(border)
        doc.moveEOF()
        return
    }

    if (doc.isNextLineHeaderLine) {
        doc.safeReplaceToNextLine(border)
    } else {
        doc.safeInsertToNextLine(border)
    }
}

fun drawHeaderPrefix(doc: OwlDocument, level: Int) {
    if (doc.hasCurrentLineHeaderPrefix) {
        doc.removeCurrentLineHeaderPrefix()
    }
    doc.insertCurrentLineHeaderPrefix(level)

    if (doc.isNextLineHeaderLine) {
        doc.safeDeleteNextLine()
    }
}
