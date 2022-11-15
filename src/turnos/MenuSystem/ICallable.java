package turnos.MenuSystem;

import java.io.IOException;

public interface ICallable { // Interface which allows polymorphism
    void doCallback() throws IOException;
}