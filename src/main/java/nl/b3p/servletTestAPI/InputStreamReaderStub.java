package nl.b3p.servletTestAPI;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 *
 * @author rachelle
 */
public class InputStreamReaderStub extends InputStreamReader {
    private InputStream stream;
    private Charset charset;
    private boolean isOpen  = true;
    
    /**
     * Create an InputStreamReader that uses the default charset. 
     * 
     * @param in An InputStream
     */
    public InputStreamReaderStub(InputStream in){
        super(in);
        
        this.charset    = Charset.forName("UTF-8");
        this.stream     = in;
    }
 
    /**
     * Create an InputStreamReader that uses the named charset. 
     * 
     * @param in            An InputStream
     * @param charsetName   The name of a supported charset
     * @throws UnsupportedEncodingException If the named charset is not supported
     */
    public InputStreamReaderStub(InputStream in,String charsetName) throws UnsupportedEncodingException {
        this(in);
        
        try {
            this.charset    = Charset.forName(charsetName);
        }
        catch(Exception e){
            throw new UnsupportedEncodingException("Charset "+charsetName+" is not supported.");
        }
    }
    
    /**
     * Create an InputStreamReader that uses the given charset decoder. 
     * 
     * @param in    An InputStream
     * @param cs    A charset decoder
     */
    public InputStreamReaderStub(InputStream in,Charset cs){
        this(in);
        
        this.charset    = cs;
    }
    
    /**
     * Return the name of the character encoding being used by this stream.
     * 
     * If the encoding has an historical name then that name is returned; otherwise the encoding's canonical name is returned.
     * 
     * If this instance was created with the InputStreamReader(InputStream, String) constructor then the returned name, being unique for the encoding, may differ from the name passed to the constructor. This method may return null if the stream has been closed.
     * 
     * @return The historical name of this encoding, or possibly null if the stream has been closed
     */
    @Override
    public String getEncoding(){
        if( !this.isOpen )  return null;
        
        return this.charset.displayName();
    }
    
    /**
     * Read a single character. 
     * 
     * @return  The character read, or -1 if the end of the stream has been reached 
     * @throws  IOException If an I/O error occurs
     */
    @Override
    public int read() throws IOException {
        return this.stream.read();
    }
    
    /**
     * Read characters into a portion of an array. 
     * 
     * @param cbuf          Destination buffer
     * @param offset        Offset at which to start storing characters
     * @param length        Maximum number of characters to read 
     * @return              The number of characters read, or -1 if the end of the stream has been reached 
     * @throws IOException  If an I/O error occurs
     */
    @Override
    public int read(char[] cbuf,int offset,int length) throws IOException {
        byte[] data = new byte[cbuf.length];
        int read    = this.stream.read(data, offset, length);
        
        String text = new String(data, this.charset);
        cbuf        = text.toCharArray();
        
        return read;
    }
    
    /**
     * Tell whether this stream is ready to be read. An InputStreamReader is ready if its input buffer is not empty, or if bytes are available to be read from the underlying byte stream. 
     * 
     * @return  True if the next read() is guaranteed not to block for input, false otherwise. Note that returning false does not guarantee that the next read will block.
     * @throws IOException  If an I/O error occurs
     */
    @Override
    public boolean ready() throws IOException {
        if( this.isOpen )   return true;
        return false;
    }
    
    /**
     * Close the stream. 
     * 
     * @throws IOException  If an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        this.stream.close();
        this.isOpen = false;
    }
}
