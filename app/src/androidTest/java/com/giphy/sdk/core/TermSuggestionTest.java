/*
 * Created by Bogdan Tirca on 5/8/17.
 * Copyright (c) 2017 Giphy Inc.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.giphy.sdk.core;

import com.giphy.sdk.core.models.TermSuggestion;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.api.GPHApi;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.network.response.ListTermSuggestionResponse;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TermSuggestionTest {
    GPHApi imp;

    @Before
    public void setUp() throws Exception {
        imp = new GPHApiClient("4OMJYpPoYwVpe");
    }

    /**
     * Test if term suggestion endpoint returns data
     *
     * @throws Exception
     */
    @Test
    public void testBase() throws Exception {
        final CountDownLatch lock = new CountDownLatch(1);

        imp.termSuggestions("come", new CompletionHandler<ListTermSuggestionResponse>() {
            @Override
            public void onComplete(ListTermSuggestionResponse result, Throwable e) {
                Assert.assertNull(e);
                Assert.assertNotNull(result);
                Assert.assertTrue(result.getData().size() > 0);

                for (TermSuggestion termSuggestion : result.getData()) {
                    Assert.assertNotNull(termSuggestion.getTerm());
                }

                lock.countDown();
            }
        });
        lock.await(Utils.SMALL_DELAY, TimeUnit.MILLISECONDS);
    }

}
