/*
 * Copyright 2006-2017 the original author or authors.
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

package com.consol.citrus.simulator.sample.starter;

import com.consol.citrus.simulator.model.ScenarioParameter;
import com.consol.citrus.simulator.model.ScenarioParameterBuilder;
import com.consol.citrus.simulator.scenario.*;

import java.util.*;

/**
 * @author Christoph Deppisch
 */
@Starter("HelloStarter")
public class HelloStarter extends AbstractScenarioStarter {

    @Override
    public void run(ScenarioRunner scenario) {
        scenario.echo("${title} ${firstname} ${lastname} ");
        scenario.echo("${greeting}");
    }

    @Override
    public Collection<ScenarioParameter> getScenarioParameters() {
        List<ScenarioParameter> scenarioParameters = new ArrayList<>();

        // title (dropdown)
        scenarioParameters.add(new ScenarioParameterBuilder()
                .name("title")
                .label("Title")
                .required()
                .dropdown()
                .addOption("Mr", "Mr.")
                .addOption("Mrs", "Mrs.")
                .addOption("Miss", "Miss")
                .value("Miss")
                .build());

        // firstname (text box)
        scenarioParameters.add(new ScenarioParameterBuilder()
                .name("firstname")
                .label("First Name")
                .required()
                .textbox()
                .value("Mickey")
                .build());

        // lastname (text box)
        scenarioParameters.add(new ScenarioParameterBuilder()
                .name("lastname")
                .label("Last Name")
                .required()
                .textbox()
                .value("Mouse")
                .build());


        // greeting (text area)
        scenarioParameters.add(new ScenarioParameterBuilder()
                .name("greeting")
                .label("Greeting")
                .required()
                .textarea()
                .value("Hey there Mini")
                .build());

        return scenarioParameters;
    }
}