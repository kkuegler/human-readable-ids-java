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

import java.util.Random;

/**
 * A simple generator for human-readable ids which chooses each of the id's parts randomly.
 */
public class RandomHumanReadableIdGenerator extends AbstractHumanReadableIdGenerator {

    public RandomHumanReadableIdGenerator() {
        super();
    }

    public RandomHumanReadableIdGenerator(Random random) {
        super(random);
    }

    @Override
    public String generate() {
        String adjective = adjectives[random.nextInt(adjectives.length)];
        String animal = animals[random.nextInt(animals.length)];
        String number = numbers[random.nextInt(numbers.length)];
        return adjective + "-" + animal + "-" + number;
    }
}
