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

import java.util.*;

/**
 * A generator for human-readable ids.<br>
 * This implementation tries to avoid re-using individual parts of the id, i.e. it will not generate
 * 'happy-tiger-42' and 'happy-ant-42' consecutively. To do this it uses permutations of the word lists of each part of the id.<br>
 * For small numbers of generated ids this makes the ids even more distinguishable.
 */
public class PermutationBasedHumanReadableIdGenerator extends AbstractHumanReadableIdGenerator {

    private final Deque<String> availableAnimals = new ArrayDeque<>();

    private final Deque<String> availableAdjectives = new ArrayDeque<>();

    private final Deque<String> availableNumbers = new ArrayDeque<>();

    public PermutationBasedHumanReadableIdGenerator() {
        super();
    }

    @Override
    public String generate() {
        synchronized (this) {
            if (availableAdjectives.isEmpty()) {
                availableAdjectives.addAll(Arrays.asList(randomize(adjectives)));
            }
            String adjective = availableAdjectives.removeLast();

            if (availableAnimals.isEmpty()) {
                availableAnimals.addAll(Arrays.asList(randomize(animals)));
            }
            String animal = availableAnimals.removeLast();

            if (availableNumbers.isEmpty()) {
                availableNumbers.addAll(Arrays.asList(randomize(numbers)));
            }
            String number = availableNumbers.removeLast();

            return adjective + "-" + animal + "-" + number;
        }
    }

}
