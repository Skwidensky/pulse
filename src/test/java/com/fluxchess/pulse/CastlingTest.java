/*
 * Copyright 2013-2014 the original author or authors.
 *
 * This file is part of Pulse Chess.
 *
 * Pulse Chess is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Pulse Chess is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Pulse Chess.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxchess.pulse;

import com.fluxchess.jcpi.models.GenericCastling;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static com.fluxchess.test.AssertUtil.assertUtilityClassWellDefined;
import static org.junit.Assert.*;

public class CastlingTest {

  @Test
  public void testUtilityClass() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertUtilityClassWellDefined(Castling.class);
  }

  @Test
  public void testValues() {
    for (GenericCastling genericCastling : GenericCastling.values()) {
      assertEquals(genericCastling, Castling.Type.toGenericCastling(Castling.Type.valueOf(genericCastling)));
      assertEquals(genericCastling.ordinal(), Castling.Type.valueOf(genericCastling));
      assertEquals(Castling.Type.valueOf(genericCastling), Castling.Type.values[Castling.Type.valueOf(genericCastling)]);
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidToGenericCastling() {
    Castling.Type.toGenericCastling(Castling.Type.NOCASTLINGTYPE);
  }

  @Test
  public void testIsValid() {
    for (int castling : Castling.Type.values) {
      assertTrue(Castling.Type.isValid(castling));
    }

    assertFalse(Castling.Type.isValid(Castling.Type.NOCASTLINGTYPE));
  }

}
