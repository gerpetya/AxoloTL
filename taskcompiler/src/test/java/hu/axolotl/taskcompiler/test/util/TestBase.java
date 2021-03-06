/*
 * Copyright (C) 2017 AutSoft Kft.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hu.axolotl.taskcompiler.test.util;

import com.google.testing.compile.JavaFileObjects;

import static com.google.common.truth.Truth.assertAbout;
import static com.google.testing.compile.JavaSourcesSubjectFactory.javaSources;

public abstract class TestBase {

    protected void assertWithComplexWorker(String generatedTaskName) {
        assertAbout(javaSources())
                .that(TestJavaUtils.withGeneral("good/ComplexWorker.java"))
                .processedWith(TestUtils.getProcessors())
                .compilesWithoutError()
                .and()
                .generatesSources(
                        JavaFileObjects.forResource("expected/complex/ComplexWorkerTaskHelper.java"),
                        JavaFileObjects.forResource("expected/complex/" + generatedTaskName + ".java")
                );
    }

}
