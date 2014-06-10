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

/**
 * @author Bernd Ahlers <bernd@torch.sh>
 */
public class Configuration {
    private String host = "127.0.0.1";
    private int port = 12201;
    private int queueSize = 5;
    private GelfTransports protocol = GelfTransports.TCP;
    private int reconnectDelay = 1000;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public GelfTransports getProtocol() {
        return protocol;
    }

    public void setProtocol(GelfTransports protocol) {
        this.protocol = protocol;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int size) {
        queueSize = size;
    }

    public int getReconnectDelay() {
        return reconnectDelay;
    }

    public void setReconnectDelay(int reconnectDelay) {
        this.reconnectDelay = reconnectDelay;
    }

}
