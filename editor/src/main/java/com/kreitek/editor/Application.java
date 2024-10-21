package com.kreitek.editor;

import com.kreitek.editor.interfaces.Editor;

public class Application {

    public static void main(String[] args) {

        String programArgs = (args.length > 0) ? args[0] : null;

        EditorFactory editorFactory = new EditorFactory();
        Editor editor = editorFactory.getEditor(programArgs);
        editor.run();
    }

}
