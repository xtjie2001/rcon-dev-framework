package top.xtijie.rcondavframework.core.console;

import nl.vv32.rcon.Rcon;
import top.xtijie.rcondavframework.rcon.RconSource;
import top.xtijie.rcondavframework.utils.RconDepository;

import java.io.IOException;

public abstract class AbstractConsole {

    protected Rcon rcon;

    {
        rcon = RconDepository.fetch(Rcon.class);
    }


    protected void destroy() {
    }

    protected void init() {
    }


    /**
     * <p>此方法主要用于解决CacheConsoleManager中的一些bug</p>
     * <p>使用CacheConsoleManager时,其子类请不要重写此方法,否则会出现一些不可预料的错误</p>
     */
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
