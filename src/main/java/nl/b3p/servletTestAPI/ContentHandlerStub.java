package nl.b3p.servletTestAPI;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 *
 * @author rachelle
 */
public class ContentHandlerStub implements ContentHandler {
    private Locator locator;
    private boolean parsing = false;
    private String startPrefix;
    private String uri;
    
    /**
     * Receive an object for locating the origin of SAX document events.
     * 
     * SAX parsers are strongly encouraged (though not absolutely required) to supply a locator: if it does so, it must supply the locator to the application by invoking this method before invoking any of the other methods in the ContentHandler interface.
     * 
     * The locator allows the application to determine the end position of any document-related event, even if the parser is not reporting an error. Typically, the application will use this information for reporting its own errors (such as character content that does not match an application's business rules). The information returned by the locator is probably not sufficient for use with a search engine.
     * 
     * Note that the locator will return correct information only during the invocation of the events in this interface. The application should not attempt to use it at any other time.
     * 
     * @param locator An object that can return the location of any SAX document event.
     */
    public void setDocumentLocator(Locator locator) {
        this.locator    = locator;
    }

    /**
     * Receive notification of the beginning of a document.
     * 
     * he SAX parser will invoke this method only once, before any other methods in this interface or in DTDHandler (except for setDocumentLocator).
    * 
     * @throws SAXException     Any SAX exception, possibly wrapping another exception.
     */
    public void startDocument() throws SAXException {
        this.parsing    = true;
    }

    /**
     * Receive notification of the end of a document.
     * 
     * The SAX parser will invoke this method only once, and it will be the last method invoked during the parse. The parser shall not invoke this method until it has either abandoned parsing (because of an unrecoverable error) or reached the end of input.
     * 
     * @throws SAXException Any SAX exception, possibly wrapping another exception.
     */
    public void endDocument() throws SAXException {        
        this.parsing    = false;
    }

    /**
     * The client may throw an exception during processing.
     * 
     * @param prefix
     * @param uri
     * @throws SAXException 
     */
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        
    }

    public void processingInstruction(String target, String data) throws SAXException {
        
    }

    public void skippedEntity(String name) throws SAXException {
        
    }
    
}
