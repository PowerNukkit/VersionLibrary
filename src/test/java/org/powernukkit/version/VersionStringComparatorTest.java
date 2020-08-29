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

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author joseobjr
 */
class VersionStringComparatorTest {
    @Test
    void simpleCompare() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "1","4","2.2","32.1","1.1","1.2","1.1.0.1-beta","b","a","z","K", "1.2-beta"
        ));
        list.sort(VersionStringComparator.getInstance());
        assertEquals(Arrays.asList(
                "a","b","K","z","1","1.1","1.1.0.1-beta","1.2-beta","1.2","2.2","4","32.1"
        ), list);
    }
}
