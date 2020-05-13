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

package org.apache.hop.pipeline.transforms.systemdata;

import org.apache.hop.core.injection.BaseMetadataInjectionTest;
import org.junit.Before;
import org.junit.Test;

public class SystemDataMetaInjectionTest extends BaseMetadataInjectionTest<SystemDataMeta> {

  @Before
  public void setup() throws Exception {
    setup( new SystemDataMeta() );
  }

  @Test
  public void test() throws Exception {
    check( "FIELD_NAME", new StringGetter() {
      @Override
      public String get() {
        return meta.getFieldName()[ 0 ];
      }
    } );
    check( "FIELD_TYPE", new EnumGetter() {
      @Override
      public Enum<?> get() {
        return meta.getFieldType()[ 0 ];
      }
    }, SystemDataTypes.class );
  }
}
