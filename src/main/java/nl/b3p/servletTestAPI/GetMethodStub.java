package nl.b3p.servletTestAPI;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthState;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 *
 * @author rachelle
 */
public class GetMethodStub extends GetMethod {

    private URI uri;
    private boolean doAuthenticationStub;
    private boolean followsRedictsStub;
    private String pathStub;
    private HashMap<String, Header> requestHeadersStub;
    private HashMap<String, Header> responseHeadersStub;
    private HashMap<String, Header> responseFootersStub;
    private String queryStringStub;
    private int statusCodeStub;
    private long responseContentLength;
    private InputStream responseStream;
    private HttpMethodParams httpParams;
    private String statusText;
    private boolean isExcequted = false;
    private AuthState proxy;
    private AuthState authentication;
    private boolean isAborted;

    /**
     * No-arg constructor.
     */
    public GetMethodStub() {
        this.init();
    }

    /**
     * Constructor specifying a URI.
     *
     * @param uri
     */
    public GetMethodStub(String uri) {
        try {
            this.uri = new URI(uri, true);
        } catch (Exception e) {
        }

        this.init();
    }

    /**
     * Inits the stub GetMethod
     */
    private void init() {
        this.requestHeadersStub = new HashMap<String, Header>();
        this.responseHeadersStub = new HashMap<String, Header>();
        this.responseFootersStub = new HashMap<String, Header>();
        this.responseStream = new InputStreamStub();
        this.httpParams = new HttpMethodParams();

        this.reset();
    }

    /**
     * Resets the stub status
     */
    private void reset() {
        this.setDoAuthentication(true);
        this.setFollowRedirects(true);
        this.pathStub = "/";
        this.queryStringStub = "";
        this.statusCodeStub = 200;
        this.statusLine = null;
        this.responseContentLength = -1;
        this.statusText = "";
        this.isExcequted = false;
        this.httpParams.setVersion(HttpVersion.HTTP_1_1);
        this.proxy = null;
        this.authentication = null;
        this.isAborted = false;

        this.requestHeadersStub.clear();
        this.responseHeadersStub.clear();
        this.responseFootersStub.clear();

        this.requestHeadersStub.put("charset", new Header("CharSet", "UTF-8"));
        this.responseHeadersStub.put("charset", new Header("CharSet", "UTF-8"));
    }

    /**
     * Returns the URI of the HTTP method
     *
     * @return The URI
     * @throws URIException If the URI cannot be created.
     */
    @Override
    public URI getURI() throws URIException {
        return this.uri;
    }

    /**
     * Sets the URI for this method.
     *
     * @param uri URI to be set
     * @throws URIException if a URI cannot be set
     */
    @Override
    public void setURI(URI uri) throws URIException {
        this.uri = uri;
    }

    /**
     * Sets whether or not the HTTP method should automatically follow HTTP
     * redirects (status code 302, etc.)
     *
     * @param followRedirects true if the method will automatically follow
     * redirects, false otherwise.
     */
    @Override
    public void setFollowRedirects(boolean followRedirects) {
        this.followsRedictsStub = followRedirects;
    }

    /**
     * Returns true if the HTTP method should automatically follow HTTP
     * redirects (status code 302, etc.), false otherwise.
     *
     * @return true if the method will automatically follow HTTP redirects,
     * false otherwise.
     */
    @Override
    public boolean getFollowRedirects() {
        return this.followsRedictsStub;
    }

    /**
     * Sets whether version 1.1 of the HTTP protocol should be used per default.
     *
     * @param http11 true to use HTTP/1.1, false to use 1.0
     * @deprecated Use HttpMethodParams.setVersion(HttpVersion)
     */
    @Override
    public void setHttp11(boolean http11) {
        System.err.println("Use of deprecated function GetMethod::setHttp11().  Use HttpMethodParams.setVersion(HttpVersion) instead.");

        if (http11) {
            this.httpParams.setVersion(HttpVersion.HTTP_1_1);
        } else {
            this.httpParams.setVersion(HttpVersion.HTTP_1_0);
        }
    }

    /**
     * Returns true if the HTTP method should automatically handle HTTP
     * authentication challenges (status code 401, etc.), false otherwise
     *
     * @return true if authentication challenges will be processed
     * automatically, false otherwise.
     */
    @Override
    public boolean getDoAuthentication() {
        return this.doAuthenticationStub;
    }

    /**
     * Sets whether or not the HTTP method should automatically handle HTTP
     * authentication challenges (status code 401, etc.)
     *
     * @param doAuthentication doAuthentication - true to process authentication
     * challenges authomatically, false otherwise.
     */
    @Override
    public void setDoAuthentication(boolean doAuthentication) {
        this.doAuthenticationStub = doAuthentication;
    }

    /**
     * Returns true if version 1.1 of the HTTP protocol should be used per
     * default, false if version 1.0 should be used.
     *
     * @return true to use HTTP/1.1, false to use 1.0
     * @deprecated Use HttpMethodParams.getVersion()
     */
    @Override
    public boolean isHttp11() {
        System.err.println("Use of deprecated function GetMethod::isHttp11().  Use HttpMethodParams.getVersion() instead.");

        return this.httpParams.getVersion() == HttpVersion.HTTP_1_1;
    }

    /**
     * Sets the path of the HTTP method. It is responsibility of the caller to
     * ensure that the path is properly encoded (URL safe).
     *
     * @param path the path of the HTTP method. The path is expected to be
     * URL-encoded
     */
    @Override
    public void setPath(String path) {
        this.pathStub = path;
    }

    /**
     * Adds the specified request header, NOT overwriting any previous value.
     * Note that header-name matching is case insensitive.
     *
     * @param header the header to add to the request
     */
    @Override
    public void addRequestHeader(Header header) {
        this.requestHeadersStub.put(this.getHeaderName(header), header);
    }

    /**
     * Use this method internally to add footers.
     *
     * @param footer The footer to add.
     */
    @Override
    public void addResponseFooter(Header footer) {
        this.responseFootersStub.put(this.getHeaderName(footer), footer);
    }

    /**
     * Gets the path of this HTTP method. Calling this method after the request
     * has been executed will return the actual path, following any redirects
     * automatically handled by this HTTP method.
     *
     * @return the path to request or "/" if the path is blank.
     */
    @Override
    public String getPath() {
        return this.pathStub;
    }

    /**
     * Sets the query string of this HTTP method. The caller must ensure that
     * the string is properly URL encoded. The query string should not start
     * with the question mark character.
     *
     * @param queryString the query string
     */
    @Override
    public void setQueryString(String queryString) {
        this.queryStringStub = queryString;
    }

    /**
     * Sets the query string of this HTTP method. The pairs are encoded as UTF-8
     * characters. To use a different charset the parameters can be encoded
     * manually using EncodingUtil and set as a single String.
     *
     * @param params an array of NameValuePairs to add as query string
     * parameters. The name/value pairs will be automcatically URL encoded
     */
    @Override
    public void setQueryString(NameValuePair[] params) {
        for (int i = 0; i < params.length; i++) {
            if (!this.queryStringStub.equals("")) {
                this.queryStringStub += "&";
            }

            this.queryStringStub += params[i].getName() + "=" + params[i].getValue();
        }
    }

    /**
     * Gets the query string of this HTTP method.
     *
     * @return The query string
     */
    @Override
    public String getQueryString() {
        return this.queryStringStub;
    }

    /**
     * Set the specified request header, overwriting any previous value. Note
     * that header-name matching is case-insensitive.
     *
     * @param headerName the header's name
     * @param headerValue the header's value
     */
    @Override
    public void setRequestHeader(String headerName, String headerValue) {
        this.setRequestHeader(new Header(headerName, headerValue));
    }

    /**
     * Sets the specified request header, overwriting any previous value. Note
     * that header-name matching is case insensitive.
     *
     * @param header the header
     */
    @Override
    public void setRequestHeader(Header header) {
        String checkName = this.getHeaderName(header);
        if (this.requestHeadersStub.containsKey(checkName)) {
            this.requestHeadersStub.remove(checkName);
        }

        this.requestHeadersStub.put(checkName, header);
    }

    /**
     * Returns the specified request header. Note that header-name matching is
     * case insensitive. null will be returned if either headerName is null or
     * there is no matching header for headerName.
     *
     * @param headerName The name of the header to be returned.
     * @return The specified request header.
     */
    @Override
    public Header getRequestHeader(String headerName) {
        if (headerName == null) {
            return null;
        }
        headerName = headerName.toLowerCase();

        if (!this.requestHeadersStub.containsKey(headerName)) {
            return null;
        }

        return this.requestHeadersStub.get(headerName);
    }

    /**
     * Returns an array of the requests headers that the HTTP method currently
     * has
     *
     * @return an array of my request headers.
     */
    @Override
    public Header[] getRequestHeaders() {
        Object[] keys = this.requestHeadersStub.keySet().toArray();
        Header[] out = new Header[this.requestHeadersStub.size()];

        for (int i = 0; i < keys.length; i++) {
            out[i] = this.requestHeadersStub.get((String) keys[i]);
        }

        return out;
    }

    /**
     * Returns the request headers with the given name. Note that header-name
     * matching is case insensitive.
     *
     * @param headerName the name of the headers to be returned.
     * @return an array of zero or more headers
     */
    @Override
    public Header[] getRequestHeaders(String headerName) {
        Object[] keys = this.requestHeadersStub.keySet().toArray();
        ArrayList<Header> out = new ArrayList<Header>();

        String key;
        for (int i = 0; i < keys.length; i++) {
            key = (String) keys[i];
            if (!key.equalsIgnoreCase(headerName)) {
                continue;
            }


            out.add(this.requestHeadersStub.get(key));
        }

        return (Header[]) out.toArray();
    }

    /**
     * Returns the response headers with the given name. Note that header-name
     * matching is case insensitive.
     *
     * @param headerName the name of the headers to be returned.
     * @return an array of zero or more headers
     */
    @Override
    public Header[] getResponseHeaders(String headerName) {
        Object[] keys = this.responseHeadersStub.keySet().toArray();
        ArrayList<Header> out = new ArrayList<Header>();

        String key;
        for (int i = 0; i < keys.length; i++) {
            key = (String) keys[i];
            if (!key.equalsIgnoreCase(headerName)) {
                continue;
            }


            out.add(this.responseHeadersStub.get(key));
        }

        return (Header[]) out.toArray();
    }

    /**
     * Returns the response status code.
     *
     * @return the status code associated with the latest response.
     */
    @Override
    public int getStatusCode() {
        return this.statusCodeStub;
    }

    /**
     * Returns an array of the response headers that the HTTP method currently
     * has in the order in which they were read.
     *
     * @return an array of response headers.
     */
    @Override
    public Header[] getResponseHeaders() {
        Object[] keys = this.responseHeadersStub.keySet().toArray();
        Header[] out = new Header[this.responseHeadersStub.size()];

        for (int i = 0; i < keys.length; i++) {
            out[i] = this.responseHeadersStub.get((String) keys[i]);
        }

        return out;
    }

    /**
     * Gets the response header associated with the given name. Header name
     * matching is case insensitive. null will be returned if either headerName
     * is null or there is no matching header for headerName.
     *
     * @param headerName the header name to match
     * @return the matching header
     */
    @Override
    public Header getResponseHeader(String headerName) {
        Object[] keys = this.responseHeadersStub.keySet().toArray();

        String key;
        for (int i = 0; i < keys.length; i++) {
            key = (String) keys[i];
            if (!key.equalsIgnoreCase(headerName)) {
                continue;
            }

            return this.responseHeadersStub.get(key);
        }

        return null;
    }

    /**
     * Return the length (in bytes) of the response body, as specified in a
     * Content-Length header. Return -1 when the content-length is unknown.
     *
     * @return content length, if Content-Length header is available. 0
     * indicates that the request has no body. If Content-Length header is not
     * present, the method returns -1.
     */
    @Override
    public long getResponseContentLength() {
        return this.responseContentLength;
    }

    /**
     * Returns the response body of the HTTP method, if any, as an array of
     * bytes. If response body is not available or cannot be read, returns null.
     * Buffers the response and this method can be called several times yielding
     * the same result each time. Note: This will cause the entire response body
     * to be buffered in memory. A malicious server may easily exhaust all the
     * VM memory. It is strongly recommended, to use getResponseAsStream if the
     * content length of the response is unknown or resonably large.
     *
     * @return The response body.
     * @throws IOException If an I/O (transport) problem occurs while obtaining
     * the response body.
     */
    @Override
    public byte[] getResponseBody() throws IOException {
        ArrayList<byte[]> out = new ArrayList<byte[]>();
        byte[] buffer = new byte[1024]; //use 1KB buffer;
        int read = 0;
        while (read != -1) {
            read = this.responseStream.read(buffer);

            if (read != -1) {
                out.add(buffer);
            }
        }

        byte[] result = new byte[(out.size() * 1024)];
        byte[] between;
        int counter = 0;
        for (int i = 0; i < out.size(); i++) {
            between = out.get(i);
            for (int j = 0; j < between.length; j++) {
                result[counter] = between[j];
                counter++;
            }
        }

        return result;
    }

    /**
     * Returns the response body of the HTTP method, if any, as an array of
     * bytes. If response body is not available or cannot be read, returns null.
     * Buffers the response and this method can be called several times yielding
     * the same result each time. Note: This will cause the entire response body
     * to be buffered in memory. This method is safe if the content length of
     * the response is unknown, because the amount of memory used is limited.
     *
     * If the response is large this method involves lots of array copying and
     * many object allocations, which makes it unsuitable for high-performance /
     * low-footprint applications. Those applications should use
     * getResponseBodyAsStream().
     *
     * @param maxlen the maximum content length to accept (number of bytes).
     * @return The response body.
     * @throws IOException If an I/O (transport) problem occurs while obtaining
     * the response body
     */
    @Override
    public byte[] getResponseBody(int maxlen) throws IOException {
        byte[] buffer = new byte[maxlen];

        this.responseStream.read(buffer, 0, maxlen);
        return buffer;
    }

    /**
     * Returns the response body of the HTTP method, if any, as an InputStream.
     * If response body is not available, returns null. If the response has been
     * buffered this method returns a new stream object on every call. If the
     * response has not been buffered the returned stream can only be read once.
     *
     * @return The response body or null.
     * @throws IOException If an I/O (transport) problem occurs while obtaining
     * the response body.
     */
    @Override
    public InputStream getResponseBodyAsStream() throws IOException {
        return this.responseStream;
    }

    /**
     * Returns the response body of the HTTP method, if any, as a String. If
     * response body is not available or cannot be read, returns null The string
     * conversion on the data is done using the character encoding specified in
     * Content-Type header. Buffers the response and this method can be called
     * several times yielding the same result each time. Note: This will cause
     * the entire response body to be buffered in memory. A malicious server may
     * easily exhaust all the VM memory. It is strongly recommended, to use
     * getResponseAsStream if the content length of the response is unknown or
     * resonably large.
     *
     * @return The response body or null.
     * @throws IOException If an I/O (transport) problem occurs while obtaining
     * the response body.
     */
    @Override
    public String getResponseBodyAsString() throws IOException {
        return this.getResponseBodyAsString(-1);
    }

    /**
     * Returns the response body of the HTTP method, if any, as a String. If
     * response body is not available or cannot be read, returns null The string
     * conversion on the data is done using the character encoding specified in
     * Content-Type header. Buffers the response and this method can be called
     * several times yielding the same result each time.
     *
     * Note: This will cause the entire response body to be buffered in memory.
     * This method is safe if the content length of the response is unknown,
     * because the amount of memory used is limited.
     *
     * If the response is large this method involves lots of array copying and
     * many object allocations, which makes it unsuitable for high-performance /
     * low-footprint applications. Those applications should use
     * getResponseBodyAsStream().
     *
     * @param maxlen the maximum content length to accept (number of bytes).
     * Note that, depending on the encoding, this is not equal to the number of
     * characters.
     * @return The response body or null.
     * @throws IOException If an I/O (transport) problem occurs while obtaining
     * the response body. @todo implement method
     */
    @Override
    public String getResponseBodyAsString(int maxlen) throws IOException {
        return null;
    }

    /**
     * Gets the name from the given header element
     *
     * @param header The header element
     * @return The name
     */
    private String getHeaderName(Header header) {
        HeaderElement[] values = header.getElements();

        String name = values[0].getName();
        return name.toLowerCase();
    }

    /**
     * Returns an array of the response footers that the HTTP method currently
     * has in the order in which they were read.
     *
     * @return an array of footers
     */
    @Override
    public Header[] getResponseFooters() {
        Object[] keys = this.responseFootersStub.keySet().toArray();
        Header[] out = new Header[this.responseFootersStub.size()];

        for (int i = 0; i < keys.length; i++) {
            out[i] = this.responseFootersStub.get((String) keys[i]);
        }

        return out;
    }

    /**
     * Gets the response footer associated with the given name. Footer name
     * matching is case insensitive. null will be returned if either footerName
     * is null or there is no matching footer for footerName or there are no
     * footers available. If there are multiple footers with the same name,
     * there values will be combined with the ',' separator as specified by
     * RFC2616.
     *
     * @param footerName the footer name to match
     * @return the matching footer
     */
    @Override
    public Header getResponseFooter(String footerName) {
        if (footerName == null) {
            return null;
        }
        Object[] keys = this.responseFootersStub.keySet().toArray();
        String out = "";

        String key;
        for (int i = 0; i < keys.length; i++) {
            key = (String) keys[i];
            if (!key.equalsIgnoreCase(footerName)) {
                continue;
            }

            if (!out.equals("")) {
                out += ";";
            }

            out += this.responseFootersStub.get(key);
        }

        if (!out.equals("")) {
            return new Header(footerName, out);
        }

        return null;
    }

    /**
     * Returns the status text (or "reason phrase") associated with the latest
     * response.
     *
     * @return The status text.
     */
    @Override
    public String getStatusText() {
        return this.statusText;
    }

    /**
     * Provides access to the response status line.
     *
     * @return the status line object from the latest response.
     */
    @Override
    public StatusLine getStatusLine() {
        return this.statusLine;
    }

    /**
     * Sets the status text (or "reason phrase") associated with the latest
     * response.
     *
     * @param statusText The status text.
     */
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    /**
     * Defines how strictly HttpClient follows the HTTP protocol specification
     * (RFC 2616 and other relevant RFCs). In the strict mode HttpClient
     * precisely implements the requirements of the specification, whereas in
     * non-strict mode it attempts to mimic the exact behaviour of commonly used
     * HTTP agents, which many HTTP servers expect.
     *
     * @param strictMode true for strict mode, false otherwise
     * @deprecated Use HttpParams.setParameter(String, Object) to exercise a
     * more granular control over HTTP protocol strictness.
     */
    @Override
    public void setStrictMode(boolean strictMode) {
        System.err.println("Use of deprecated function GetMethod::setStrictMode(strictMode). Use HttpParams.setParameter(String,Object) instead.");

        if (strictMode) {
            this.httpParams.setParameter("strictMode", true);
        } else {
            this.httpParams.setParameter("strictMode", false);
        }
    }

    /**
     * Returns the value of the strict mode flag.
     *
     * @return true for strict mode, false otherwise
     * @deprecated Use HttpParams.setParameter(String, Object) to exercise a
     * more granular control over HTTP protocol strictness.
     */
    @Override
    public boolean isStrictMode() {
        System.err.println("Use of deprecated function GetMethod::isStrictMode(). Use HttpParams.getParameter(String) instead.");

        if (!this.httpParams.isParameterSet("strictMode")) {
            return false;
        }
        return Boolean.valueOf(this.httpParams.getParameter("strictMode").toString());
    }

    /**
     * Adds the specified request header, NOT overwriting any previous value.
     * Note that header-name matching is case insensitive.
     *
     * @param headerName the header's name
     * @param headerValue the header's value
     */
    @Override
    public void addRequestHeader(String headerName, String headerValue) {
        this.requestHeadersStub.put(headerName.toLowerCase(), new Header(headerName, headerValue));
    }

    /**
     * Executes this method using the specified HttpConnection and HttpState.
     *
     * @param state state information to associate with this request. Must be
     * non-null.
     * @param conn the connection to used to execute this HTTP method. Must be
     * non-null.
     * @return the integer status code if one was obtained, or -1
     * @throws HttpException if an I/O (transport) error occurs
     * @throws IOException if a protocol exception occurs.
     */
    @Override
    public int execute(HttpState state, HttpConnection conn) throws HttpException, IOException {
        if (state == null || conn == null) {
            throw new HttpException("State and conn can not be null");
        }

        this.isExcequted = true;

        return -1;
    }

    /**
     * Aborts the execution of this method.
     */
    @Override
    public void abort() {
        this.isAborted = true;
    }

    /**
     * Returns true if the HTTP method has been already executed, but not
     * recycled.
     *
     * @return true if the method has been executed, false otherwise
     */
    @Override
    public boolean hasBeenUsed() {
        return this.isExcequted;
    }

    /**
     * Recycles the HTTP method so that it can be used again. Note that all of
     * the instance variables will be reset once this method has been called.
     * This method will also release the connection being used by this HTTP
     * method.
     *
     * @deprecated no longer supported and will be removed in the future version
     * of HttpClient
     */
    @Override
    public void recycle() {
        System.err.println("Use of deprecated function GetMethod::recyle(). This function has no replacement.");

        this.reset();
    }

    /**
     * Releases the connection being used by this HTTP method. In particular the
     * connection is used to read the response(if there is one) and will be held
     * until the response has been read. If the connection can be reused by
     * other HTTP methods it is NOT closed at this point.
     */
    @Override
    public void releaseConnection() {
    }

    /**
     * Remove the request header associated with the given name. Note that
     * header-name matching is case insensitive.
     *
     * @param headerName the header name
     */
    @Override
    public void removeRequestHeader(String headerName) {
        headerName = headerName.toLowerCase();

        if (this.requestHeadersStub.containsKey(headerName)) {
            this.requestHeadersStub.remove(headerName);
        }
    }

    /**
     * Removes the given request header.
     *
     * @param header the header
     */
    @Override
    public void removeRequestHeader(Header header) {
        String headerName = this.getHeaderName(header);

        this.removeRequestHeader(headerName);
    }

    /**
     * Returns true the method is ready to execute, false otherwise.
     *
     * @return This implementation always returns true.
     */
    @Override
    public boolean validate() {
        return true;
    }

    /**
     * Returns HTTP protocol parameters associated with this method.
     *
     * @return HTTP parameters.
     */
    @Override
    public HttpMethodParams getParams() {
        return this.httpParams;
    }

    /**
     * Assigns HTTP protocol parameters for this method.
     *
     * @param params HTTP parameters.
     */
    @Override
    public void setParams(HttpMethodParams params) {
        this.httpParams = params;
    }

    /**
     * Returns the HTTP version used with this method
     *
     * @return HTTP version
     */
    @Override
    public HttpVersion getEffectiveVersion() {
        return this.httpParams.getVersion();
    }

    /**
     * Returns proxy authentication realm, if it has been used during
     * authentication process. Otherwise returns null.
     *
     * @return proxy authentication realm
     * @deprecated use #getProxyAuthState()
     */
    @Override
    public String getProxyAuthenticationRealm() {
        System.err.println("Use of deprecated function GetMethod::getProxyAuthenticationRealm(). Use GetMethod::getProxyAuthState() instead.");

        if (this.proxy == null) {
            return null;
        }

        return this.proxy.getRealm();
    }

    /**
     * Returns authentication realm, if it has been used during authentication
     * process. Otherwise returns null.
     *
     * @return authentication realm
     * @deprecated use #getHostAuthState()
     */
    public String getAuthenticationRealm() {
        System.err.println("Use of deprecated function GetMethod::getAuthenticationRealm(). Use GetMethod::getHostAuthState() instead.");

        if (this.authentication == null) {
            return null;
        }

        return this.authentication.getRealm();
    }

    /**
     * Returns the character encoding of the request from the Content-Type
     * header.
     *
     * @return String The character set.
     */
    @Override
    public String getRequestCharSet() {
        return this.getRequestHeader("charset").getValue();
    }

    /**
     * Returns the character encoding of the response from the Content-Type
     * header.
     *
     * @return String The character set.
     */
    @Override
    public String getResponseCharSet() {
        return this.getResponseHeader("charset").getValue();
    }

    /**
     * @deprecated no longer used Returns the number of "recoverable" exceptions
     * thrown and handled, to allow for monitoring the quality of the
     * connection.
     *
     * @return The number of recoverable exceptions handled by the method.
     */
    @Override
    public int getRecoverableExceptionCount() {
        System.err.println("Use of deprecated function GetMethod::getRecoverableExceptionCount(). This function has no replacement");
        return 0;
    }

    /**
     * Returns the host configuration.
     *
     * @deprecated no longer applicable
     * @return the host configuration
     */
    @Override
    public HostConfiguration getHostConfiguration() {
        return null;
    }

    /**
     * Sets the host configuration.
     *
     * @deprecated no longer applicable
     * @param hostconfig The hostConfiguration to set
     */
    @Override
    public void setHostConfiguration(HostConfiguration hostconfig) {
    }

    /**
     * Returns the retry handler for this HTTP method
     *
     * @deprecated use HttpMethodParams
     * @return the methodRetryHandler
     */
    @Override
    public MethodRetryHandler getMethodRetryHandler() {
        System.err.println("Use of deprecated method GetMethod::getMethodRetryHandler().  Use HttpMethodParams instead.");

        if (!this.httpParams.isParameterSet("retryHandler")) {
            return null;
        }

        return (MethodRetryHandler) this.httpParams.getParameter("retryHandler");
    }

    /**
     * Sets the retry handler for this HTTP method
     *
     * @deprecated use HttpMethodParams
     * @param handler the methodRetryHandler to use when this method executed
     */
    @Override
    public void setMethodRetryHandler(MethodRetryHandler handler) {
        System.err.println("Use of deprecated method GetMethod::setMethodRetryHandler().  Use HttpMethodParams instead.");

        this.httpParams.setParameter("retryHandler", handler);
    }

    /**
     * Returns the target host authentication state
     *
     * @return host authentication state
     */
    @Override
    public AuthState getHostAuthState() {
        return this.authentication;
    }

    /**
     * Returns the proxy authentication state
     *
     * @return host authentication state
     */
    @Override
    public AuthState getProxyAuthState() {
        return this.proxy;
    }

    /**
     * Tests whether the execution of this method has been aborted
     *
     * @return true if the execution of this method has been aborted, false
     * otherwise
     */
    @Override
    public boolean isAborted() {
        return this.isAborted;
    }

    /**
     * Returns true if the HTTP has been transmitted to the target server in its
     * entirety, false otherwise. This flag can be useful for recovery logic. If
     * the request has not been transmitted in its entirety, it is safe to retry
     * the failed method.
     *
     * @return true if the request has been sent, false otherwise
     */
    @Override
    public boolean isRequestSent() {
        return this.isExcequted;
    }

    /**
     * Returns "GET".
     *
     * @return "GET"
     */
    @Override
    public String getName() {
        return "GET";
    }
}
