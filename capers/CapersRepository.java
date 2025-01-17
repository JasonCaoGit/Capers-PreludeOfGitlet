package capers;

import java.io.File;
import static capers.Utils.*;

/** A repository for Capers 
 * @author Zhuoyuan Cao
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 *
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /**
     * Main metadata folder.
     */
    static final File CAPERS_FOLDER = join(CWD, ".capers");
                                            //      function in Utils
    static final String STORY_TXT= "story.txt";


    static String story;
    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * remember that when we have the path inside the file variable
     * we still need to create them
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        // TODO
        CAPERS_FOLDER.mkdir();
        Dog.DOG_FOLDER.mkdir();





    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        File storyFile = new File(CAPERS_FOLDER, STORY_TXT);
        String contentToWrite;
        if (!storyFile.exists()) {
            contentToWrite = text+ "\n";
        } else {
            contentToWrite = Utils.readContentsAsString(storyFile);
            contentToWrite += text + "\n";
        }

        Utils.writeContents(storyFile, contentToWrite);

    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // TODO
        Dog newDog = new Dog(name, breed, age);
        newDog.saveDog();
        System.out.println(newDog);

    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        // TODO
        Dog bDog = Dog.fromFile(name);
        bDog.haveBirthday();
        bDog.saveDog();
    }
}
