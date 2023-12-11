/**
 * The IOLibrary class provides utility methods for input/output operations,
 * including reading strings and obtaining IP addresses from the user.
 * It encapsulates common input reading logic and offers a clean interface for
 * obtaining user inputs in a reliable way.
 */

package base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;

public final class IOLibrary {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String testString; // Added for testing purposes

    public static String getString() {
        if (testString != null) {
            return testString;
        }

        do {
            try {
                return reader.readLine();
            } catch (Exception e) {
                // Handle exceptions
            }
        } while (true);
    }

    public static InetAddress getIPAddress() {
        do {
            try {
                String[] chunks = reader.readLine().split("\\.");
                byte[] data = {Byte.parseByte(chunks[0]), Byte.parseByte(chunks[1]), Byte.parseByte(chunks[2]),
                        Byte.parseByte(chunks[3])};
                return Inet4Address.getByAddress(data);
            } catch (Exception e) {
                // Handle exceptions
            }
        } while (true);
    }

    public static void setStringForTest(String testString) {
        IOLibrary.testString = testString;
    }
}