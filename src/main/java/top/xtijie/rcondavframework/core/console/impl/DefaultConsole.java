package top.xtijie.rcondavframework.core.console.impl;

import top.xtijie.rcondavframework.core.console.AbstractConsole;
import top.xtijie.rcondavframework.core.enhancer.check.anno.Check;
import top.xtijie.rcondavframework.core.enhancer.check.re.impl.DiscolorCodeReturnCheck;

import java.io.IOException;

public class DefaultConsole extends AbstractConsole {


    @Check(reCla = DiscolorCodeReturnCheck.class)
    public String sendCommand(String command) throws IOException {
        return rcon.sendCommand(command);
    }

}
