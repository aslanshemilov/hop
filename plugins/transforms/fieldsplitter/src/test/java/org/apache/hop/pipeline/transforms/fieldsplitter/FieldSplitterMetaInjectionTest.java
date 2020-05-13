/*! ******************************************************************************
 *
 * Hop : The Hop Orchestration Platform
 *
 * http://www.project-hop.org
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.apache.hop.pipeline.transforms.fieldsplitter;

import org.apache.hop.core.injection.BaseMetadataInjectionTest;
import org.apache.hop.core.row.IValueMeta;
import org.apache.hop.core.row.value.ValueMetaString;
import org.apache.hop.junit.rules.RestoreHopEngineEnvironment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldSplitterMetaInjectionTest extends BaseMetadataInjectionTest<FieldSplitterMeta> {
  @ClassRule public static RestoreHopEngineEnvironment env = new RestoreHopEngineEnvironment();

  @Before
  public void setup() throws Exception {
    setup( new FieldSplitterMeta() );
  }

  @Test
  public void test() throws Exception {
    check( "FIELD_TO_SPLIT", new IStringGetter() {
      public String get() {
        return meta.getSplitField();
      }
    } );
    check( "DELIMITER", new IStringGetter() {
      public String get() {
        return meta.getDelimiter();
      }
    } );
    check( "ENCLOSURE", new IStringGetter() {
      public String get() {
        return meta.getEnclosure();
      }
    } );
    check( "NAME", new IStringGetter() {
      public String get() {
        return meta.getFieldName()[ 0 ];
      }
    } );
    check( "ID", new IStringGetter() {
      public String get() {
        return meta.getFieldID()[ 0 ];
      }
    } );
    check( "REMOVE_ID", new IBooleanGetter() {
      public boolean get() {
        return meta.getFieldRemoveID()[ 0 ];
      }
    } );
    check( "FORMAT", new IStringGetter() {
      public String get() {
        return meta.getFieldFormat()[ 0 ];
      }
    } );
    check( "GROUPING", new IStringGetter() {
      public String get() {
        return meta.getFieldGroup()[ 0 ];
      }
    } );
    check( "DECIMAL", new IStringGetter() {
      public String get() {
        return meta.getFieldDecimal()[ 0 ];
      }
    } );
    check( "CURRENCY", new IStringGetter() {
      public String get() {
        return meta.getFieldCurrency()[ 0 ];
      }
    } );
    check( "LENGTH", new IIntGetter() {
      public int get() {
        return meta.getFieldLength()[ 0 ];
      }
    } );
    check( "PRECISION", new IIntGetter() {
      public int get() {
        return meta.getFieldPrecision()[ 0 ];
      }
    } );
    check( "NULL_IF", new IStringGetter() {
      public String get() {
        return meta.getFieldNullIf()[ 0 ];
      }
    } );
    check( "DEFAULT", new IStringGetter() {
      public String get() {
        return meta.getFieldIfNull()[ 0 ];
      }
    } );

    IValueMeta mftt = new ValueMetaString( "f" );
    injector.setProperty( meta, "TRIM_TYPE", setValue( mftt, "none" ), "f" );
    assertEquals( 0, meta.getFieldTrimType()[ 0 ] );
    injector.setProperty( meta, "TRIM_TYPE", setValue( mftt, "left" ), "f" );
    assertEquals( 1, meta.getFieldTrimType()[ 0 ] );
    injector.setProperty( meta, "TRIM_TYPE", setValue( mftt, "right" ), "f" );
    assertEquals( 2, meta.getFieldTrimType()[ 0 ] );
    injector.setProperty( meta, "TRIM_TYPE", setValue( mftt, "both" ), "f" );
    assertEquals( 3, meta.getFieldTrimType()[ 0 ] );
    skipPropertyTest( "TRIM_TYPE" );

    // TODO check field type plugins
    skipPropertyTest( "DATA_TYPE" );
  }
}
