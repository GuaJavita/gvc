package org.guajavita.cli.compiler;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.guajavita.parser.GuajavitaLexer;
import org.guajavita.parser.GuajavitaParserParser;
import org.guajavita.parser.Walker;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

@CommandLine.Command(name = "compile",
        description = "Compile gjv files"
)
public class CompileCmd implements Runnable {
    private static final Logger LOG = LogManager.getLogger(CompileCmd.class);

    @CommandLine.Parameters()
    private File sourceFile;

    @Override
    public void run() {
        LOG.trace("Reading gjv file {}", sourceFile.getPath());
        GuajavitaLexer lexer = null;

        try {
            lexer = new GuajavitaLexer(CharStreams.fromFileName(sourceFile.getPath()));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            GuajavitaParserParser parser = new GuajavitaParserParser(tokens);
            ParseTree tree = parser.program();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new Walker(), tree);
        } catch (IOException e) {
            LOG.error("File {} not found", sourceFile.getPath());
        }

    }
}

