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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.stream.IntStream;

/**
 * Base class for id generators. Provides the word lists and other infrastructure.
 */
public abstract class AbstractHumanReadableIdGenerator implements HumanReadableIdGenerator {

    protected final String[] animals;

    protected final String[] adjectives;

    protected final String[] numbers = IntStream.range(0, 100).mapToObj(Integer::toString).toArray(String[]::new);

    protected final SecureRandom random = new SecureRandom();

    protected AbstractHumanReadableIdGenerator() {
        ClassLoader classLoader = AbstractHumanReadableIdGenerator.class.getClassLoader();
        try (InputStream data = classLoader.getResourceAsStream("animals.txt")) {
            animals = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8)).lines().toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (InputStream data = classLoader.getResourceAsStream("adjectives.txt")) {
            adjectives = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8)).lines().toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Fisher-Yates shuffle (inside-out variant)
     *
     * @return a shuffled copy of the input
     */
    protected String[] randomize(String[] input) {
        // each iteration creates a sub-permutation of the input sub-array from indices 0..i, adding in the next input[i+1]
        // at a random position within the sub-permutation, finally creating a random permutation of the whole input
        int len = input.length;
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            int j = random.nextInt(i + 1); // new position for input[i]
            if (i != j) {
                result[i] = result[j]; // rescue old value
            }
            result[j] = input[i];
        }
        return result;
    }
}
