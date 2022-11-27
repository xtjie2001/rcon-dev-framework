package top.xtijie.rcondavframework.rcon;

import nl.vv32.rcon.Rcon;

import java.io.IOException;

public interface RconSource {

    public abstract Rcon getRcon() throws IOException;
}
