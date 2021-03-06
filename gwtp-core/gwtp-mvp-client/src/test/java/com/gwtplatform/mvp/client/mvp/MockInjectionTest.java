/*
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.mvp.client.mvp;

import javax.inject.Inject;

import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.jukito.TestSingleton;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.TypeLiteral;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * Test behaviour when a mock {@link PresenterWidget} is injected.
 */
@RunWith(JukitoRunner.class)
public class MockInjectionTest {

    /**
     * Guice test module.
     */
    public static class Module extends JukitoModule {
        @Override
        protected void configureTest() {
            bindNamedMock(new TypeLiteral<PresenterWidget<View>>() {
            }, "Sub").in(TestSingleton.class);
            bind(EventBus.class).to(SimpleEventBus.class).in(TestSingleton.class);
        }
    }

    // SUT
    @Inject
    MainPresenterTestUtil mainPresenter;

    @Test
    public void settingSubPresenterShouldNotCrash() {
        // When
        mainPresenter.setSubPresenter();
    }
}
