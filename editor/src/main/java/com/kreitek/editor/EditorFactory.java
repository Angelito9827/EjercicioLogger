package com.kreitek.editor;
import com.kreitek.editor.exceptions.InvalidEditorTypeException;
import com.kreitek.editor.interfaces.Editor;

import java.util.HashMap;
import java.util.Map;

public class EditorFactory {

    private static final Map<String, Editor> editors = new HashMap<>();

    static {
        editors.put("json", new EditorJSON());
        editors.put("text", new EditorTxt());
    }

    public Editor getEditor(String programArgs) throws InvalidEditorTypeException {
        if (programArgs == null || programArgs.trim().isEmpty()) {
            throw new InvalidEditorTypeException("El argumento del programa no es válido. Usa \"text\" o \"json\".");
        }

        Editor editor = editors.get(programArgs.toLowerCase());
        if (editor == null) {
            throw new InvalidEditorTypeException("El tipo de editor \"" + programArgs + "\" no está soportado. Usa \"text\" o \"json\".");
        }

        return editor;
    }
}