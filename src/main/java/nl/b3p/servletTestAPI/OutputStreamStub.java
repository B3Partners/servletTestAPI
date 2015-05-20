package nl.b3p.servletTestAPI;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author rachelle
 */
public class OutputStreamStub extends OutputStream {

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
