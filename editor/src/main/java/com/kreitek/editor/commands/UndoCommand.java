package com.kreitek.editor.commands;

import com.kreitek.editor.CareTaker;
import com.kreitek.editor.interfaces.Command;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class UndoCommand implements Command {

    private final CareTaker careTaker;

    public UndoCommand(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        Memento memento = careTaker.remove();

        if (memento != null) {
            documentLines.clear();
            documentLines.addAll(memento.getState());
        }
            System.out.println("No hay cambios que deshacer");
    }
}
