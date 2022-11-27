package top.xtijie.rcondavframework.rcon;

import nl.vv32.rcon.Rcon;
import nl.vv32.rcon.RconBuilder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class SimpleRconSource implements RconSource {

    private String hostName;
    private int port;
    private String password;
    private volatile Rcon rcon;

    public SimpleRconSource() {
    }

    public SimpleRconSource(String hostName, int port, String password) {
        this.hostName = hostName;
        this.port = port;
        this.password = password;
    }

    public SimpleRconSource(Rcon rcon) {
        this.rcon = rcon;
    }

    @Override
    public String toString() {
        return "SimpleRconSource{" +
                "hostName='" + hostName + '\'' +
                ", port=" + port +
                ", password='" + ((password == null || password.equals("")) ? "null" : "xxxxxx") + '\'' +
                '}';
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rcon getRcon() throws IOException {
        return rcon;
    }

    public RconSource open() throws IOException {
        if (rcon == null) {
            synchronized (SimpleRconSource.class) {
                if (rcon == null) {
                    SocketChannel channel = SocketChannel.open(new InetSocketAddress(hostName, port));
                    channel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
                    Rcon rcon = new RconBuilder()
                            .withChannel(channel)
                            .withCharset(StandardCharsets.UTF_8)
                            .build();
                    rcon.authenticate(password);
                    this.rcon = rcon;
                }
            }
        }
        return this;
    }


}
