/**
 * Copyright © 2019 Konrad Kügler (swamblumat-git@yahoo.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.kkuegler;

import org.junit.Assert;
import org.junit.Test;

public class HumanReadableIdGeneratorTest {

    @Test
    public void testGenerate() {
        PermutationBasedHumanReadableIdGenerator
                objectUnderTest = new PermutationBasedHumanReadableIdGenerator();
        String id = objectUnderTest.generate();
        String[] parts = id.split("-");
        Assert.assertEquals(3, parts.length);

        String id2 = objectUnderTest.generate();
        Assert.assertNotEquals(id, id2);
    }
}
