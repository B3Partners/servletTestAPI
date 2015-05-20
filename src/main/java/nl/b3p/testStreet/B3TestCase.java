/*
 * B3P Kaartenbalie is a OGC WMS/WFS proxy that adds functionality
 * for authentication/authorization, pricing and usage reporting.
 *
 * Copyright 2006, 2007, 2008 B3Partners BV
 * 
 * This file is part of B3P Kaartenbalie.
 * 
 * B3P Kaartenbalie is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * B3P Kaartenbalie is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with B3P Kaartenbalie.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.b3p.testStreet;

import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;
import org.apache.log4j.Logger;

/**
 *
 * @author rachelle
 */
abstract public class B3TestCase extends TestCase {

    protected static String className;
    protected static Logger root = null;
    protected String layerName = "testLayer_1";
    protected String layerNames = "testLayer_1,testLayer_2,testLayer_3";
    protected String sourceURI = "http://osm.kaartenbalie.nl";
    protected String userDir;
    protected String seperator;
    protected String data_dir;

    public B3TestCase(String name) {
        super(name);

        className = name;
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        Log4jConfigurator.configure();

        this.userDir = System.getProperty("user.home");
        this.seperator = System.getProperty("file.separator");
        this.data_dir = this.userDir + this.seperator + "test-data" + this.seperator;
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();

        Log4jConfigurator.shutdown();

        this.root = null;
        this.layerName = null;
        this.layerNames = null;
        this.sourceURI = null;
        this.userDir = null;
        this.seperator = null;
    }

    /**
     * Checks if the string values are the same. Use this function for Strings
     * instead of assertEquals()
     *
     * @param expected The expected string
     * @param actual The string to test
     */
    public static void assertStringEquals(String expected, String actual) {
        if (expected == null) {
            fail("Assertion failure. Expected null but found <" + actual + ">.");
        } else if (actual == null) {
            fail("Assertion failure. Expected <" + expected + "> but found null.");
        } else if (!expected.equals(actual)) {
            fail("Assertion failure. Expected <" + expected + "> but found <" + actual + ">.");
        }
    }

    /**
     * Check if the int values are the same with the given tolerance
     *
     * @param expected The expected value
     * @param actual The value to test
     * @param tolerance The tolerance
     */
    public static void assertEquals(int expected, int actual, int tolerance) {
        if ((expected != actual) && tolerance == 0) {
            fail("Assertion failure. Expected <" + expected + "> but found <" + actual + "> with no tolerance.");
        } else if ((expected - actual) > tolerance) {
            fail("Assertion failure. Expected <" + expected + "> but found <" + actual + "> with tolerance <" + tolerance + ">.");
        }
    }

    /**
     * Check if the long values are the same with the given tolerance
     *
     * @param expected The expected value
     * @param actual The value to test
     * @param tolerance The tolerance
     */
    public static void assertEquals(long expected, long actual, long tolerance) {
        if ((expected != actual) && tolerance == 0) {
            fail("Assertion failure. Expected <" + expected + "> but found <" + actual + "> with no tolerance.");
        } else if ((expected - actual) > tolerance) {
            fail("Assertion failure. Expected <" + expected + "> but found <" + actual + "> with tolerance <" + tolerance + ">.");
        }
    }

    /**
     * Generates a date object
     *
     * @return a date object
     */
    protected Date generateDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(112, 1, 1);
        return calendar.getTime();
    }
}
