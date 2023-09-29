package org.guajavita.parser;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Walker extends GuajavitaParserBaseListener {

    private static final Logger LOG = LogManager.getLogger(Walker.class);
    @Override
    public void enterPackageClause(GuajavitaParserParser.PackageClauseContext ctx) {
        System.out.println("Package Name " + ctx.IDENTIFIER().getText());
    }

    @Override
    public void enterImportDecl(GuajavitaParserParser.ImportDeclContext ctx) {
        Context.get().addImport(ctx.IDENTIFIER().getText());
        System.out.println("Importing "+ctx.IDENTIFIER().getText());
    }

    @Override
    public void enterFunction(GuajavitaParserParser.FunctionContext ctx) {
        var params = new ArrayList<GJVFunctionParam>(ctx.funcParams().IDENTIFIER().size());
        for (int i = 0; i < ctx.funcParams().types().size(); i++) {
            params.add(new GJVFunctionParam(ctx.funcParams().types(i).getText(),
                    ctx.funcParams().IDENTIFIER(i).getText()));
        }
        var statement = ctx.block().statement();
        var body = "";
        if (statement!=null){
            body= statement.getText();
        }
        var func = new GJVFunction(ctx.types().getText(),
                ctx.IDENTIFIER().getText(),
                params,body);
        LOG.info("Found Function {}",func );
        super.enterFunction(ctx);
    }
}
