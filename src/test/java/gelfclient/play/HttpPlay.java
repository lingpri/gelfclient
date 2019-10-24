package gelfclient.play;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.logging.LoggingHandler;
import org.graylog2.gelfclient.GelfConfiguration;
import org.graylog2.gelfclient.GelfMessage;
import org.graylog2.gelfclient.GelfTransports;

import org.graylog2.gelfclient.transport.GelfTransport;
import java.util.concurrent.TimeUnit;

public class HttpPlay {

    private final static int GELP_HTTP_PORT = 42323;


    public static void main(String... args) throws InterruptedException ,Exception {

        final GelfConfiguration configuration = new GelfConfiguration(GELP_HTTP_PORT)
                .transport(GelfTransports.HTTP)
                //.tcpKeepAlive(true)
                .queueSize(2048)
                .reconnectDelay(5000);



        final GelfTransport transport = GelfTransports.create(configuration);


        int count = 0;
        while (count < 50) {

            final GelfMessage msg = new GelfMessage("Howdy world! " + count + " " + configuration.getTransport().toString());

            count++;

            msg.addAdditionalField("_count", count);
            msg.addAdditionalField("_oink", 1.231);
            msg.addAdditionalField("_objecttest", new Object());
            transport.send(msg);
            TimeUnit.SECONDS.sleep(5);

        }

    }


}
