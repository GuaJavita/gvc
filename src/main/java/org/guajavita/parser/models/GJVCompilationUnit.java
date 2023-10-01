package org.guajavita.parser.models;

import java.util.List;

public record GJVCompilationUnit(String name,
                                 GJVPackage gjvPackage,
                                 List<GJVPackage> imports,
                                 List<GJVFunction> functions){
}
