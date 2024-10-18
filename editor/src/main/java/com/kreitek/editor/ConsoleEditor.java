package com.kreitek.editor;

import com.kreitek.editor.commands.CommandFactory;
import com.kreitek.editor.exceptions.BadCommandException;
import com.kreitek.editor.exceptions.ExitException;
import com.kreitek.editor.interfaces.Command;
import com.kreitek.editor.interfaces.Editor;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleEditor implements Editor {

    private CareTaker careTaker = new CareTaker();
    private final CommandFactory commandFactory = new CommandFactory(careTaker);
    private ArrayList<String> documentLines = new ArrayList<String>();
    private PrintDocumentLines printDocumentLines = new PrintDocumentLines();

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            String commandLine = printDocumentLines.waitForNewCommand();
            try {
                if (!commandLine.equals("undo")) {
                    careTaker.add(getState());
                }
                Command command = commandFactory.getCommand(commandLine);
                command.execute(documentLines);
            } catch (BadCommandException e) {
                printDocumentLines.printErrorToConsole("Bad command");
            } catch (ExitException e) {
                exit = true;
            }
            printDocumentLines.showDocumentLines(documentLines);
            printDocumentLines.showHelp();
        }
    }


    public Memento getState() {
        return new Memento (new ArrayList<>(documentLines));
    }

}
