/*
 Copyright (C) 2020  powernukkit.org - José Roberto de Araújo Júnior
 
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <https://www.gnu.org/licenses/>
 */
package org.powernukkit.version;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author joseobjr
 */
class VersionTest {
    @Test
    void constructor() {
        new Version("");
        new Version("1......");
        new Version("1..32");
        new Version("3o13jui1");
    }

    @Test
    void testToString() {
        assertEquals("", new Version("").toString());
        assertEquals("...........", new Version("...........").toString());
    }

    @Test
    void testHashcode() {
        int empty = new Version("").hashCode();
        assertEquals(new ArrayList<String>().hashCode(), empty);
        assertEquals(empty, new Version("+++++++++").hashCode());
        assertEquals(empty, new Version("_+_+_+_+").hashCode());
        assertEquals(new ArrayList<>(Arrays.asList(1,2,3)).hashCode(), new Version("1.2.3").hashCode());
        assertEquals(new ArrayList<>(Arrays.asList(1,2,3,"pn")).hashCode(), new Version("1.2.3-PN").hashCode());
    }

    @Test
    void compare() {
        assertEquals(-1, new Version("1.1").compareTo(new Version("1.1.1")));
        assertEquals(1, new Version("1.1.1").compareTo(new Version("1.1")));
        assertEquals(0, new Version("1.1.1").compareTo(new Version("1.1.1")));
        assertEquals(1, new Version("1.1.1").compareTo(new Version("1.1.1-BETA")));
        assertEquals(-1, new Version("1.1.1-BETA").compareTo(new Version("1.1.1-BETA2")));
        assertEquals(-1, new Version("1.1.1-BETA").compareTo(new Version("1.1.1-BETA2")));
        assertEquals(-1, new Version("1.1.1-alpha").compareTo(new Version("1.1.1-beta")));
        assertEquals(-1, new Version("a").compareTo(new Version("b")));
        assertEquals(-1, new Version("b1").compareTo(new Version("b2")));
        assertEquals(-1, new Version("b1").compareTo(new Version("b2")));
    }
}
