package com.kreitek.editor;

import java.util.ArrayList;

public class EditorJSON extends ConsoleEditor{
    @Override
    public void showDocumentLines(ArrayList<String> textLines) {
        if (textLines.size() > 0) {
            setTextColor(TEXT_YELLOW);
            printLnToConsole("{\n\"doc\":[");
            for (int index = 0; index < textLines.size(); index++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" {\"line\":\"");
                stringBuilder.append(index);
                stringBuilder.append("\",\"text\":\"");
                stringBuilder.append(textLines.get(index));
                printToConsole(stringBuilder.toString());
                printToConsole("\"}");
                if (index < textLines.size() - 1) {
                    printLnToConsole(",");
                }
            }
            printLnToConsole(" \n]\n}");
            setTextColor(TEXT_RESET);
        }
    }

}