/*
 * Copyright 2012-2014 TORCH GmbH
 *
 * This file is part of Graylog2.
 *
 * Graylog2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog2.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.graylog2.gelfclient;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

public class GelfConfigurationTest {
    private GelfConfiguration config;

    @BeforeMethod
    public void setup() {
        this.config = new GelfConfiguration();
    }

    @Test
    public void testQueueSize() {
        // Check default value.
        assertEquals(512, config.getQueueSize());

        config.setQueueSize(124);

        assertEquals(124, config.getQueueSize());
    }

    @Test
    public void testHost() {
        // Check default value.
        assertEquals("127.0.0.1", config.getHost());

        config.setHost("10.0.0.1");

        assertEquals("10.0.0.1", config.getHost());
    }

    @Test
    public void testPort() {
        // Check default value.
        assertEquals(12201, config.getPort());

        config.setPort(10000);

        assertEquals(10000, config.getPort());
    }

    @Test
    public void testTransport() {
        // Check default value.
        assertEquals(GelfTransports.TCP, config.getTransport());

        // We only have TCP for now so this is pretty useless.
        config.setTransport(GelfTransports.TCP);

        assertEquals(GelfTransports.TCP, config.getTransport());
    }

    @Test
    public void testReconnectDelay() {
        // Check default value.
        assertEquals(500, config.getReconnectDelay());

        config.setReconnectDelay(5000);

        assertEquals(5000, config.getReconnectDelay());
    }

    @Test
    public void testConnectTimeout() {
        // Check default value.
        assertEquals(1000, config.getConnectTimeout());

        config.setConnectTimeout(10000);

        assertEquals(10000, config.getConnectTimeout());
    }

    @Test
    public void testtcpNoDelay() {
        // Check default value.
        assertEquals(false, config.isTcpNoDelay());

        config.setTcpNoDelay(true);

        assertEquals(true, config.isTcpNoDelay());
    }

    @Test
    public void testSendBufferSize() {
        // Check default value.
        assertEquals(-1, config.getSendBufferSize());

        config.setSendBufferSize(32768);

        assertEquals(32768, config.getSendBufferSize());
    }
}