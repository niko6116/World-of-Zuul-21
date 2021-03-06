package Business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class CommandWords {

    private HashMap<String, CommandWord> validCommands; //A hashmap with the constants from the enom class CommandWords as values.
    private List<String> noPrintList;

    /**
     * Create a new CommandWords
     */
    public CommandWords() {
        validCommands = new HashMap<>(); // Creating an object
        noPrintList = new ArrayList<>();
        Collections.addAll(noPrintList, CommandWord.YES.toString(), CommandWord.NO.toString(), CommandWord.LOAD.toString(), CommandWord.NEW.toString());
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {  //Checks if command isn't UNKNOWN,
                validCommands.put(command.toString(), command); //If it isn't, a new entry is added to the validCommands HashMap
            }
        }
    }

    /**
     * Get the {@link CommandWord} for the parameter.
     *
     * @param commandWord string version of CommandWord
     * @return the corresponding CommandWord to the parameter. return unknown if the command is not recognized
     */
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) { //Checks if command isnt null, so it can be returned, else UNKNOWN ("?") is returned
            return command;
        } else {
            return CommandWord.UNKNOWN;
        }
    }


    /**
     * prints all valid commands, except the commands in noPrintList
     */
    public void showAll() {
        for (String command : validCommands.keySet()) { //For each loop, that prints out every key in the HashMap validCommands.
            if (!noPrintList.contains(command)) { // if the current command is not in noPrintList, print it.
                System.out.print(command + "  ");
            }
        }
        System.out.println();
    }
}
