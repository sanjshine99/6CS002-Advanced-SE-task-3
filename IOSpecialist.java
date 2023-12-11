/**
 * The IOSpecialist class acts as a specialized interface for input/output operations,
 * providing a simplified method for obtaining strings using the IOLibrary.
 */

package base;

public class IOSpecialist {
    public IOSpecialist() {
    }

    public String getString() {
        return IOLibrary.getString();
    }
}
