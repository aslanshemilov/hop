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

package org.apache.hop.pipeline.transforms.xml.xmljoin;

import org.apache.hop.core.injection.BaseMetadataInjectionTest;
import org.apache.hop.junit.rules.RestoreHopEngineEnvironment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by ecuellar on 3/3/2016.
 */
public class XMLJoinMetaInjectionTest extends BaseMetadataInjectionTest<XmlJoinMeta> {
  @ClassRule public static RestoreHopEngineEnvironment env = new RestoreHopEngineEnvironment();

  @Before
  public void setup() {

    try{
      setup( new XmlJoinMeta() );
    }catch(Exception e){

    }
  }

  @Test
  @Ignore
  public void test() throws Exception {

    check( "COMPLEX_JOIN", new IBooleanGetter() {
      public boolean get() {
        return meta.isComplexJoin();
      }
    } );

    check( "TARGET_XML_STEP", new IStringGetter() {
      public String get() {
        return meta.getTargetXmlField();
      }
    } );

    check( "TARGET_XML_FIELD", new IStringGetter() {
      public String get() {
        return meta.getTargetXmlField();
      }
    } );

    check( "SOURCE_XML_FIELD", new IStringGetter() {
      public String get() {
        return meta.getSourceXmlField();
      }
    } );

    check( "VALUE_XML_FIELD", new IStringGetter() {
      public String get() {
        return meta.getValueXmlField();
      }
    } );

    check( "TARGET_XPATH", new IStringGetter() {
      public String get() {
        return meta.getTargetXPath();
      }
    } );

    check( "SOURCE_XML_STEP", new IStringGetter() {
      public String get() {
        return meta.getSourceXmlStep();
      }
    } );

    check( "JOIN_COMPARE_FIELD", new IStringGetter() {
      public String get() {
        return meta.getJoinCompareField();
      }
    } );

    check( "ENCODING", new IStringGetter() {
      public String get() {
        return meta.getEncoding();
      }
    } );

    check( "OMIT_XML_HEADER", new IBooleanGetter() {
      public boolean get() {
        return meta.isOmitXmlHeader();
      }
    } );

    check( "OMIT_NULL_VALUES", new IBooleanGetter() {
      public boolean get() {
        return meta.isOmitNullValues();
      }
    } );
  }
}
