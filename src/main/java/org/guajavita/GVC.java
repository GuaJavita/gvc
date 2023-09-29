package org.guajavita;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.guajavita.cli.compiler.CompileCmd;
import picocli.CommandLine;


import java.util.concurrent.Callable;

@CommandLine.Command(name = "gvc",
        mixinStandardHelpOptions = true,
        version = Version.FULL,
        subcommands = {CompileCmd.class}
)
public final class GVC implements Callable<Integer> {

    private static final Logger LOG = LogManager.getLogger(GVC.class);
    private static final CommandLine cmd = new CommandLine(new GVC());

    @CommandLine.Option(names = "-v")
    public void setVerbosity(String level) {
       Configurator.setLevel("org.guajavita", level);
    }

    public static void main(String[] args) {
        int exitCode = cmd.execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {

        throw new CommandLine.ParameterException(cmd, "Missing command");
    }
}
